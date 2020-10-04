package dao;

import model.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDAO implements DAO<Anime>,DAOFields{

    private Connection connection;
    private String DBString = "jdbc:sqlite:anime.db";

    public AnimeDAO(){
        try {
            connection = DriverManager.getConnection(DBString);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Anime> getKey(String nome) {
        List<Anime> animes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectKey(getTableName(), nome));
            while (result.next()) {
                Anime anime = new Anime(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getString("url"),
                        result.getDouble("nota"),
                        result.getInt("episodios")
                );
                animes.add(anime);
            }
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return animes;
    }

    @Override
    public List<Anime> getAll() {
        List<Anime> animes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while (result.next()) {
                Anime anime = new Anime(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getString("url"),
                        result.getDouble("nota"),
                        result.getInt("episodios")
                );
                animes.add(anime);
            }
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return animes;
    }

    @Override
    public void create(Anime anime) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, anime.getNome());
            preparedStatement.setString(2, anime.getSinopse());
            preparedStatement.setString(3, anime.getUrl());
            preparedStatement.setInt(4, anime.getEpisodios());
            preparedStatement.setDouble(5, anime.getNota());
            int retorno = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "anime";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, sinopse, url, episodios, nota) VALUES " +
                "(?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectKey(String table, String nome) {
        return "SELECT * FROM " + table + " WHERE nome = " + nome;
    }

}
