package dizionarioPack;

import java.util.*;
public class Dizionario {

	HashMap<String, String> diz;
	HashMap<String, LinkedList<String>> multi;
	
	public Dizionario() {
		diz = new HashMap<String,String>();
		multi = new HashMap<String, LinkedList<String>>();
	}
	

	public String getTraduzione(String s) {
		s = s.toLowerCase();
		if(diz.containsKey(s)) {
			if(diz.get(s)!=null) {
				return diz.get(s); //ritorna la traduzione
			}
		}
		return "";
	}
	
	public Collection getListaTraduzioni(String s) {
		s = s.toLowerCase();
		
		if(multi.containsKey(s)) {
			if(multi.get(s).size()!=0) {
				return multi.get(s); //ritorno lista di traduzione
			}
		}
		
		return null;
	}
	
	public boolean aggiungiParolaTraduzione(String parola, String traduzione) {
		if(parola.matches("[a-zA-Z]+")==true && traduzione.matches("[a-zA-Z]+")==true) {
			parola = parola.toLowerCase();
			traduzione = traduzione.toLowerCase();
			
			//diz.put(parola, traduzione);
			
			//aggiungo alla mappa di traduzione multipla
			if(multi.containsKey(parola)) {
				multi.get(parola).add(traduzione);	
			}else {
				List<String> l = new LinkedList<String>();
				l.add(traduzione);
				multi.put(parola, (LinkedList<String>) l);
				
			}
			
				
			
			
			//multi.get(parola).add(traduzione);
			return true;
		}
		return false;
	}
	
	public Collection getTrazioneParziale(String parziale) {
		for(String s: multi.keySet()) {
			if(s.matches(parziale)) { //trovo una parola che contiene la parziale
				return multi.get(s);
			}
		}
		return null;
	}
	
}
