package br.maua;
import br.maua.Models.Sistema;

/**
 * Classe porta de entrada da aplicação base
 * Ela é responsável por iniciar a aplicação do Sistema
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public class Main{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.rodar();
    }
}
