package chordCalculatorDataModel;

public class Sixth extends Interval {

    public Sixth(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Sixth";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 7: return DIMINISHED;
            case 8: return MINOR;
            case 9: return MAJOR;
            case 10: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
