package parser;

import model.Manga;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe que retornará um Manga com a análise do Json recebido
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class MangaParser {
    /**
     * @param json String que é o Json que será analisado
     * @return retorna o Manga com as informações pedidas ao Json
     */
    public static Manga parseJson(String json){
        JSONObject retorno = new JSONObject(json);
        JSONArray results = retorno.getJSONArray("results");
        Manga manga = new Manga(
                results.getJSONObject(0).getString("title"),
                results.getJSONObject(0).getString("synopsis"),
                results.getJSONObject(0).getString("image_url"),
                results.getJSONObject(0).getString("type"),
                results.getJSONObject(0).getDouble("score"),
                results.getJSONObject(0).getInt("chapters"),
                results.getJSONObject(0).getInt("volumes")
        );
        return manga;
    }
}
