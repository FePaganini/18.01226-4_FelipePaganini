package parser;

import model.Manga;
import org.json.JSONArray;
import org.json.JSONObject;

public class MangaParser {
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
