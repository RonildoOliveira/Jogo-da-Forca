package jogoforca;

import java.util.Scanner;

public class IniciarJogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitura = new Scanner(System.in);
		Logica l = new Logica();
		
		System.out.println("Digite seu palpite");		
		
		while(l.getNumErros() < 6){
			String palpite = leitura.nextLine();
			System.out.println(l.procuraLetra(palpite));
			System.out.println(l.getNumErros());
			
			for (String string : l.getPalpitesErrados()) {
				System.out.print(string+" ");
			}
			
			System.out.println();
			
			if(l.ganhouJogo()){
				System.out.println("GANHOU!");
				break;
			}
			
			System.out.println(l.getPalavraEncriptada());
		}
		if(!l.ganhouJogo()){
			System.out.println("PERDEU!");
			System.out.println("\tA palavra era: "+l.getPalavraAleatoria());
		}
		
	}

}
