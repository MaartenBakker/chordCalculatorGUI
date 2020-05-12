package chordCalculatorDataModel;

public class Seventh extends Interval {

    public Seventh(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Seventh";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 9: return DIMINISHED;
            case 10: return MINOR;
            case 11: return MAJOR;
            case 12: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
