package chordCalculatorDataModel;

import java.util.List;

public class ChordNameCalculator {
    private final Chord chord;
    private final ChordInfoObject chordInfoObject;
    protected final List<Integer> semiTones;
    
    private final int MINOR_SECOND = 1;
    private final int MAJOR_SECOND = 2;
    private final int MINOR_THIRD = 3;
    private final int MAJOR_THIRD = 4;
    private final int PERFECT_FOURTH = 5;
    private final int FLAT_FIFTH = 6;
    private final int PERFECT_FIFTH = 7;
    private final int SHARP_FIFTH = 8;
    private final int MINOR_SIXTH = 8;
    private final int MAJOR_SIXTH = 9;
    private final int MINOR_SEVENTH = 10;
    private final int MAJOR_SEVENTH = 11;
    

    private boolean sus2HasBeenAdded = false;
    private boolean sus4HasBeenAdded = false;
    private boolean theChordIsDiminished = false;

    public ChordNameCalculator(Chord chord, ChordInfoObject chordInfoObject) {
        this.chord = chord;
        this.chordInfoObject = chordInfoObject;
        this.semiTones = chord.getSemiTonesInRelationToLowestNote();
    }

    public ChordInfoObject calculate(){
        String root = getRoot();
        root = formatRoot(root);
        chordInfoObject.setRoot(root);
        calculateLowerStructure();
        calculateSusses();
        calculateFifth();
        calculateExtensionsIfNoSeventhElseCalculateAdds();
        return chordInfoObject;
    }

    private String getRoot(){
        String notenNaam = chord.getNotes().get(0).getNoteName();
        if (stringIsNotEmptyOrNull(notenNaam)){
            return notenNaam;
        }
        return "";
    }

    private String formatRoot(String root){
        return root.substring(0,1).toUpperCase() + root.substring(1);
    }

    private void calculateLowerStructure(){
        pickMajorMinorOrDiminished();
        processNoThird();
        processNoFifth();
        processSharpNine();
    }

    private void setLowerStructureToMajor(){
        //major is the default, and represented by absence of a symbol
    }

    private void setLowerStructureToDiminished(){
        chordInfoObject.getLowerStructure().add("dim");
        theChordIsDiminished = true;
    }

    private void calculateSusses(){
        if (!semiTones.contains(MINOR_THIRD) && !semiTones.contains(MAJOR_THIRD)) {
            addSus2IfNecessary();
            addSus4IfNecessary();
        }
    }

    private void calculateFifth(){
        processFlatFifth();
        processSharpFifth();
    }

    private void calculateExtensionsIfNoSeventhElseCalculateAdds(){
        if (thereAreAnySevenths()) {
            calculateExtensions();
        } else {
            calculateAdds();
        }
    }

    private void calculateExtensions(){
        calculateSevenths();
        calculateNinths();
        calculateElevenths();
        calculateThirteens();
    }

    private void calculateSevenths(){
        processHalfDiminished();
        processFlatSeventh();
        processMajorSeventh();
    }

    private void setLowerStructureToHalfDiminished(){
        chordInfoObject.getLowerStructure().clear();
        chordInfoObject.getLowerStructure().add("halfdiminished");
    }

    private void calculateNinths() {
        processFlatNinth();
        processNinth();
    }

    private void calculateElevenths(){
        processEleventh();
        processSharpEleventh();
    }

    private void calculateThirteens(){
        processFlatThirteenth();
        processThirteenth();
    }

    private void calculateAdds(){
        addSixths();
        addSeconds();
        addFourths();
    }

    private void pickMajorMinorOrDiminished(){
        if (semiTones.contains(MAJOR_THIRD)) {
            setLowerStructureToMajor();
        } else if (theLowerStructureIsDiminished()){
            setLowerStructureToDiminished();
        } else if (theLowerStructureIsMinor()) {
            setLowerStructureToMinor();
        }
    }

    private void processNoThird(){
        if (thereIsNoThirdOrSus()){
            addNoThirdToNoThirdOrNoFifth();
        }
    }

    private void processNoFifth(){
        if (thereIsNoFifthAtAll()){
            addNoFifthToNoThirdOrNoFifth();
        }
    }

    private void processSharpNine(){
        if (semiTones.contains(MAJOR_THIRD) && semiTones.contains(MINOR_THIRD)) {
            addSharpNineToAlterations();
        }
    }

    private void processFlatFifth(){
        if (theChordIsAFlatFiveChord()){
            addFlatFifthToAlterations();
        }
    }

    private void processSharpFifth(){
        if (theChordIsASharpFiveChord()){
            addSharpFifthToAlterations();
        }
    }

    private void processHalfDiminished(){
        if (theChordIsHalfDiminished()){
            setLowerStructureToHalfDiminished();
        }
    }

    private void processFlatSeventh(){
        if (semiTones.contains(MINOR_SEVENTH) || theChordIsADiminishedSevenChord()) {
            addSeventhToExtensions();
        }
    }

    private void processMajorSeventh(){
        if (semiTones.contains(MAJOR_SEVENTH)) {
            addMajorSeventhToExtensions();
        }
    }

    private void processFlatNinth(){
        if (semiTones.contains(MINOR_SECOND)) {
            addFlatNinthToAlterations();
        }
    }

    private void processNinth(){
        if (theChordIsANineChord()) {
            addNinthToExtensions();
        }
    }

    private void processEleventh(){
        if (theChordIsAnElevenChord()) {
            addEleventhToExtensions();
        }
    }

    private void processSharpEleventh(){
        if (theChordIsASharpElevenChord()) {
            addSharpEleventhToAlterations();
        }
    }

    private void processFlatThirteenth(){
        if ((semiTones.contains(MINOR_SIXTH) && semiTones.contains(PERFECT_FIFTH))
            || semiTones.contains(MINOR_SIXTH) && !theChordIsNotMinor()){
            addFlatThirteenthToAlterations();
        }
    }

    private void processThirteenth(){
        if (semiTones.contains(MAJOR_SIXTH) && !theChordIsDiminished){
            addThirteenthToExtensions();
        }
    }

    private void processMinorSixth(){
        if (theChordIsAMinorSixChord() && !semiTones.contains(MAJOR_THIRD) ||
            semiTones.contains(MAJOR_THIRD) && semiTones.contains(MINOR_SIXTH) &&
            semiTones.contains(PERFECT_FIFTH)){
            addFlatSixthToAlterations();
            setNo5thIfTheChordIsAMinor6thAndThereIsNoPerfectOrFlatFifth();
        }
    }

    private void processMajorSixth(){
        if (theChordIsASixChord()){
            addSixthToExtensions();
        }
    }

    private void processMinorSecond(){
        if (semiTones.contains(MINOR_SECOND)) {
            addMinorSecondToAlterations();
        }
    }

    private void processSecond(){
        if (theChordIsATwoChord()) {
            addSecondToAdds();
        }
    }

    private void processFourth(){
        if (theChordIsAFourChord()) {
            addFourthToAdds();
        }
    }

    private void processSharpFourth(){
        if (theChordIsASharpFourChord()){
            addSharpFourthToAlterations();
        }
    }
    private void addSus2IfNecessary(){
        if (semiTones.contains(MAJOR_SECOND)){
            addSus2ToSusses();
        }
    }

    private void addFlatFifthToAlterations(){
        chordInfoObject.getAlterations().add("b5");
    }

    private void addSharpFifthToAlterations(){
        chordInfoObject.getAlterations().add("#5");
    }

    private void addSus2ToSusses(){
        chordInfoObject.getSusses().add("sus2");
        sus2HasBeenAdded = true;
    }

    private void addSus4IfNecessary(){
        if (semiTones.contains(PERFECT_FOURTH) && sus2HasBeenAdded){
            add4tosus2();
        } else if (semiTones.contains(PERFECT_FOURTH)){
            addSus4ToSusses();
        }
    }

    private void add4tosus2(){
        chordInfoObject.getSusses().add(",4");
        sus4HasBeenAdded = true;
    }

    private void addSus4ToSusses(){
        chordInfoObject.getSusses().add("sus4");
        sus4HasBeenAdded = true;
    }

    private void addSeventhToExtensions(){
        chordInfoObject.getExtensions().add("7");
    }

    private void addMajorSeventhToExtensions(){
        if (semiTones.contains(MINOR_SEVENTH) || semiTones.contains(MAJOR_THIRD) || theChordIsDiminished &&
                semiTones.contains(MAJOR_SIXTH)) {
            chordInfoObject.getExtensions().add("maj7");
        } else {
            chordInfoObject.getExtensions().add(",maj7");
        }
    }

    private void addFlatNinthToAlterations(){
        chordInfoObject.getAlterations().add("b9");
    }

    private void addNinthToExtensions(){
        chordInfoObject.getExtensions().add("9");
    }

    private void addFlatThirteenthToAlterations(){
        chordInfoObject.getAlterations().add("b13");
    }

    private void addThirteenthToExtensions(){
        chordInfoObject.getExtensions().add("13");
    }

    private void addEleventhToExtensions(){
        chordInfoObject.getExtensions().add("11");
    }

    private void addSharpEleventhToAlterations(){
        chordInfoObject.getAlterations().add("#11");
    }

    private void addSixths(){
        processMinorSixth();
        processMajorSixth();
    }

    private void setNo5thIfTheChordIsAMinor6thAndThereIsNoPerfectOrFlatFifth(){
        if (theChordIsAMinorSixChord() && !semiTones.contains(PERFECT_FIFTH) && !semiTones.contains(FLAT_FIFTH)
            && !semiTones.contains(MAJOR_THIRD)){
            addNoFifthToNoThirdOrNoFifth();
        }
    }

    private void addFlatSixthToAlterations(){
        chordInfoObject.getAlterations().add("b6");
    }

    private void addSixthToExtensions(){
        chordInfoObject.getExtensions().add("6");
    }

    private void addSeconds(){
        processMinorSecond();
        processSecond();
    }

    private void addMinorSecondToAlterations(){
        chordInfoObject.getAlterations().add("b2");
    }

    private void addSecondToAdds(){
        chordInfoObject.getAdds().add(",add2");
    }

    private void addNoThirdToNoThirdOrNoFifth(){
        chordInfoObject.getNo3rdNo5th().add("no 3rd");
    }

    private void addNoFifthToNoThirdOrNoFifth(){
        chordInfoObject.getNo3rdNo5th().add("no 5th");
    }

    private void addFourths(){
        processFourth();
        processSharpFourth();
    }

    private void addFourthToAdds(){
        chordInfoObject.getAdds().add(",add4");
    }

    private void addSharpFourthToAlterations(){
        chordInfoObject.getAlterations().add("#4");
    }

    private boolean stringIsNotEmptyOrNull(String stringToCheck){
        return stringToCheck != null && !stringToCheck.isEmpty();
    }

    private boolean theLowerStructureIsMinor(){
        return semiTones.contains(MINOR_THIRD) && !semiTones.contains(MAJOR_THIRD);
    }

    private void setLowerStructureToMinor(){
        chordInfoObject.getLowerStructure().add("minor");
    }

    private void addSharpNineToAlterations(){
        chordInfoObject.getAlterations().add("#9");
    }

    private boolean theLowerStructureIsDiminished(){
        return semiTones.contains(MINOR_THIRD) && semiTones.contains(FLAT_FIFTH) && !semiTones.contains(PERFECT_FIFTH) && !semiTones.contains(MAJOR_THIRD);
    }
    
    private boolean thereIsNoThirdOrSus(){
        return !semiTones.contains(MAJOR_SECOND) && !semiTones.contains(MINOR_THIRD) && !semiTones.contains(MAJOR_THIRD) && !semiTones.contains(PERFECT_FOURTH);
    }

    private boolean theChordIsAFlatFiveChord(){
        return semiTones.contains(FLAT_FIFTH) && !theChordIsDiminished && !semiTones.contains(PERFECT_FIFTH);
    }

    private boolean theChordIsASharpFiveChord(){
        return semiTones.contains(SHARP_FIFTH) && (theChordIsNotMinor()
                || semiTones.contains(MAJOR_THIRD)) && !semiTones.contains(PERFECT_FIFTH);//in case of #9
    }

    private boolean thereIsNoFifthAtAll() {
        return (!semiTones.contains(FLAT_FIFTH) && !semiTones.contains(PERFECT_FIFTH) && !semiTones.contains(SHARP_FIFTH));
//                || (!semiTones.contains(FLAT_FIFTH) && !semiTones.contains(PERFECT_FIFTH) && !theChordIsNotMinor()) ;
    }
    
    private boolean theChordIsNotMinor(){
        return !semiTones.contains(MINOR_THIRD);
    }

    private boolean thereAreAnySevenths(){
        return semiTones.contains(MINOR_SEVENTH) || semiTones.contains(MAJOR_SEVENTH) || (semiTones.contains(MAJOR_SIXTH) && theChordIsDiminished);
    }

    private boolean theChordIsHalfDiminished(){
        return (semiTones.contains(MINOR_SEVENTH) && theChordIsDiminished);
    }

    private boolean theChordIsADiminishedSevenChord(){
        return (semiTones.contains(MAJOR_SIXTH) && theChordIsDiminished);
    }
    
    private boolean theChordIsANineChord(){
        return semiTones.contains(MAJOR_SECOND) && !sus2HasBeenAdded;
    }

    private boolean theChordIsAnElevenChord(){
        return semiTones.contains(PERFECT_FOURTH) && !sus4HasBeenAdded;
    }

    private boolean theChordIsASharpElevenChord(){
        return semiTones.contains(FLAT_FIFTH) && semiTones.contains(PERFECT_FIFTH);
    }

    private boolean theChordIsAMinorSixChord(){
        return (semiTones.contains(MINOR_SIXTH) && semiTones.contains(PERFECT_FIFTH)) ||
                (semiTones.contains(MINOR_SIXTH) && semiTones.contains(MINOR_THIRD));
    }

    private boolean theChordIsASixChord(){
        return semiTones.contains(MAJOR_SIXTH) && !theChordIsDiminished;
    }

    private boolean theChordIsATwoChord(){
        return semiTones.contains(MAJOR_SECOND) && !sus2HasBeenAdded;
    }

    private boolean theChordIsAFourChord(){
        return semiTones.contains(PERFECT_FOURTH) && !sus4HasBeenAdded;
    }

    private boolean theChordIsASharpFourChord(){
        return semiTones.contains(FLAT_FIFTH) && !sus4HasBeenAdded && !theChordIsDiminished && semiTones.contains(PERFECT_FIFTH);
    }
}
