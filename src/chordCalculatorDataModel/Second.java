package chordCalculatorDataModel;

public class Second extends Interval {

    public Second(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        this.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Secunde";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 0: return "Verminderde";
            case 1: return "Kleine";
            case 2: return "Grote";
            case 3: return "Overmatige";
        }
        return "Onbekend";
    }
}
