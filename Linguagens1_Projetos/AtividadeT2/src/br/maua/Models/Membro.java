package br.maua.Models;
import br.maua.Enum.TiposMembros;
import br.maua.Interface.Apresentacao;
import br.maua.Interface.PostarMensagem;

/**
 * Representação da abstração Membro, ela assina as implementações das interfaces Apresentacao e PostarMensagem
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public abstract class Membro implements Apresentacao, PostarMensagem {
    protected String nome,email;
    protected Enum<TiposMembros> funcao;

    /**
     * @param nome Nome escolhido pro Membro
     * @param email Email escolhido pro Membro
     * @param funcao Enumeração que define o cargo do nosso Membro
     */
    public Membro(String nome, String email, Enum<TiposMembros> funcao) {
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
    }
}
