import java.util.Scanner;

public class NomeJogada {
	int numero;
	String nome;
	Scanner scan = new Scanner(System.in);
	
	void lista() {
		System.out.println("Escolha entre as opções:");
		System.out.println("Tesoura:1   Papel:2   Pedra:3   Lagarto:4   Spock:5");
	}
	
	void nome(NomeJogada p2){
		System.out.println("Nome do Jogador 1: ");
		this.nome = scan.nextLine();
		System.out.println("Nome do Jogador 2: ");
		p2.nome = scan.nextLine();
	}
	void num(NomeJogada p2){
		System.out.println("Opção do " +this.nome);
		this.numero = scan.nextInt();
		System.out.println("Opção do " +p2.nome);
		p2.numero = scan.nextInt();
	}
}
