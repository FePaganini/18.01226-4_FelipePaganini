package dao;

import model.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que fará a comunicação com o Banco de Dados dos Mangás e implementa as interfaces DAO-Manga-
 * e DAOFields
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 04/10/2020
 * @version 1.0
 */
public class MangaDAO implements  DAO<Manga>, DAOFields{

    private Connection connection;
    private String DBString = "jdbc:sqlite:manga.db";

    /**
     * Construtor da classe, que estabelece a ligação com o banco de dados de Mangas
     */
    public MangaDAO(){
        try {
            connection = DriverManager.getConnection(DBString);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    /**
     * @param nome é uma String que é o nome do Manga que será pesquisado no DB
     * @return retorna uma lista de Mangá (no caso essa lista terá somente um mangá, o qual é o mangá que
     * tem o nome recebido pela parametro nome)
     */
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

    /**
     * @return retorna uma lista de Mangá, com todos os Mangás registrados no DB
     */
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

    /**
     * @param manga objeto da Classe Manga que será inserido no DB
     */
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

    /**
     * @return retorna uma String que é o nome da tabela do DB
     */
    @Override
    public String getTableName() {
        return "manga";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando (utilizado pelo SQL) de inserir na tabela
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, sinopse, url, capitulos, volumes, tipo, nota) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?);";
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
     * @param nome String que é nome do mangá que será buscado no DB
     * @return retorna uma String com o comando (utilizado pelo SQL) de selecionar dados específicos
     * (a partir de uma chave) da tabela
     */
    @Override
    public String getSelectKey(String table, String nome) {
        return "SELECT * FROM " + table + " WHERE nome = '" + nome + "'";
    }
}
