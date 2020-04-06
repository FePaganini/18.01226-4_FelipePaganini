import java.util.Scanner;

public class Jokenpo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Jogada j1 = new Jogada();
		Jogada j2 = new Jogada();
		System.out.println("Nome do jogador/a 1: ");
		j1.jogador.nome = scan.nextLine();
		System.out.println("Nome do jogador/a 2: ");
		j2.jogador.nome = scan.nextLine();
		
		j1.lista();
		j1.escolha(j2);
		
		while(j1.comparar(j2) == 0) {
		j1.resultado(j1.comparar(j2), j2);
		j1.lista();
		j1.escolha(j2);
		}

		j1.resultado(j1.comparar(j2), j2);
	}
}