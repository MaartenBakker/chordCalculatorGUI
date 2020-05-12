package chordCalculatorDataModel;

public class Sixth extends Interval {

    public Sixth(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Sext";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 7: return "Verminderde";
            case 8: return "Kleine";
            case 9: return "Grote";
            case 10: return "Overmatige";
        }
        return "Onbekend";
    }
}
