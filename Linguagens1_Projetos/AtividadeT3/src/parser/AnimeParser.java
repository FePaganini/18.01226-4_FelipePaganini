package parser;

import model.Anime;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe que retornará um Anime com a análise do Json recebido
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class AnimeParser {
    /**
     * @param json String que é o Json que será analisado
     * @return retorna o Anime com as informações pedidas ao Json
     */
    public static Anime parseJson(String json){
        JSONObject retorno = new JSONObject(json);
        JSONArray results = retorno.getJSONArray("results");
        Anime anime = new Anime(
                results.getJSONObject(0).getString("title"),
                results.getJSONObject(0).getString("synopsis"),
                results.getJSONObject(0).getString("image_url"),
                results.getJSONObject(0).getDouble("score"),
                results.getJSONObject(0).getInt("episodes")
        );
        return anime;
    }
}
