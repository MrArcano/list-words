package com.exercises.listwords;

import com.exercises.listwords.model.Words;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    Words elenco ;

    public void setElenco(Words elenco) {
        this.elenco = elenco;
        System.out.println(elenco.getList());
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    public Button btnDelete;

    @FXML
    public Label txtTime;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    long t1 = 0;
    long t2 = 0;

    @FXML
    void doInsert(ActionEvent event) {
        // se la lbl è vuota nn fare nulla
        if(txtParola.getText().isEmpty()) return;

        t1 = System.nanoTime();

        elenco.addWord(txtParola.getText());
        updateTxtResult();

        t2 = System.nanoTime();
        System.out.println("Insert: " + (t2 - t1));
        txtTime.setText("Time: " + (t2 - t1));

        System.out.println(elenco.getList()); //debug
    }

    @FXML
    void doReset(ActionEvent event) {
        t1 = System.nanoTime();

        elenco.reset();
        updateTxtResult();

        t2 = System.nanoTime();
        System.out.println("Reset: " + (t2 - t1));
        txtTime.setText("Time: " + (t2 - t1));
    }

    @FXML
    void doDelete(ActionEvent event) {
        t1 = System.nanoTime();

        elenco.removeWord(txtParola.getText());
        updateTxtResult();

        t2 = System.nanoTime();
        System.out.println("Delete: " + (t2 - t1));
        txtTime.setText("Time: " + (t2 - t1));
    }

    private void updateTxtResult() {
        txtParola.setText("");
        txtResult.setText("");
        for( String s : elenco.getList()){
            txtResult.appendText(s + "\n");
        }
    }




    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}