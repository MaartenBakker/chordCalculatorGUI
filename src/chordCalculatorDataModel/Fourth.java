package chordCalculatorDataModel;

public class Fourth extends Interval {

    public Fourth(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Kwart";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 4: return "Verminderde";
            case 5: return "Reine";
            case 6: return "Overmatige";
        }
        return "Onbekend";
    }
}
