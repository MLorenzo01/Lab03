/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	Dictionary model;
	
    @FXML
    private Label txtEr;
    
	@FXML
	private TextArea txterrori;

    @FXML
    private TextArea txttesto;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML // fx:id="cmblingua"
    private ComboBox<String> cmblingua; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnclear"
    private Button btnclear; // Value injected by FXMLLoader

    @FXML // fx:id="btnspellcheck"
    private Button btnspellcheck; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	txterrori.clear();
    	txttesto.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	int num = 0;
    	String lingua = cmblingua.getValue().toString();
    	model.loadDictionary(lingua);
    	List<RichWord> lista = model.spellCheckText(txttesto.getText().split(" "));
    	for(RichWord r: lista) {
    		if(r.isGiusto() == false) {
    			txterrori.appendText(r.getParola());
    			num++;
    		}
    	}
    	txtEr.setText("The text contains " + num + " errors" );
     }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnclear != null : "fx:id=\"btnclear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnspellcheck != null : "fx:id=\"btnspellcheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txterrori != null : "fx:id=\"txterrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttesto != null : "fx:id=\"txttesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEr != null : "fx:id=\"txtEr\" was not injected: check your FXML file 'Scene.fxml'.";
        this.cmblingua.getItems().add("Italian");
        this.cmblingua.getItems().add("English"); 
    }

	public void setModel(Dictionary model) {
		this.model = model;
	}
}


