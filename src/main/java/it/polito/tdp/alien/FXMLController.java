package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;

import dizionarioPack.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Dizionario model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtAlienText;

    @FXML
    private TextArea txtTraduction;


    @FXML
    void handleTranslate(ActionEvent event) {
    	String input = txtAlienText.getText();
    	String a [] = input.split(" ");
    	String alien = a[0];

    	if(a.length==1) {
    		//E' stata inserita una parola da tradurre
    		
    		//ESERCIZIO 3
    		if(alien.contains("?")) {
    			txtTraduction.setText("HAI USATO UNA WILDCARD\n");
    			int cont = 0;
    			char[]c = alien.toCharArray();
    			for(Character cc : c) {
    				if(cc=='?')
    					cont++;
    			}
    			if(cont==1) {
    				//int lung = alien.length();
    				//String aa[] = alien.split("?");
    				alien = alien.replace("?", ".");
    				//CERCO PAROLA PARZIALE	
    				
    				List<String> lparz = (List<String>) model.getTrazioneParziale(alien);
    				
    				txtTraduction.appendText(lparz.toString());
    			}
    			
    		}
    		
    		//ESERCIZIO 1
    		/*String trad = model.getTraduzione(alien);

    		if(trad.compareTo("")==0) {
    			//non c'è una traduzione per questa parola
    			txtTraduction.setText("NON ESISTE TRADUZIONE PER QUESTA PAROLA");
    		}else
    			txtTraduction.setText(trad);
    		*/
    		
    		//ESERCIZIO 2
    		List<String> trad = (List<String>) model.getListaTraduzioni(alien);
    		
    		if(trad.size()==0) {
    			txtTraduction.setText("NON ESISTE TRADUZIONE PER QUESTA PAROLA");
    		}else
    			txtTraduction.setText(trad.toString());
    		
    		
    		
    	}else {
    		//sono state inserite sia la parola che la traduzione
    		String traduzione = a[1];
    		boolean b = model.aggiungiParolaTraduzione(alien, traduzione);
    		
    		if(b==true)
    			txtTraduction.setText("HAI INSERITO UNA NUOVA PAROLA E UNA\nNUOVA TRADUZIONE NEL DIZIONARIO!");
    		else
    			txtTraduction.setText("ERRORE FORMATO:\nNON INSERIRE CARATTERI SPECIALI");
    	}

    }
    
    @FXML
    void handleClearText(ActionEvent event) {
    	txtAlienText.clear();
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAlienText != null : "fx:id=\"txtAlienText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduction != null : "fx:id=\"txtTraduction\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dizionario model) {
		this.model = model;
		
	}

}
