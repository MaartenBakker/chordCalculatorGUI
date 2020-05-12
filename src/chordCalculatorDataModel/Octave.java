package chordCalculatorDataModel;

public class Octave extends Interval {
    public Octave(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Octave";
        return name;
    }

    private String getModifier(){
        if (getSemiTones() == 11) {
            return DIMINISHED;
        }
        return UNKNOWN;
    }
}
