package it.polito.tdp.spellchecker.model;

import java.util.List;

public class RichWord {
	
	private String parola;
	private boolean giusto;
	
	public RichWord(String parola, boolean giusto) {
		this.parola = parola;
		this.giusto = giusto;
	}
	
	public void controllo(List<String> lista) {
		if(lista.contains(this.parola) == true)
			giusto = true;
		else
			giusto = false;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isGiusto() {
		return giusto;
	}

	public void setGiusto(boolean giusto) {
		this.giusto = giusto;
	}

	

}
