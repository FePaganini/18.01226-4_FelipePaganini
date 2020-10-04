package dao;

public interface DAOFields {
    String getTableName();
    String getInsertString(String table);
    String getSelectAllString(String table);
}
