package dao;

import model.Anime;

import java.util.List;

public class AnimeDAO implements DAO<Anime>,DAOFields{

    @Override
    public List<Anime> getAll() {
        return null;
    }

    @Override
    public void create(Anime anime) {

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
