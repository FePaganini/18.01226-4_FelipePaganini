package br.maua.Models;

import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;

public class HeavyLifters extends Membro {
    public HeavyLifters(String nome, String email, Enum<TiposMembros> funcao) {
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
            System.out.println("Podem contar conosco!");
        }
        else {
            System.out.println("N00b_qu3_n_Se_r3pita.bat");
        }
    }
}