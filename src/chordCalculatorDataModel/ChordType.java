package chordCalculatorDataModel;

public class ChordType {
    private final String name;
    private final int inversion;

    public ChordType(String name, int inversion) {
        this.name = name;
        this.inversion = inversion;
    }

    public String getName() {
        return this.name;
    }

    public int getInversion() {
        return this.inversion;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(name).append(" ");
        if(inversion !=0){
            sb.append(inversion).append("e omkering");
        } else {
            sb.append("grondligging");
        }
        return sb.toString();
    }
}
