package chordCalculatorDataModel;

public class Seventh extends Interval {

    public Seventh(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Septime";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 9: return "Verminderde";
            case 10: return "Kleine";
            case 11: return "Grote";
            case 12: return "Overmatige";
        }
        return "Onbekend";
    }
}
