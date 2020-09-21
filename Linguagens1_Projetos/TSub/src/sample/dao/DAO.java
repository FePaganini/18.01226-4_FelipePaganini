// Felipe Dos Santos Paganini | 18.01226-4
package sample.dao;

import java.util.List;

public interface DAO <T> {
    List<T> getAll();
    void update(T t);
    void create(T t);
}
