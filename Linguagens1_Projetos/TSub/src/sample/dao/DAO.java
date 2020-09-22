package sample.dao;

import java.util.List;

/**
 * @author Felipe dos Santos Paganini 18.01226-4
 * @author Thiago T. Yara de Araujo 18.01363-5
 * @since 21/09/2020
 */

public interface DAO <T> {
    List<T> getAll();
    void update(T t);
    void create(T t);
}
