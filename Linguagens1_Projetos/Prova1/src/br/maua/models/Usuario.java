package br.maua.models;
import br.maua.interfaces.Autentificador;

/**
 * Classe concreta que representa o usuário do sistema, ela implementa a interface Autentificador
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public class Usuario implements Autentificador{
    private String nome;
    private String email;
    private String senha;

    /**
     * Construtor da classe Usuário
     * @param nome String: nome do usuário
     * @param email String: email do usuário
     * @param senha String: senha do usuário que será utilizada para criar pedidos ou alterá-los
     */
    public Usuario(String nome,String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    /**
     * Método da Interface Autentificador
     * @param senha senha que será digitada pelo usuário para ser autentificada
     * @return retorna um Boolean: valor true caso a senha digitada pelo usuário ser igual a do construtor dele, caso
     * contrário retorna false
     */
    @Override
    public boolean autentificacao(String senha) {
        if(senha.equals(this.senha)){
            return true;
        }
        else{
            return false;
        }
    }
}
