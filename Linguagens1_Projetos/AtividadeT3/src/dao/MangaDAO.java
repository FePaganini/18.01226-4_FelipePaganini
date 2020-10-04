package dao;

import model.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaDAO implements  DAO<Manga>, DAOFields{

    private Connection connection;
    private String DBString = "jdbc:sqlite:manga.db";

    public MangaDAO(){
        try {
            connection = DriverManager.getConnection(DBString);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Manga> getKey(String nome) {
        List<Manga> mangas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectKey(getTableName(), nome));
            while (result.next()){
                Manga manga = new Manga(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getString("url"),
                        result.getString("tipo"),
                        result.getDouble("nota"),
                        result.getInt("capitulos"),
                        result.getInt("volumes")
                );
                mangas.add(manga);
            }
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mangas;
    }

    @Override
    public List<Manga> getAll() {
        List<Manga> mangas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while (result.next()){
                Manga manga = new Manga(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getString("url"),
                        result.getString("tipo"),
                        result.getDouble("nota"),
                        result.getInt("capitulos"),
                        result.getInt("volumes")
                );
                mangas.add(manga);
            }
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mangas;
    }

    @Override
    public void create(Manga manga) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, manga.getNome());
            preparedStatement.setString(2, manga.getSinopse());
            preparedStatement.setString(3, manga.getUrl());
            preparedStatement.setInt(4, manga.getCapitulos());
            preparedStatement.setInt(5, manga.getVolumes());
            preparedStatement.setString(6, manga.getTipo());
            preparedStatement.setDouble(7, manga.getNota());

            // Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Possível erro de digitação e o Manga já está cadastrado no DB\n");
        }
    }

    @Override
    public String getTableName() {
        return "manga";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, sinopse, url, capitulos, volumes, tipo, nota) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectKey(String table, String nome) {
        return "SELECT * FROM " + table + " WHERE nome = '" + nome + "'";
    }
}
