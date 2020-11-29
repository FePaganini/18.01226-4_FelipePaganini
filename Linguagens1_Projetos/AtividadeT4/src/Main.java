import model.Sistema;

/**
 * Classe porta de entrada da aplicação base ela é responsável por iniciar a aplicação da classe Sistema
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 29/11/2020
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.rodar();
    }
}

