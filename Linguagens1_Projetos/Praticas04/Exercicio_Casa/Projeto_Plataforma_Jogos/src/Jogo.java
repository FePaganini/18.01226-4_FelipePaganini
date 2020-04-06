
public class Jogo {
	private String nome;
	private String genero;
	private String descricao;
	private boolean online;
	private boolean multiplayer;
	public Jogo(String nome, String genero, String descricao) {
		this.nome = nome;
		this.genero = genero;
		this.descricao = descricao;
		online = false;
		multiplayer = false;
	}
	public String getNome() {
		return nome;
	}
	public String getGenero() {
		return genero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isMultiplayer() {
		return multiplayer;
	}
	
	public boolean isOnline() {
		return online;
	}
	
	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
	}
	
	public String getInfo() {
		return "Nome = " + this.nome + ", Gênero = " + this.genero + ", Descrição = " + this.descricao;
	}
	
	
}
