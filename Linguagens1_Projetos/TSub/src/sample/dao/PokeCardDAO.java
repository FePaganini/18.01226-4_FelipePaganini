package sample.dao;

import sample.model.PokeCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Felipe dos Santos Paganini 18.01226-4
 * @author Thiago T. Yara de Araujo 18.01363-5
 * @since 21/09/2020
 */

public class PokeCardDAO implements  DAO<PokeCard>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:dadospokecards.db";

    public PokeCardDAO(){
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Faz um busca no arquivo disponibilizado, o qual é o banco de dados, e a partir dele salva os dados linha por
     * linha em uma lista. Caso ocorra um erro, ele será reportado no console.
     * @return Lista com dados do arquivo disponibilizado
     */
    @Override
    public List<PokeCard> getAll() {
        List<PokeCard> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                PokeCard pokeCard = new PokeCard(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("name"),
                        result.getString("rarity"),
                        result.getString("series"),
                        result.getString("set_collection")
                );
                list.add(pokeCard);
            }
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * Atualiza, a partir de um id, os dados de uma carta existente no banco de dados. Caso ocorra um erro, ele será
     * reportado no console.
     * @param pokeCard Objeto da Poke Carta que será atualizada
     */
    @Override
    public void update(PokeCard pokeCard) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1,pokeCard.getId());
            preparedStatement.setString(2,pokeCard.getName());
            preparedStatement.setString(3,pokeCard.getRarity());
            preparedStatement.setString(4,pokeCard.getSeries());
            preparedStatement.setString(5,pokeCard.getSet());
            preparedStatement.setString(6,pokeCard.getUrl());
            preparedStatement.setString(7,pokeCard.getId());
            int retorno = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Cria uma nova Poke Carta e adiciona no banco de dados. Caso ocorra um erro, ele será reportado no console.
     * @param pokeCard Objeto da Poke Carta que será criada e adicionada ao banco de dados
     */
    @Override
    public void create(PokeCard pokeCard) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, pokeCard.getId());
            preparedStatement.setString(2,pokeCard.getName());
            preparedStatement.setString(3,pokeCard.getRarity());
            preparedStatement.setString(4,pokeCard.getSeries());
            preparedStatement.setString(5,pokeCard.getSet());
            preparedStatement.setString(6,pokeCard.getUrl());
            // Executes PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @return  Nome da tabela do banco de dados
     */
    @Override
    public String getTableName() {
        return "pokecards";
    }

    /**
     * @param table Nome da tabela do banco de dados
     * @return  Função Update do SQL, todos os ? serão substituídos pelos valores corretos
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE " + table + " SET id = ?, name= ?, rarity = ?, series = ?, set_collection = ?, url = ? WHERE id = ?;";
    }

    /**
     * @param table Nome da tabela do banco de dados
     * @return  Função Insert do SQL, todos os ? serão substituídos pelos valores corretos
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+table+ " (id, name, rarity, series, set_collection, url) VALUES (?, ?, ?, ?, ?, ?);";
    }

    /**
     * @param table Nome da tabela do banco de dados
     * @return  Função Select do SQL, todos os ? serão substituídos pelos valores corretos
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

}
