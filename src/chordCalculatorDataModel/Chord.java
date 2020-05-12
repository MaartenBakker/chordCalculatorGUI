package chordCalculatorDataModel;

import java.util.*;


public class Chord {
    private final List<Note> notes;
    private final List<Interval> intervalsInRelationToLowestNote = new ArrayList<>();
    private final List<Interval> intervalsBetweenNotes = new ArrayList<>();
    private final List<Integer> semiTonesInRelationToLowestNote = new ArrayList<>();
    private final List<Integer> semiTonesBetweenNotes = new ArrayList<>();
    private int inversion = 0; //only used in dictonary when creating entry

    public Chord(List<Note> notes) {
        this.notes = notes;
        calculateIntervalsInRelationToLowestNote();
        calculateIntervalsBetweenNotes();
        calculateSemiTonesInRelationToLowestNote();
        calculateSemiTonesBetweenNotes();
    }

    private void calculateIntervalsInRelationToLowestNote() {
        for (int i = 1; i < notes.size(); i++) {
            Note laagsteNote = notes.get(0);
            Note hoogsteNote = notes.get(i);
            Interval interval = Interval.createInterval(laagsteNote, hoogsteNote);
            intervalsInRelationToLowestNote.add(interval);
        }
    }

    private void calculateIntervalsBetweenNotes() {
        for (int i = 0; i < notes.size() - 1; i++) {
            Note laagsteNote = notes.get(i);
            Note hoogsteNote = notes.get(i + 1);
            Interval interval = Interval.createInterval(laagsteNote, hoogsteNote);
            intervalsBetweenNotes.add(interval);
        }
    }

    private void calculateSemiTonesInRelationToLowestNote(){
        for (Interval interval : this.intervalsInRelationToLowestNote){
            this.semiTonesInRelationToLowestNote.add(interval.getSemiTones());
        }
    }

    private void calculateSemiTonesBetweenNotes() {
        for (Interval interval : this.intervalsBetweenNotes) {
            semiTonesBetweenNotes.add(interval.getSemiTones());
        }
    }

    public static Chord createSpecificInversionOfChord(Chord chord, int omkering) {
        for (int i = 0; i < omkering; i++) {
            chord = chord.getNextInversion();
        }
        chord.setInversion(omkering);
        return chord;
    }

    public Chord getNextInversion() {
        List<Note> noten = getNotes();
        List<Note> omgekeerdeNoten = Note.invert(noten);
        return new Chord(omgekeerdeNoten);
    }

    public List<ChordType> getChordNameFromDictionary() {
        List<ChordType> chordTypes = new ArrayList<>();
        Map<Chord, ChordType> opzoekMap = ChordDictionary.getMapVanAkkoordTypes();
        for (Map.Entry<Chord, ChordType> entrySet : opzoekMap.entrySet()) {
            if (entrySet.getKey().intervalsBetweenNotes.equals(this.intervalsBetweenNotes)) {
                chordTypes.add(entrySet.getValue());
            }
        }
        return chordTypes;
    }

    public List<ChordType> getSynonymsFromDictionary() {
        List<ChordType> akkoordSynoniemen = new ArrayList<>();
        Map<Chord, ChordType> opzoekMap = ChordDictionary.getMapVanAkkoordTypes();
        for (Map.Entry<Chord, ChordType> entrySet : opzoekMap.entrySet()) {
            if (entrySet.getKey().semiTonesBetweenNotes.equals(this.semiTonesBetweenNotes) &&
                    (!getChordNameFromDictionary().contains(entrySet.getValue()))) {
                akkoordSynoniemen.add(entrySet.getValue());
            }
        }
        return akkoordSynoniemen;
    }

    public List<ChordType> getSuperSetsFromDictionary() {
        List<ChordType> superSetAkkoorden = new ArrayList<>();
        Map<Chord, ChordType> opzoekMap = ChordDictionary.getMapVanAkkoordTypes();

        for (Map.Entry<Chord, ChordType> entrySet : opzoekMap.entrySet()) {
            List<Interval> superLijstAkoordIntervallen = entrySet.getKey().getIntervalsBetweenNotes();
            if (areTheIntervalsBetweenTheNotesALinkedSubset(superLijstAkoordIntervallen)) {
                if (!this.getChordNameFromDictionary().contains(entrySet.getValue())) {
                    superSetAkkoorden.add(entrySet.getValue());
                }
            }
        }
        return superSetAkkoorden;
    }

    boolean areTheIntervalsBetweenTheNotesALinkedSubset(List<Interval> superLijst) {
        boolean flag = false;

        for (int i = 0; i <= superLijst.size() - this.intervalsBetweenNotes.size(); i++) {
            flag = true;
            for (int j = 0; j < this.intervalsBetweenNotes.size(); j++) {
                if (!this.intervalsBetweenNotes.get(j).equals(superLijst.get(j + i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    private Note getRoot(ChordType chordType) {
        if (chordType.getInversion() == 0) {
            return this.notes.get(0);
        } else {
            return (this.notes.get(this.notes.size() - chordType.getInversion()));
        }
    }

    public void setInversion(int inversion) {
        this.inversion = inversion;
    }

    public List<Note> getNotes() {
        return Collections.unmodifiableList(notes);
    }

    public List<Interval> getIntervalsBetweenNotes() {
        return Collections.unmodifiableList(intervalsBetweenNotes);
    }

    public List<Integer> getSemiTonesInRelationToLowestNote() {
        return Collections.unmodifiableList(semiTonesInRelationToLowestNote);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chord chord = (Chord) o;
        return Objects.equals(intervalsInRelationToLowestNote, chord.intervalsInRelationToLowestNote) &&
                Objects.equals(intervalsBetweenNotes, chord.intervalsBetweenNotes) &&
                Objects.equals(inversion, chord.inversion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intervalsInRelationToLowestNote, intervalsBetweenNotes, inversion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!getChordNameFromDictionary().isEmpty()) {
            for (ChordType chordType : getChordNameFromDictionary()) {
                sb.append(akkoordTypesToString(chordType));
            }
        } else {
            sb.append("Onbekend akkoord");
        }

        sb.append("\n noten=").append(notes);
        sb.append("\n intervallenVanafGrondtoon=").append(intervalsInRelationToLowestNote);
        sb.append("\n intervallenTussenNoten=").append(intervalsBetweenNotes);
        sb.append("\n\n");

        if (!getSynonymsFromDictionary().isEmpty()) {
            sb.append("Enharmonisch gelijk: ");
            for (ChordType chordType : getSynonymsFromDictionary()) {
                sb.append(akkoordTypesToString(chordType));
            }
        } else {
            sb.append("Geen enharmonisch gelijke akkoorden");
        }

        sb.append("\nkomt voor in:").append("\n").append(getSuperSetsFromDictionary());

        return sb.toString();
    }

    private String akkoordTypesToString(ChordType chordType) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(getRoot(chordType).getNoteName().charAt(0)));
        for (int i = 1; i < getRoot(chordType).getNoteName().length(); i++) {
            sb.append(getRoot(chordType).getNoteName().charAt(i));
        }
        sb.append(" ");
        sb.append(chordType.getName()).append(" ");
        if (chordType.getInversion() != 0) {
            sb.append(chordType.getInversion()).append("e omkering");
        } else {
            sb.append("grondligging");
        }
        sb.append("\n");
        return sb.toString();

    }
}



