package sample.model;

import java.util.ArrayList;
import java.util.List;

public class PokeCardList {
    public List<PokeCard> pokeCardList;

    public PokeCardList(){
        this.pokeCardList = new ArrayList<>();
    }
    public boolean idValidate(String newId){
        for(PokeCard pokeCard: this.pokeCardList){
            if(pokeCard.getId().equals(newId)){
                return true;
            }
        }
        return false;
    }
}
