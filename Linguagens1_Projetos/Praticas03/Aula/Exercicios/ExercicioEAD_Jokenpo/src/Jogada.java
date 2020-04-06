
public class Jogada {
	private String escolha, ganhoDe, percoDe;
	
	public static final String PEDRA = "Pedra";
	public static final String TESOURA = "Tesoura";
	public static final String PAPEL = "Papel";
	
	
	public Jogada(String opcao) {
		if(opcao.equals(this.PEDRA)) {
			ganhoDe = this.TESOURA;
			percoDe = this.PAPEL;
		}
		else if (opcao.equals(this.PAPEL)) {
			ganhoDe = this.PEDRA;
			percoDe = this.TESOURA;
		}
		else {
			ganhoDe = this.PAPEL;
			percoDe = this.PEDRA;
		}
		escolha = opcao;
	}
	
	public String getEscolha() {
		return this.escolha;
	}
	
	
	
	public String avaliar(Jogada jogada) {
		if(jogada.getEscolha().equals(this.ganhoDe)) {
			return "Ganhei!";
		}
		else if(jogada.getEscolha().contentEquals(this.percoDe)) {
			return "Perdi!";
		}
		else {
			return "Empate";
		}
	}
}
