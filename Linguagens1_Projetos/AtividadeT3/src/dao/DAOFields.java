package dao;

/**
 * Interface que auxiliará a comunicação com o Banco de Dados, ou seja, terá os comandos que são utilizados
 * pelo SQLOnline: comando de retornar nome da tabela, comando de inserir dados na tabela, comando de
 * selecionar dados da tabela ou comando de selecionar dados específicos da tabela.
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public interface DAOFields {
    String getTableName();
    String getInsertString(String table);
    String getSelectAllString(String table);
    String getSelectKey(String table, String nome);
}
