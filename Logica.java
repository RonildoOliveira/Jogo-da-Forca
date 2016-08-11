package jogoforca;

import java.util.ArrayList;

public class Logica {
	
	private Repositorio repositorio;
	private String palavraAleatoria;
	private String palavraEncriptada;
	
	private ArrayList<String> palpitesErrados;
	private int numErros;
	
	public Logica() {
		palpitesErrados = new ArrayList<String>();
		numErros = 0;
		repositorio = new Repositorio();
		palavraAleatoria = repositorio.palavraAlearotia();
		
		iniciaPalavraEncriptada();
	}

	private void iniciaPalavraEncriptada() {
		palavraEncriptada = palavraAleatoria;
		
		for (int i = 0; i < palavraEncriptada.length(); i++) {
			palavraEncriptada = palavraEncriptada.replaceAll("[a-z]", "#");
		}
	}
	
	public boolean procuraLetra(String palpite){
		int contadorAcertos = 0;
		
		for (int i = 0; i < palavraAleatoria.length(); i++) {
			if(palpite.charAt(0) == palavraAleatoria.charAt(i)){
				desencriptaPalavra(i);
				contadorAcertos++;
			}
		}
		
		if(contadorAcertos > 0){
			return true;
		}
		
		//garantir palpites unicos
		if (!verificaErrosRepetidos(palpite)) {
			palpitesErrados.add(palpite);
			numErros++;
		}
		
		return false;
	}
	
	public String getPalavraEncriptada(){
		return this.palavraEncriptada;
	}
	
	private String replaceCharAt(String palavraEncriptada, int posicao, char caractere) {
		   return palavraEncriptada.substring(0,posicao) + caractere + palavraEncriptada.substring(posicao+1);
	}
	
	private void desencriptaPalavra(int i) {
		palavraEncriptada = replaceCharAt(palavraEncriptada, i, palavraAleatoria.charAt(i));
	}

	public boolean ganhouJogo(){
		if(palavraAleatoria.equals(palavraEncriptada)){
			return true;
		}
		return false;
	}
	
	private boolean verificaErrosRepetidos(String palpite){
		for (String string : palpitesErrados) {
			if (palpite.equals(string)) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumErros(){
		return this.numErros;
	}
	
	public String getPalavraAleatoria(){
		return this.palavraAleatoria;
	}
	
	public ArrayList<String> getPalpitesErrados(){
		return this.palpitesErrados;
	}
	
}
