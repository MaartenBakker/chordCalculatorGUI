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
        getNoteAndCheckBox("a", e);
    }

    public void eventAis(ActionEvent e){
        getNoteAndCheckBox("a#", e);
    }

    public void eventB(ActionEvent e){
        getNoteAndCheckBox("b", e);
    }

    public void eventC(ActionEvent e){
        getNoteAndCheckBox("c", e);
    }

    public void eventCis(ActionEvent e){
        getNoteAndCheckBox("c#", e);
    }

    public void eventD(ActionEvent e){
        getNoteAndCheckBox("d", e);
    }

    public void eventDis(ActionEvent e){
        getNoteAndCheckBox("d#", e);
    }

    public void eventE(ActionEvent e){
        getNoteAndCheckBox("e", e);
    }

    public void eventF(ActionEvent e){
        getNoteAndCheckBox("f", e);
    }

    public void eventFis(ActionEvent e){
        getNoteAndCheckBox("f#", e);
    }

    public void eventG(ActionEvent e){
        getNoteAndCheckBox("g", e);
    }

    public void eventGis(ActionEvent e){
        getNoteAndCheckBox("g#", e);
    }

    private void getNoteAndCheckBox(String noteName, ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note(noteName);
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
        listOfNotes.remove(note);
        String namesList = ChordCalculatorMain.getNameOfChordAndAllInversions(listOfNotes);
        selected.setText(namesList);
    }

    public void updateChordNameOnCheck(Note note){
        listOfNotes.add(note);
        String namesList = ChordCalculatorMain.getNameOfChordAndAllInversions(listOfNotes);
        selected.setText(namesList);
    }
}
