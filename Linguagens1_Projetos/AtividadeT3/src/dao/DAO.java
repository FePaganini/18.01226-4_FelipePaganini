package dao;

import java.util.List;

public interface DAO<T>{
    List<T> getKey(String nome);
    List<T> getAll();
    void create(T t);
}
