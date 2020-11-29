package dao;

/**
 * Interface que auxiliará a comunicação com o Banco de Dados, ou seja, terá os comandos que são utilizados
 * pelo SQLOnline: comando de retornar nome da tabela, comando de excluir dados da tabela, comando de inserir
 * dados na tabela, comando de atualizar dados da tabela ou comando de selecionar todos os dados da tabela
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 29/11/2020
 * @version 1.0
 */
public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
}
