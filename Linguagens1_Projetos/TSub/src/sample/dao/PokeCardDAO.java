package sample.dao;

import sample.model.PokeCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            // Execute PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "pokecards";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE " + table + " SET id = ?, name= ?, rarity = ?, series = ?, set_collection = ?, url = ? WHERE id = ?;";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+table+ " (id, name, rarity, series, set_collection, url) VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

}
