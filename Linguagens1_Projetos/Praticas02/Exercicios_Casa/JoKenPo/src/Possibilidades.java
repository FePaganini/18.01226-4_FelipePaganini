
public class Possibilidades {
	
	NomeJogada nj = new NomeJogada();
	
	int comparar(Possibilidades p2) {
		if(this.nj.numero == p2.nj.numero) {
			return 0;
		}
		else if(this.nj.numero < p2.nj.numero && Math.abs(this.nj.numero-p2.nj.numero)==1) {
			return 1;
		}
		else if(this.nj.numero > p2.nj.numero && Math.abs(this.nj.numero-p2.nj.numero)==2) {
			return 1;
		}
		else if(this.nj.numero < p2.nj.numero && Math.abs(this.nj.numero-p2.nj.numero)==3) {
			return 1;
		}
		else if(this.nj.numero > p2.nj.numero && Math.abs(this.nj.numero-p2.nj.numero)==4) {
			return 1;
		}
		else {
			return 2;
		}
	}
	void resultado(int N, Possibilidades p2) {
		if(N == 0) {
			System.out.println("Empate!");
		}
		else if(N == 1) {
			System.out.println("O jogador " + this.nj.nome + " ganhou!" );
		}
		else {
			System.out.println("O jogador " + p2.nj.nome + " ganhou!" );
		}
	}
}

