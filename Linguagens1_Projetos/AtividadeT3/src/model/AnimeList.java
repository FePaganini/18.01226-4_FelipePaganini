package model;

import java.util.ArrayList;
import java.util.List;

public class AnimeList {
    public List<Anime> animeList;

    public  AnimeList(){
        this.animeList = new ArrayList<>();
    }
    
    public boolean nomeExistente(String novoNome){
        for(Anime anime: this.animeList){
            if(anime.getNome().equals(novoNome)){
                return true;
            }
        }
        return false;
    }
}
