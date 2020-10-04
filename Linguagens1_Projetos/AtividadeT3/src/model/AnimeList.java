package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta que representa uma Lista de Animes
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class AnimeList {
    public List<Anime> animeList;

    /**
     * Construtor da Classe AnimeList
     */
    public  AnimeList(){
        this.animeList = new ArrayList<>();
    }

    /**
     * @param novoNome String que representa o nome do anime que será buscado na lista de Animes
     * @return retorna true se encontrou o Anime com nome procurado e false se não encontrou
     */
    public boolean nomeExistente(String novoNome){
        for(Anime anime: this.animeList){
            if(anime.getNome().equals(novoNome)){
                return true;
            }
        }
        return false;
    }
}
