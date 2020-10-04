package parser;

import model.Anime;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnimeParser {
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
