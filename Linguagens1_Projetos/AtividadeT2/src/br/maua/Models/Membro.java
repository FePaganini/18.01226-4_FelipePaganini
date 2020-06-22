package br.maua.Models;
import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;
import br.maua.Interface.Apresentacao;
import br.maua.Interface.PostarMensagem;

public abstract class Membro implements Apresentacao, PostarMensagem {
    protected String nome,email;
    protected Enum<TiposMembros> funcao;
    public Membro(String nome, String email, Enum<TiposMembros> funcao) {
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
    }
}
