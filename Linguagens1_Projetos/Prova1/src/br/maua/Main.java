package br.maua;

import br.maua.models.Pizzaria;

/**
 * Classe porta de entrada da aplicação base ela é responsável por iniciar a aplicação da classe Pizzaria
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Pizzaria pizzaria = new Pizzaria();
        pizzaria.rodar();
    }
}
