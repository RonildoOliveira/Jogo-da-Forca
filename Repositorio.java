package jogoforca;

import java.util.ArrayList;

public class Repositorio {
	private ArrayList<String> listaPalpites;
	
	private String[] bancoPalavras = { "flamengo", "vasco", "barcelona", "corinthians",
				"internacional", "fluminense", "fortaleza", "ceara",
				"ferroviario", "botafogo", "criciuma", "icasa", "sport",
				"gremio", "cruzeiro", "palmeiras", "santos", "avai", "goias",
				"coritiba", "figueirense", "bahia", "nautico", "parana", "abc",
				"bragantino", "sevilla", "oeste", "macae", "tolima" };

	
	public String palavraAlearotia() {
		int r = (int) (Math.random() * bancoPalavras.length);
		String random = this.bancoPalavras[r];
		return random;
	}

	public Repositorio() {
		listaPalpites = new ArrayList<String>();
	}
	
	public void inserirPalpiteLista(String palpite){
		listaPalpites.add(palpite);
	}
	
	public void exibirLetrasInseridas(){
	
	}
}
