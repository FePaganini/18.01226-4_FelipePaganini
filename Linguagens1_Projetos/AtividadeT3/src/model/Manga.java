package model;

public class Manga {
    private String nome, sinopse, url, tipo;
    private double nota;
    private int capitulos, volumes;

    public Manga(String nome, String sinopse, String url, String tipo, double nota, int capitulos, int volumes) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.url = url;
        this.tipo = tipo;
        this.nota = nota;
        this.capitulos = capitulos;
        this.volumes = volumes;
    }

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

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getUrl() {
        return url;
    }

    public String getTipo() {
        return tipo;
    }

    public double getNota() {
        return nota;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public int getVolumes() {
        return volumes;
    }
}
