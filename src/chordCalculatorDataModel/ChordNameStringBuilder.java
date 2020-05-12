package chordCalculatorDataModel;

import java.util.StringJoiner;

public class ChordNameStringBuilder {
    private String chordName;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final ChordInfoObject chordInfoObject;

    String getBuiltName(){
        startBuilding();
        return chordName;
    }

    ChordNameStringBuilder(ChordInfoObject chordInfoObject) {
        this.chordInfoObject = chordInfoObject;
    }

    private void startBuilding(){
        addRootToStringBuilder();
        addTypeOfLowerStructureToStringBuilder();
        addExtensionsToStringBuilder();
        addSussesToStringBuilder();
        addNoThirdAndNoFifthToStringBuilder();
        addAlterationsToStringBuilder();
        addAddsToStringBuilder();
        chordName = stringBuilder.toString();
    }

    private void addRootToStringBuilder(){
        stringBuilder.append(chordInfoObject.getRoot());
    }

    private void addTypeOfLowerStructureToStringBuilder(){
        if (!chordInfoObject.getLowerStructure().isEmpty()) {
            stringBuilder.append(chordInfoObject.getLowerStructure().get(0));
        }
    }

    private void addExtensionsToStringBuilder(){
        if(!chordInfoObject.getExtensions().isEmpty()) {
            stringBuilder.append(extensionsJoinedWithStringJoiner());
        }
    }

    private String extensionsJoinedWithStringJoiner(){
        StringJoiner stringJoiner = new StringJoiner(",");


        for (String string : chordInfoObject.getExtensions()){
            stringJoiner.add(string);
        }

        return stringJoiner.toString();
    }

    private void addSussesToStringBuilder(){
        if (!chordInfoObject.getSusses().isEmpty()) {
            for (String sus : chordInfoObject.getSusses())
                stringBuilder.append(sus);
        }
    }

    private void addNoThirdAndNoFifthToStringBuilder(){
        if (!chordInfoObject.getNo3rdNo5th().isEmpty()){
            stringBuilder.append(noXthJoinedWithStringJoiner());
        }
    }

    private String noXthJoinedWithStringJoiner(){
        StringJoiner stringJoiner = new StringJoiner(",","(",")");
        for (String string : chordInfoObject.getNo3rdNo5th()){
            stringJoiner.add(string);
        }
        return stringJoiner.toString();
    }

    private void addAlterationsToStringBuilder(){
        if (!chordInfoObject.getAlterations().isEmpty()) {
            stringBuilder.append(alterationsJoinedWithStringJoiner());
        }
    }

    private String alterationsJoinedWithStringJoiner(){
        StringJoiner stringJoiner = new StringJoiner("/","(",")");
        for (String string : chordInfoObject.getAlterations()){
            stringJoiner.add(string);
        }
        return stringJoiner.toString();
    }

    private void addAddsToStringBuilder(){
        if (!chordInfoObject.getAdds().isEmpty()) {
            stringBuilder.append(addsJoinedWithStringJoiner());
        }
    }

    private String addsJoinedWithStringJoiner(){
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String string : chordInfoObject.getAdds()) {
            stringJoiner.add(string);
        }
        return stringJoiner.toString();
    }
}
