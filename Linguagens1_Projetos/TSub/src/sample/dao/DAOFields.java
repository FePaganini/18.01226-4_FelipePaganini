package sample.dao;

/**
 * @author Felipe dos Santos Paganini 18.01226-4
 * @author Thiago T. Yara de Araujo 18.01363-5
 * @since 21/09/2020
 */

public interface DAOFields {
    String getTableName();
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
}
