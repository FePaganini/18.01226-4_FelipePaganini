package dao;

import java.util.List;

/**
 * Interface que fará a comunicação com o Banco de Dados: pegar todos os dados do DB, fazer a atualização
 * de dados já existentes no DB, deletar dados já existentes no DB ou inserir novos dados no DB
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 29/11/2020
 * @version 1.0
 */
public interface DAO <T>{
        List<T> getAll();
        void update(T t);
        void delete(T t);
        void create(T t);
}
