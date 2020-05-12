package chordCalculatorDataModel;

public class Prime extends Interval {

    public Prime(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Prime";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 0: return PERFECT;
            case 1: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
