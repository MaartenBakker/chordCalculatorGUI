package chordCalculatorDataModel;

import java.util.*;

public class Note {
    private static final Map<Character, Integer> mapVanInitieleNotenwaardes = createMapVanInitieleNotenwaardes();
    private final String noteName;
    private final char stamToon;
    private char firstAccidental;
    private char secondAccidental;
    private final int value;

    private static Map<Character, Integer> createMapVanInitieleNotenwaardes(){
        Map<Character, Integer> tempMap = new LinkedHashMap<>();
        tempMap.put('a', 0);
        tempMap.put('b', 2);
        tempMap.put('c', 3);
        tempMap.put('d', 5);
        tempMap.put('e', 7);
        tempMap.put('f', 8);
        tempMap.put('g', 10);

        return Collections.unmodifiableMap(tempMap);
    }

    public Note(String noteName) {
        this.noteName = noteName.toLowerCase();
        this.stamToon = this.noteName.charAt(0);
        setAccidentals();
        this.value = setInitialNoteValue();
    }

    void setAccidentals() {
        int indexOfFirstAccidental = -1;
        int indexOfSecondAccidental = -1;

        if (noteName.contains("#")) {
            indexOfFirstAccidental = noteName.indexOf("#");
            if (indexOfFirstAccidental != -1) {
                indexOfSecondAccidental = noteName.indexOf("#", indexOfFirstAccidental+1);
            }
        } else if (noteName.contains("b")) {
            indexOfFirstAccidental = noteName.indexOf("b");
            if (indexOfFirstAccidental != -1) {
                indexOfSecondAccidental = noteName.indexOf("b", indexOfFirstAccidental+1);
            }
        }

        if (indexOfFirstAccidental !=-1 && indexOfFirstAccidental !=0) {
            firstAccidental = noteName.charAt(indexOfFirstAccidental);
        }
        if (indexOfSecondAccidental !=-1) {
            secondAccidental = noteName.charAt(indexOfSecondAccidental);
        }

    }

    public int setInitialNoteValue() {
        int notenWaarde = mapVanInitieleNotenwaardes.get(this.stamToon);
        if (this.firstAccidental == '#') {notenWaarde++;}
        if (this.secondAccidental == '#') {notenWaarde++;}
        if (this.firstAccidental == 'b') {notenWaarde--;}
        if (this.secondAccidental == 'b') {notenWaarde--;}

        return notenWaarde;
    }

    static List<Note> invert(List<Note> notes) {
        Note firstNote = notes.get(0);
        int lastIndexOfArray = notes.size() - 1;

        List<Note> invertedNotes = new ArrayList<>();
        for (int i = 1; i < notes.size(); i++) {
            invertedNotes.add(notes.get(i));
        }

        invertedNotes.add(lastIndexOfArray, firstNote);
        return invertedNotes;
    }

    public String getNoteName() {
        return noteName;
    }

    public int getValue() {
        return value;
    }

    public char getStamToon() {
        return this.stamToon;
    }

    @Override
    public String toString() {
        return noteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(noteName, note.noteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteName);
    }
}
