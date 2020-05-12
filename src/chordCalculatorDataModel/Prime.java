package chordCalculatorDataModel;

public class Prime extends Interval {

    public Prime(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Prime";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 0: return "Reine";
            case 1: return "Overmatige";
        }
        return "Onbekend";
    }
}
