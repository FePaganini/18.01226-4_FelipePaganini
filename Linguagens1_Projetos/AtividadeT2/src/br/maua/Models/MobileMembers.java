package br.maua.Models;

import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;

public class MobileMembers extends Membro {
    public MobileMembers(String nome, String email, Enum<TiposMembros> funcao) {
        super(nome, email, funcao);
    }

    @Override
    public void relatorio() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Cargo: " + funcao);
    }

    @Override
    public void mensagem(Enum<Horarios> tempo) {
        if (tempo == Horarios.values()[0]) {
            System.out.println("Happy Coding!");
        }
        else {
            System.out.println("Happy_C0d1ng. Maskers");
        }
    }
}