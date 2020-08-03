package br.maua.teste;

import br.maua.model.Jogo;
import br.maua.model.ListaDeJogos;

public class TesteListaDeJogos {
    public static void main(String[] args) {
        ListaDeJogos jogos = new ListaDeJogos();
        System.out.println("Lista Atual:"+jogos);

        Jogo jogo1 = new Jogo("PC","Diablo");
        Jogo jogo2 = new Jogo("PC","Lol");
        Jogo jogo3 = new Jogo("PC","Candy Crush");

        jogos.addJogo(jogo1);
        jogos.addJogo(jogo2);
        jogos.addJogo(jogo3);

        System.out.println("Lista Atual:"+jogos);
    }
}
