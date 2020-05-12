package chordCalculatorDataModel;

import java.util.*;

public class ChordDictionary {
    private static final Map<Chord, ChordType> mapVanAkkoordTypes = new LinkedHashMap<>();

    static void zetAkkoordTypesInMap(List<Note> noten, String naam){
        Chord chord = new Chord(noten);
        mapVanAkkoordTypes.put(chord, new ChordType(naam, 0));
        for (int i = 1; i < noten.size() ; i++) {
            mapVanAkkoordTypes.put(Chord.createSpecificInversionOfChord(chord, i), new ChordType(naam,i));
        }
    }

    /**
     * Deze werd gebruikt voor eerste manier van akkoordnaam opzoeken
     */

    public static void createMapVanAkkoordTypes(){
        //drieklanken

        List<Note> noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        String naam = "majeur";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        naam = "mineur";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        naam = "verminderd";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        naam = "majeur(b5)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g#"));
        naam = "overmatig";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        naam = "sus4";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("g"));
        naam = "sus2";
        zetAkkoordTypesInMap(noten, naam);

        //vierklanken

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        naam = "majeur(add2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("db"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        naam = "majeur(add(b2))";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("f#"));
        noten.add(new Note("g"));
        naam = "majeur(add#4)";
        zetAkkoordTypesInMap(noten, naam);


        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        noten.add(new Note("ab"));
        naam = "majeur(b6)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        noten.add(new Note("a"));
        naam = "majeur6";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        noten.add(new Note("bb"));
        naam = "7";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        noten.add(new Note("b"));
        naam = "majeur7";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("db"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        naam = "mineur(add(b2))";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        naam = "mineur(add2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        naam = "mineur(add4)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        noten.add(new Note("ab"));
        naam = "mineur(b6)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        noten.add(new Note("a"));
        naam = "mineur6";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        noten.add(new Note("bb"));
        naam = "mineur7";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("g"));
        noten.add(new Note("b"));
        naam = "mineur(majeur7)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("db"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        naam = "verminderd(add(b2))";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        naam = "verminderd(add2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("f"));
        noten.add(new Note("gb"));
        naam = "verminderd(add4)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        noten.add(new Note("bbb"));
        naam = "verminderd7";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        noten.add(new Note("bb"));
        naam = "halfverminderd7";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        noten.add(new Note("b"));
        naam = "verminderd(majeur7)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("db"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        naam = "majeur(b5)(add(b2))";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        naam = "majeur(b5)(add2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("f"));
        noten.add(new Note("gb"));
        naam = "majeur(b5)(add4)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        noten.add(new Note("ab"));
        naam = "majeur(b5,b6)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        noten.add(new Note("a"));
        naam = "majeur6(b5)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("db"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        naam = "verminderd((add)b2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("eb"));
        noten.add(new Note("gb"));
        naam = "verminderd(add2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("eb"));
        noten.add(new Note("f"));
        noten.add(new Note("gb"));
        naam = "verminderd(add4)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        noten.add(new Note("bb"));
        naam = "hardverminderd7";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("gb"));
        noten.add(new Note("b"));
        naam = "majeur7(b5)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("db"));
        noten.add(new Note("e"));
        noten.add(new Note("g#"));
        naam = "overmatig(add(b2))";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("e"));
        noten.add(new Note("g#"));
        naam = "overmatig(add2)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("f#"));
        noten.add(new Note("g#"));
        naam = "overmatig(add(#4))";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g#"));
        noten.add(new Note("a"));
        naam = "overmatig(add6)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g#"));
        noten.add(new Note("bb"));
        naam = "7(#5)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g#"));
        noten.add(new Note("b"));
        naam = "maj7(#5)";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        naam = "sus2,4";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        noten.add(new Note("ab"));
        naam = "(b6)sus4";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        noten.add(new Note("a"));
        naam = "6,sus4";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        noten.add(new Note("bb"));
        naam = "7,sus4";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("f"));
        noten.add(new Note("g"));
        noten.add(new Note("b"));
        naam = "maj7,sus4";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("g"));
        noten.add(new Note("ab"));
        naam = "(b6)sus2";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("g"));
        noten.add(new Note("a"));
        naam = "6,sus2";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("g"));
        noten.add(new Note("bb"));
        naam = "7,sus2";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("c"));
        noten.add(new Note("d"));
        noten.add(new Note("g"));
        noten.add(new Note("b"));
        naam = "maj7,sus2";
        zetAkkoordTypesInMap(noten, naam);





        //vijfklanken

        noten = new ArrayList<>();
        noten.add(new Note("a"));
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        noten.add(new Note("b"));
        naam = "mineur9";
        zetAkkoordTypesInMap(noten, naam);

        noten = new ArrayList<>();
        noten.add(new Note("a"));
        noten.add(new Note("c"));
        noten.add(new Note("e"));
        noten.add(new Note("g"));
        noten.add(new Note("bb"));
        naam = "mineur7(b9)";
        zetAkkoordTypesInMap(noten, naam);

    }


    static Map<Chord, ChordType> getMapVanAkkoordTypes() {
        return Collections.unmodifiableMap(mapVanAkkoordTypes);
    }
}

