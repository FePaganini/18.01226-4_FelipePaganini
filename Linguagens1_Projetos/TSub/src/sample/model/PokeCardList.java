package sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Felipe dos Santos Paganini 18.01226-4
 * @author Thiago T. Yara de Araujo 18.01363-5
 * @since 21/09/2020
 */

public class PokeCardList {
    public List<PokeCard> pokeCardList;

    public PokeCardList(){
        this.pokeCardList = new ArrayList<>();
    }

    /**
     * @param newId o id que será verificada a existência
     * @return True = existe um carta com esse newId | Falso = não existe um carta com esse newId
     */
    public boolean idValidate(String newId){
        for(PokeCard pokeCard: this.pokeCardList){
            if(pokeCard.getId().equals(newId)){
                return true;
            }
        }
        return false;
    }
}
