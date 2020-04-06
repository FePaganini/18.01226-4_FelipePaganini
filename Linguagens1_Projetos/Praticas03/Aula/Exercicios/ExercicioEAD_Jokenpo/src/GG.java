import java.util.Scanner;

public class GG {
	private Jogador j1,j2;
	public void jogar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o nome do Jogador 1: ");
		String nome = scan.nextLine();
		System.out.println("Informe o nome do Jogador 2: ");
		nome = scan.nextLine();
		System.out.println("1 - Pedra");
		System.out.println("2 - Tesoura");
		System.out.println("3 - Papel");
		System.out.println("Jogada do Jogador 1: ");
		int escolha = Integer.parseInt(scan.nextLine());
		switch (escolha) {
		case 1:
			j1 = new Jogador(nome,Jogada.PEDRA); break;
		case 2:
			j1 = new Jogador(nome,Jogada.TESOURA); break;
		case 3:	
			j1 = new Jogador(nome,Jogada.PAPEL);break;
		}
		System.out.println("Jogada do Jogador 2: ");
		escolha = Integer.parseInt(scan.nextLine());
		switch (escolha) {
		case 1:
			j2 = new Jogador(nome,Jogada.PEDRA);break;
		case 2:
			j2 = new Jogador(nome,Jogada.TESOURA);break;
		case 3:	
			j2 = new Jogador(nome,Jogada.PAPEL);break;
		}
		System.out.println("Jogador 1: " + j1.competicao(j2));
	}
}
