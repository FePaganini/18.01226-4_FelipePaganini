package dao;

import model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO implements DAO<Personagem>, DAOFields{

    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:personagens.db";

    public PersonagemDAO(){
        try{
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List getAll() {
        List<Personagem> personagens = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getSelectAllString(getTableName()));
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                Personagem personagem = new Personagem(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("raca"),
                        result.getString("profissao"),
                        result.getInt("mana"),
                        result.getInt("atk"),
                        result.getInt("atkMag"),
                        result.getInt("def"),
                        result.getInt("defMag"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("experiencia"),
                        result.getInt("nivel")
                );
                personagens.add(personagem);
            }
            result.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return personagens;
    }

    @Override
    public void update(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca());
            preparedStatement.setString(3, personagem.getProfissao());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAtk());
            preparedStatement.setInt(6, personagem.getAtkMag());
            preparedStatement.setInt(7, personagem.getDef());
            preparedStatement.setInt(8, personagem.getDefMag());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivel());
            preparedStatement.setInt(13, personagem.getId());
            int retorno = preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setInt(1, personagem.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void create(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca());
            preparedStatement.setString(3, personagem.getProfissao());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAtk());
            preparedStatement.setInt(6, personagem.getAtkMag());
            preparedStatement.setInt(7, personagem.getDef());
            preparedStatement.setInt(8, personagem.getDefMag());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivel());
            int retorno = preparedStatement.executeUpdate();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "personagens";
    }

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE " + table + " SET nome = ?, raca = ?, profissao = ?, mana = ?, atk = ?, atkMag = ?, def = ?, " +
                "defMag = ?, velocidade = ?, destreza = ?, experiencia = ?, nivel = ? WHERE id = ?;";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome ,raca, profissao, mana, atk, atkMag, def, defMag, " +
                "velocidade, destreza, experiencia, nivel) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }
}
