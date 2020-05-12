package chordcalculatorGUI;

import chordCalculatorDataModel.ChordCalculatorMain;
import chordCalculatorDataModel.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    ChoiceBox<String> choiceBoxRoot;
    @FXML
    CheckBox checkBoxA;
    @FXML
    CheckBox checkBoxAis;
    @FXML
    CheckBox checkBoxB;
    @FXML
    CheckBox checkBoxC;
    @FXML
    CheckBox checkBoxCis;
    @FXML
    CheckBox checkBoxD;
    @FXML
    CheckBox checkBoxDis;
    @FXML
    CheckBox checkBoxE;
    @FXML
    CheckBox checkBoxF;
    @FXML
    CheckBox checkBoxFis;
    @FXML
    CheckBox checkBoxG;
    @FXML
    CheckBox checkBoxGis;
    @FXML
    Label selected;
    CheckBox previouslySelectedCheckbox;

    ObservableList<ChoiceBox<String>> listOfChoiceBoxes = FXCollections.observableArrayList();
    ObservableList<Note> listOfNotes = FXCollections.observableArrayList();





    public void eventA(ActionEvent e){
        Note note = new Note("a");
        CheckBox checkBox = (CheckBox) e.getSource();
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventAis(ActionEvent e){
        Note note = new Note("a#");
        CheckBox checkBox = (CheckBox) e.getSource();
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventB(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("b");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventC(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("c");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventCis(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("c#");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventD(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("d");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventDis(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("d#");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventE(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("e");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventF(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("f");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventFis(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("f#");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventG(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("g");
        handleCheckBoxEvents(checkBox, note);
    }

    public void eventGis(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note("g#");
        handleCheckBoxEvents(checkBox, note);
    }

    public void handleCheckBoxEvents(CheckBox checkBox, Note note){
        if (checkBox.selectedProperty().getValue()) {
            updateChordNameOnCheck(note);
        }
        if (!checkBox.selectedProperty().getValue()){
            updateChordNameOnUncheck(note);
        }
    }

    public void updateChordNameOnUncheck(Note note){
        int indexOfNoteToRemove = listOfNotes.indexOf(note);
        listOfNotes.remove(indexOfNoteToRemove);
        String namesList = ChordCalculatorMain.getNameOfChordAndAllInversions(listOfNotes);
        selected.setText(namesList);
    }

    public void updateChordNameOnCheck(Note note){
        listOfNotes.add(note);
        String namesList = ChordCalculatorMain.getNameOfChordAndAllInversions(listOfNotes);
        selected.setText(namesList);
    }


    @FXML
    public void choiceBoxHandler(ActionEvent e) {
        String chosenNote = choiceBoxRoot.getValue();
        CheckBox checkBox = getCorrespondingCheckbox(chosenNote);
        previouslySelectedCheckbox.setSelected(false);
        checkBox.setSelected(true);
        previouslySelectedCheckbox = checkBox;
    }

    public CheckBox getCorrespondingCheckbox(String chosenNote){
        switch (chosenNote) {
            case "A": return checkBoxA;
            case "A#/Bb": return checkBoxAis;
            case "B": return checkBoxB;
            case "C": return checkBoxC;
            case "C#/Db": return checkBoxCis;
            case "D": return checkBoxD;
            case "D#/Eb": return checkBoxDis;
            case "E": return checkBoxE;
            case "F": return checkBoxF;
            case "F#/Gb": return checkBoxFis;
            case "G": return checkBoxG;
            case "G#/Ab": return checkBoxGis;
        }
        return checkBoxA;
    }




}
