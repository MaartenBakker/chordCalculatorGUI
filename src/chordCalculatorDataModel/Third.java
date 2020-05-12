package chordCalculatorDataModel;

public class Third extends Interval {

    public Third(Note laagsteNote, Note hoogsteNote) {
        super(laagsteNote, hoogsteNote);
        super.setName(createNaam());
    }

    private String createNaam(){
        String naam ="";
        naam += getVoorzetsel();
        naam += " Terts";
        return naam;
    }

    private String getVoorzetsel(){
        switch (getSemiTones()){
            case 2: return "Verminderde";
            case 3: return "Kleine";
            case 4: return "Grote";
            case 5: return "Overmatige";
        }
        return "Onbekend";
    }

//    String getToevoegingsNaam(){
//        switch (getSemiTones()){
//            case 2: return "bb10";
//            case 3: return "b10";
//            case 4: return "10";
//            case 5: return "#10(11)";
//        }
//        return "";
//    }
}
