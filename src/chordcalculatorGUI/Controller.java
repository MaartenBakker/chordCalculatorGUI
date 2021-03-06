package chordcalculatorGUI;

import chordCalculatorDataModel.ChordCalculatorMain;
import chordCalculatorDataModel.Note;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    Label label;

    StringProperty chordNames = new SimpleStringProperty();
    List<Note> listOfNotes = new ArrayList<>();

    public void initialize(){
        label.textProperty().bind(chordNames);
    }

    @FXML
    public void handleCheckBox(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        Note note = new Note(checkBox.getId());
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
        chordNames.set(ChordCalculatorMain.getNameOfChordAndAllInversions(listOfNotes));
    }

    public void updateChordNameOnCheck(Note note){
        listOfNotes.add(note);
        chordNames.set(ChordCalculatorMain.getNameOfChordAndAllInversions(listOfNotes));
    }
}
