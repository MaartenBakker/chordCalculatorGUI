package chordCalculatorDataModel;

public class Fourth extends Interval {

    public Fourth(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Fourth";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 4: return DIMINISHED;
            case 5: return PERFECT;
            case 6: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
