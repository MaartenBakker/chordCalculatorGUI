package chordCalculatorDataModel;

public class Octave extends Interval {
    public Octave(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Octaaf";
        return naam;
    }

    private String getVoorzetsel(){
        if (getSemiTones() == 11) {
            return "Verminderd";
        }
        return "Onbekend";
    }
}
