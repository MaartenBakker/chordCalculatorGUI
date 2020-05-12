package chordCalculatorDataModel;

public class Fifth extends Interval {

    public Fifth(Note lowestNote, Note highestNote) {
        super(lowestNote, highestNote);
        super.setName(createName());
    }

    private String createName(){
        String name ="";
        name += getModifier();
        name += " Fifth";
        return name;
    }

    private String getModifier(){
        switch (getSemiTones()){
            case 6: return DIMINISHED;
            case 7: return PERFECT;
            case 8: return AUGMENTED;
        }
        return UNKNOWN;
    }
}
