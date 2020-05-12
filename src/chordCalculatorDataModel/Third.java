package chordCalculatorDataModel;

public class Third extends Interval {

    public Third(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Third";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 2: return DIMINISHED;
            case 3: return MINOR;
            case 4: return MAJOR;
            case 5: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
