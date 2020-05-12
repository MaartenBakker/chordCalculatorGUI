package chordCalculatorDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


/**
 - maak functie voor slashbenaming
 **/

public class ChordCalculatorMain {

    public static void main(String[] args) {

//        ChordDictonary.createMapVanAkkoordTypes();

        List<Note> notes = new ArrayList<>();

        notes.add(new Note("a"));
        notes.add(new Note("c"));
        notes.add(new Note("eb"));
        notes.add(new Note("f#"));
        notes.add(new Note("f"));
//        notes.add(new Note("b"));
//        notes.add(new Note("d"));
//        notes.add(new Note("d#"));
//        notes.add(new Note("f"));
        System.out.println(notes);

        getNameOfChordAndAllInversions(notes);
    }

    public static String getNameOfChordAndAllInversions(List<Note> notes){
        Chord chord = new Chord(notes);
        ChordNameCalculator chordNameCalculator;
        ChordNameStringBuilder chordNameStringBuilder;
        StringJoiner sj = new StringJoiner("\n");
        String name;
        String names = "";


        for (int i = 0; i < notes.size(); i++) {
            ChordInfoObject chordInfoObject = new ChordInfoObject();
            chordNameCalculator = new ChordNameCalculator(chord, chordInfoObject);
            chordInfoObject = chordNameCalculator.calculate();
            chordNameStringBuilder = new ChordNameStringBuilder(chordInfoObject);
            name = chordNameStringBuilder.getBuiltName();

            System.out.println(chord.getNotes());
            System.out.println(name);
            System.out.println();
            sj.add(name);
            chord = chord.getNextInversion();
        }

        names = sj.toString();

        return names;
    }

}
