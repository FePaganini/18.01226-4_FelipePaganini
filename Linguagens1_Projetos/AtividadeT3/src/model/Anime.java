package model;

/**
 * Classe concreta que representa um Anime
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class Anime {
    private String nome, sinopse, url;
    private double nota;
    private int episodios;

    /**
     * Construtor da classe Anime
     * @param nome String que é o nome do Anime
     * @param sinopse String que é a sinopse do Anime
     * @param url String que é a url da imagem do Anime
     * @param nota Double que é a nota do Anime
     * @param episodios Int que é o número de episódios do Anime
     */
    public Anime(String nome, String sinopse, String url, double nota, int episodios) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.url = url;
        this.nota = nota;
        this.episodios = episodios;
    }

    /**
     * @return retorna uma String com os parâmetros do Anime
     */
    @Override
    public String toString() {
        return "Nome = '" + nome + '\'' +
                "\nSinopse = '" + sinopse + '\'' +
                "\nUrl da imagem = '" + url + '\'' +
                "\nNota = " + nota +
                "\nEpisodios = " + episodios + "\n";
    }

    /**
     * @return retorna uma String que é o nome do Anime
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return retorna uma String que é a sinopse do Anime
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @return retorna uma String que é a url da imagem do Anime
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return retorna um Double que é a nota do Anime
     */
    public double getNota() {
        return nota;
    }

    /**
     * @return retorna um Int que é o número de episódios do Anime
     */
    public int getEpisodios() {
        return episodios;
    }
}
