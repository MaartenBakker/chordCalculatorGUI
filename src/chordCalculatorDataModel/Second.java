package chordCalculatorDataModel;

public class Second extends Interval {

    public Second(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        this.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Second";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 0: return DIMINISHED;
            case 1: return MINOR;
            case 2: return MAJOR;
            case 3: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
