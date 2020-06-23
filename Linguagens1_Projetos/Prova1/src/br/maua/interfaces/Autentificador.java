package br.maua.interfaces;

/**
 * Interface que verifica a senha do usuário para realizar novos pedidos ou alterar os já realizados
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public interface Autentificador {
    public boolean autentificacao(String senha);
}
