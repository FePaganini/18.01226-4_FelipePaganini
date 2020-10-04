package dao;

import model.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que fará a comunicação com o Banco de Dados dos Animes e implementa as interfaces DAO-Anime-
 * e DAOFields
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class AnimeDAO implements DAO<Anime>,DAOFields{

    private Connection connection;
    private String DBString = "jdbc:sqlite:anime.db";

    /**
     * Construtor da classe, que estabelece a ligação com o banco de dados de Animes
     */
    public AnimeDAO(){
        try {
            connection = DriverManager.getConnection(DBString);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    /**
     * @param nome é uma String que é o nome do Anime que será pesquisado no DB
     * @return retorna uma lista de Anime (no caso essa lista terá somente um anime, o qual é o anime que
     * tem o nome recebido pela parametro nome)
     */
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

    /**
     * @return retorna uma lista de Anime, com todos os Animes registrados no DB
     */
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

    /**
     * @param anime objeto da Classe Anime que será inserido no DB
     */
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
            System.out.println("Possível erro de digitação e o Anime já está cadastrado no DB\n");
        }
    }

    /**
     * @return retorna uma String que é o nome da tabela do DB
     */
    @Override
    public String getTableName() {
        return "anime";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando (utilizado pelo SQL) de inserir na tabela
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, sinopse, url, episodios, nota) VALUES " +
                "(?, ?, ?, ?, ?);";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando (utilizado pelo SQL) de selecionar todos dados da tabela
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * @param table String que é nome da tabela do DB
     * @param nome String que é nome do anime que será buscado no DB
     * @return retorna uma String com o comando (utilizado pelo SQL) de selecionar dados específicos
     * (a partir de uma chave) da tabela
     */
    @Override
    public String getSelectKey(String table, String nome) {
        return "SELECT * FROM " + table + " WHERE nome = '" + nome+"'";
    }

}
