package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	private LinkedList<String> parole;
	
	
	public Dictionary() {
		parole = new LinkedList<String>();
	}
	public void loadDictionary(String language) {
		String word = "";
		try {
			String file = "D:\\Tutto\\Università\\eclipse-work\\Lab03\\src\\main\\resources\\" + language + ".txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((word = br.readLine()) != null) {
				parole.add(word.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", ""));
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		//word = word.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		/*for(String s: word.split(" ")) {
			parole.add(s);
		}*/
	}
	
	public List<RichWord> spellCheckText(String[] testo){
		List<RichWord> lista = new LinkedList<RichWord>();
		for(String s: testo) {
			RichWord r = new RichWord(s, false);
			r.controllo(parole);
			lista.add(r);
		}
		return lista;
	}
	/*public int errori(List<RichWord> lista) {
		int num = 0;
		for(RichWord r: lista) {
			if(r.isGiusto() == false)
				num +=1;
		}
		return num;
	}*/
}
