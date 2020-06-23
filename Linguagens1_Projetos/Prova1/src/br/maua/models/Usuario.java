package br.maua.models;
import br.maua.interfaces.Autentificador;

public class Usuario implements Autentificador{
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome,String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

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
