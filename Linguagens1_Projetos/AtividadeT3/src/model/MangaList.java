package model;

import java.util.ArrayList;
import java.util.List;

public class MangaList {
    public List<Manga> mangaList;

    public  MangaList(){
        this.mangaList = new ArrayList<>();
    }

    public boolean nomeExistente(String novoNome){
        for(Manga manga: this.mangaList){
            if(manga.getNome().equals(novoNome)){
                return true;
            }
        }
        return false;
    }
}
