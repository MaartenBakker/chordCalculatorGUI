package chordCalculatorDataModel;

import java.util.Objects;

public abstract class Interval {
    private static int intervalType;
    private static char stamToonLowNote;
    private static char stamToonHighNote;
    private static int octaveCorrectionIntervalType;
    private static int octaveCorrectionSemiTones;
    private final Note lowNote;
    private final Note highNote;
    private int semiTones;
    private String name = "";
    private int intervalIndicator;
    String DIMINISHED = "Diminished";
    String MINOR = "Minor";
    String MAJOR = "Major";
    String PERFECT = "Perfect";
    String AUGMENTED = "Augmented";
    String UNKNOWN = "Unknown";

    protected Interval(Note lowNote, Note highNote) {
        this.lowNote = lowNote;
        this.highNote = highNote;
        calculateSemiTones();
    }

    public static Interval createInterval(Note lowNote, Note highNote){
        calculateIntervalType(lowNote, highNote);
        Interval interval = getInitializedInterval(lowNote, highNote, intervalType);
        if (interval !=null) {
            interval.intervalIndicator = intervalType;
        }
        return interval;
    }

    private static void calculateIntervalType(Note lowNote, Note highNote){
        stamToonLowNote = lowNote.getStamToon();
        stamToonHighNote = highNote.getStamToon();
        calculateOctaveCorrectionIntervalType();
        intervalType = differenceBetweenHighNoteAndLowNoteInIntervals();
    }

    private static int differenceBetweenHighNoteAndLowNoteInIntervals(){
        return (stamToonHighNote - stamToonLowNote + octaveCorrectionIntervalType);
    }

    private static void calculateOctaveCorrectionIntervalType(){
        octaveCorrectionIntervalType = 1;//count from one to match chordtypes
        if (stamToonLowNote>stamToonHighNote){
            octaveCorrectionIntervalType =8;
        }
    }

    private static Interval getInitializedInterval(Note lowNote, Note highNote, int intervalType) {
        switch (intervalType) {
            case 1:
                return new Prime(lowNote, highNote);
            case 2:
                return new Second(lowNote, highNote);
            case 3:
                return new Third(lowNote, highNote);
            case 4:
                return new Fourth(lowNote, highNote);
            case 5:
                return new Fifth(lowNote, highNote);
            case 6:
                return new Sixth(lowNote, highNote);
            case 7:
                return new Seventh(lowNote, highNote);
            case 8:
                return new Octave(lowNote, highNote);
        }
        return null;
    }



    private void calculateSemiTones(){
        calculateOctaveCorrectionSemiTones();
        semiTones = differenceBetweenLowAndHighNoteInSemiTones();
    }

    private int differenceBetweenLowAndHighNoteInSemiTones(){
        return (highNote.getValue() - lowNote.getValue() + octaveCorrectionSemiTones);
    }

    private void calculateOctaveCorrectionSemiTones(){
        octaveCorrectionSemiTones = 0;
        if (lowNote.getValue()> highNote.getValue()){
            octaveCorrectionSemiTones = 12;
        }
    }

    public Interval invertInterval(){
        return createInterval(highNote, lowNote);
    }


    protected int getSemiTones() {
        return semiTones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIntervalIndicator() {
        return intervalIndicator;
    }

    public Note getLowNote() {
        return lowNote;
    }

    public Note getHighNote() {
        return highNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return semiTones == interval.semiTones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(semiTones);
    }

    @Override
    public String toString() {

        return this.getName() + " " + "(" + semiTones + ")";
    }
}
