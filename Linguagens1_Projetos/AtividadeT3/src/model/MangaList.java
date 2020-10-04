package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta que representa uma Lista de Mangas
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class MangaList {
    public List<Manga> mangaList;

    /**
     * Construtor da Classe MangaList
     */
    public  MangaList(){
        this.mangaList = new ArrayList<>();
    }

    /**
     * @param novoNome String que representa o nome do Manga que será buscado na lista de Mangas
     * @return retorna true se encontrou o Manga com nome procurado e false se não encontrou
     */
    public boolean nomeExistente(String novoNome){
        for(Manga manga: this.mangaList){
            if(manga.getNome().equals(novoNome)){
                return true;
            }
        }
        return false;
    }
}
