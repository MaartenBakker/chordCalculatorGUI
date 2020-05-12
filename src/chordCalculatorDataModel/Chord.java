package chordCalculatorDataModel;

import java.util.*;


public class Chord {
    private final List<Note> notes;
    private final List<Interval> intervalsInRelationToLowestNote = new ArrayList<>();
    private final List<Interval> intervalsBetweenNotes = new ArrayList<>();
    private final List<Integer> semiTonesInRelationToLowestNote = new ArrayList<>();
    private final List<Integer> semiTonesBetweenNotes = new ArrayList<>();

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

    public Chord getNextInversion() {
        List<Note> noten = getNotes();
        List<Note> omgekeerdeNoten = Note.invert(noten);
        return new Chord(omgekeerdeNoten);
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
                Objects.equals(intervalsBetweenNotes, chord.intervalsBetweenNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intervalsInRelationToLowestNote, intervalsBetweenNotes);
    }

}



