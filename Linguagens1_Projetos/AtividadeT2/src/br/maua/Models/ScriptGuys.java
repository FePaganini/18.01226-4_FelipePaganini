package br.maua.Models;
import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;

public class ScriptGuys extends Membro{
    public ScriptGuys(String nome, String email, Enum<TiposMembros> funcao) {
        super(nome, email, funcao);
    }
    @Override
    public void relatorio() {
        System.out.println("Nome: "+ nome);
        System.out.println("Email: "+ email);
        System.out.println("Cargo: "+funcao);
    }

    @Override
    public void mensagem(Enum<Horarios> tempo) {
        if (tempo == Horarios.values()[0]) {
            System.out.println("Prazer em ajudar novos amigos de código!");
        }
        else {
            System.out.println("QU3Ro_S3us_r3curs0s.py");
        }
    }
}
