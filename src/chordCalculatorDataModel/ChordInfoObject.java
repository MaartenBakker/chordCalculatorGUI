package chordCalculatorDataModel;

import java.util.ArrayList;
import java.util.List;

public class ChordInfoObject {
    private String root;
    private final List<String> lowerStructure = new ArrayList<>();
    private final List<String> extensions = new ArrayList<>();
    private final List<String> alterations = new ArrayList<>();
    private final List<String> susses = new ArrayList<>();
    private final List<String> no3rdNo5th = new ArrayList<>();
    private final List<String> adds = new ArrayList<>();

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<String> getLowerStructure() {
        return lowerStructure;
    }

    public List<String> getExtensions() {
        return extensions;
    }

    public List<String> getAlterations() {
        return alterations;
    }

    public List<String> getSusses() {
        return susses;
    }

    public List<String> getNo3rdNo5th() {
        return no3rdNo5th;
    }

    public List<String> getAdds() {
        return adds;
    }

    @Override
    public String toString() {
        return "ChordInfoObject{" +
                "root='" + root + '\'' +
                ", lowerStructure=" + lowerStructure +
                ", extensions=" + extensions +
                ", alterations=" + alterations +
                ", susses=" + susses +
                ", no3rdNo5th=" + no3rdNo5th +
                ", adds=" + adds +
                '}';
    }
}


