
public class Jogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Possibilidades j1 = new Possibilidades();
		Possibilidades j2 = new Possibilidades();
		
		j1.nj.nome(j2.nj);
		j1.nj.lista();
		j1.nj.num(j2.nj);
		
		while(j1.comparar(j2) == 0) {
			j1.resultado(j1.comparar(j2), j2);
			j1.nj.lista();
			j1.nj.num(j2.nj);
		}
		j1.resultado(j1.comparar(j2), j2);
	}
}
