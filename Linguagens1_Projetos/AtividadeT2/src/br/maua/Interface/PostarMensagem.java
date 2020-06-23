package br.maua.Interface;
import br.maua.Enum.Horarios;

/**
 * Interface que define as mensagens que os Membros podem retornar dependendo do horário de trabalho
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public interface PostarMensagem{
    /**
     * Método para implementação da interface PostarMensagem, que retorna a mensagem que os Membros escreverão
     * dependendo do horário de trabalho
     * @param tempo Enumeração que define os horários de trabalho
     */
    public void mensagem(Enum<Horarios> tempo);
}
