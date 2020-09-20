package sample.model;

public class PokeCard {
    private String url;
    private String id;
    private String name;
    private String rarity;
    private String series;
    private String set;

    public PokeCard(String url, String id, String name, String rarity, String series, String set) {
        this.url = url;
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.series = series;
        this.set = set;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public String getSeries() {
        return series;
    }

    public String getSet() {
        return set;
    }
}
