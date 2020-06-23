package br.maua.Models;

import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;
/**
 * Classe concreta que representa o cargo Heavy Lifters, ela define as mensagens que um Heavy Lifters podem retornar
 * dependendo do horário de trabalho
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public class HeavyLifters extends Membro {
    public HeavyLifters(String nome, String email, Enum<TiposMembros> funcao) {
        super(nome, email, funcao);
    }
    /**
     * Método que implementa a interface Apresentacao, ela retorna o nome, email e cargo dos Heavy Lifters
     */
    @Override
    public void relatorio() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Cargo: " + funcao);
    }
    /**
     * Método para implementação da interface PostarMensagem, que retorna a mensagem que os Heavy Lifters escreverão
     * dependendo do horário de trabalho
     * @param tempo Enumeração que define os horários de trabalho
     */
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