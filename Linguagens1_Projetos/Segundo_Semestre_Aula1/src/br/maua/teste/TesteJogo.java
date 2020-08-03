package br.maua.teste;

import br.maua.model.Jogo;

public class TesteJogo {
    public static void main(String[] args) {
        Jogo jogo = new Jogo("PC", "Lol");
        System.out.println("oi");
        System.out.println(""+jogo.toString());
    }
}
