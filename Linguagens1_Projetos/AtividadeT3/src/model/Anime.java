package model;

public class Anime {
    private String nome, sinopse, url;
    private double nota;
    private int episodios;

    public Anime(String nome, String sinopse, String url, double nota, int episodios) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.url = url;
        this.nota = nota;
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Nome = '" + nome + '\'' +
                "\nSinopse = '" + sinopse + '\'' +
                "\nUrl da imagem = '" + url + '\'' +
                "\nNota = " + nota +
                "\nEpisodios = " + episodios + "\n";
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getUrl() {
        return url;
    }

    public double getNota() {
        return nota;
    }

    public int getEpisodios() {
        return episodios;
    }
}
