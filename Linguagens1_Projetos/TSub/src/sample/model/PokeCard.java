package sample.model;

/**
 * @author Felipe dos Santos Paganini 18.01226-4
 * @author Thiago T. Yara de Araujo 18.01363-5
 * @since 21/09/2020
 */

public class PokeCard {
    private String url;
    private String id;
    private String name;
    private String rarity;
    private String series;
    private String set;

/**
 * @param url URL completo da imagem da carta
 * @param id id único da carta
 * @param name nome da carta
 * @param rarity raridade da carta
 * @param series serie a qual a carta pertence
 * @param set set/coleção a qual a carta pertence
 */
    public PokeCard(String url, String id, String name, String rarity, String series, String set) {
        this.url = url;
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.series = series;
        this.set = set;
    }

    /**
     * @return URL completo da imagem da carta
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return id único da carta
     */
    public String getId() {
        return id;
    }

    /**
     * @return nome da carta
     */
    public String getName() {
        return name;
    }

    /**
     * @return raridade da carta
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * @return serie a qual a carta pertence
     */
    public String getSeries() {
        return series;
    }

    /**
     * @return set/coleção a qual a carta pertence
     */
    public String getSet() {
        return set;
    }
}
