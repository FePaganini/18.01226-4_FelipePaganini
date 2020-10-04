package dao;

import model.Manga;

import java.util.List;

public class MangaDAO implements  DAO<Manga>, DAOFields{

    @Override
    public List<Manga> getAll() {
        return null;
    }

    @Override
    public void create(Manga manga) {

    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getInsertString(String table) {
        return null;
    }

    @Override
    public String getSelectAllString(String table) {
        return null;
    }
}
