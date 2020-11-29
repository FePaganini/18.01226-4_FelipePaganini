package dao;

import model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que fará a comunicação com o Banco de Dados dos Personagens e implementa as interfaces
 * DAO-Personagem- e DAOFields
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 29/11/2020
 * @version 1.0
 */
public class PersonagemDAO implements DAO<Personagem>, DAOFields{

    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:personagens.db";

    /**
     * Construtor da classe a qual estabelece a ligação com o banco de dados de Personagens
     */
    public PersonagemDAO(){
        try{
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * @return retorna uma lista de Personagem, com todos os Personagens registrados no DB
     */
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

    /**
     * @param personagem objeto da classe Personagem que terá seus valores atualizados no DB
     */
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


    /**
     * @param personagem objeto da classe Personagem que será deletado, a partir do Id, do DB
     */
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

    /**
     * @param personagem objeto da classe Personagem que será inserido no DB
     */
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

    /**
     * @return uma String que é o nome da tabela do DB
     */
    @Override
    public String getTableName() {
        return "personagens";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando utilizado pelo SQL de excluir dados da tabela a partir do Id
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando utilizado pelo SQL de alterar dados da tabela a partir do Id
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE " + table + " SET nome = ?, raca = ?, profissao = ?, mana = ?, atk = ?, atkMag = ?, def = ?, " +
                "defMag = ?, velocidade = ?, destreza = ?, experiencia = ?, nivel = ? WHERE id = ?;";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando utilizado pelo SQL de inserir dados na tabela
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome ,raca, profissao, mana, atk, atkMag, def, defMag, " +
                "velocidade, destreza, experiencia, nivel) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    /**
     * @param table String que é o nome da tabela do DB
     * @return retorna uma String com o comando utilizado pelo SQL de selecionar todos os dados da tabela
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }
}
