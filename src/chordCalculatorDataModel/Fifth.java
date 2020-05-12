package chordCalculatorDataModel;

public class Fifth extends Interval {

    public Fifth(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Kwint";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 6: return "Verminderde";
            case 7: return "Reine";
            case 8: return "Overmatige";
        }
        return "Onbekend";
    }
}
