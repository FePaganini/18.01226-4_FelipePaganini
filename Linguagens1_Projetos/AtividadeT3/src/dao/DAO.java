package dao;

import java.util.List;

/**
 * Interface que fará a comunicação com o Banco de Dados: pegar todos os dados do DB, pegar dados específicos
 * de determinada key ("nome") ou inserir novos dados no DB
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public interface DAO<T>{
    List<T> getKey(String nome);
    List<T> getAll();
    void create(T t);
}
