import java.util.Scanner;

public class Jogada {
	
	public int numero;
	public Jogador jogador = new Jogador();
	
	void lista(){
		System.out.println("\nEscolha entre as opções");
		System.out.println("Pedra: 1	Papel: 2	Tesoura: 3\n");
	}
	void escolha(Jogada p2){
		Scanner scan = new Scanner(System.in);
		System.out.println(this.jogador.nome);
		this.numero = scan.nextInt();
		System.out.println(p2.jogador.nome);
		p2.numero = scan.nextInt();
	}
	
	int comparar( Jogada p2 ) {
		if (this.numero == p2.numero) {
			return(0);
		}
		else if((this.numero < p2.numero) && Math.abs(this.numero-p2.numero) == 1) {
			return(1);
		}
		else if((p2.numero < this.numero) && Math.abs(this.numero-p2.numero) == 2) {
			return(1);
		}
		else {
			return(2);
		}
	}
	void resultado(int N, Jogada p2) {
		if(N == 0) {
			System.out.println("Empate!");
		}
		else if(N == 1) {
			System.out.println("O jogador " + p2.jogador.nome + " ganhou!" );
		}
		else {
			System.out.println("O jogador " + this.jogador.nome + " ganhou!" );
		}
	}
}
