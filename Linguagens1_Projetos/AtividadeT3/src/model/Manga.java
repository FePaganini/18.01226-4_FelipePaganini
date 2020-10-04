package model;

/**
 * Classe concreta que representa um Mangá
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class Manga {
    private String nome, sinopse, url, tipo;
    private double nota;
    private int capitulos, volumes;

    /**
     * Construtor da classe Manga
     * @param nome String que é o nome do Manga
     * @param sinopse String que é a sinopse do Manga
     * @param url String que é a url da imagem do Manga
     * @param tipo String que é o tipo do Manga
     * @param nota Double que é a nota do Manga
     * @param capitulos Int que é o numero de capitulos do Manga
     * @param volumes Int que é o numero de volumes do Manga
     */
    public Manga(String nome, String sinopse, String url, String tipo, double nota, int capitulos, int volumes) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.url = url;
        this.tipo = tipo;
        this.nota = nota;
        this.capitulos = capitulos;
        this.volumes = volumes;
    }

    /**
     * @return retorna uma String com os parametros do Manga
     */
    @Override
    public String toString() {
        return "Nome = '" + nome + '\'' +
                "\nSinopse = '" + sinopse + '\'' +
                "\nUrl = '" + url + '\'' +
                "\nTipo = '" + tipo + '\'' +
                "\nNota = " + nota +
                "\nCapitulos = " + capitulos +
                "\nVolumes = " + volumes + "\n";
    }

    /**
     * @return retorna uma String que é o nome do Manga
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return retorna uma String que é a sinopse do Manga
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @return retorna uma String que é a url da imagem do Manga
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return retorna uma String que é o tipo do Manga
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return retorna um Double que é a nota do Manga
     */
    public double getNota() {
        return nota;
    }

    /**
     * @return retorna um Int que é o numero de capitulos do Manga
     */
    public int getCapitulos() {
        return capitulos;
    }

    /**
     * @return retorna um Int que é o numero de volumes do Manga
     */
    public int getVolumes() {
        return volumes;
    }
}
