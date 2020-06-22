package br.maua.Models;
import java.util.Scanner;
import br.maua.Enum.Horarios;
public class Sistema {
    Scanner scan = new Scanner(System.in);
    Enum<Horarios> tempo = Horarios.values()[0];

    public void rodar(){
        menu();
    }

    public void menu(){
        System.out.println("Seja bem-vindo a MAsK_S0c13ty");
        System.out.println("O horário de trabalho atual é: "+ tempo);
        System.out.println("Escolha uma das seguintes opções abaixo:");
        System.out.println("0 - Registrar novo membro");
        System.out.println("1 - Apresentar membros cadastrados");
        System.out.println("2 - Postar mensagem");
        System.out.println("3 - Trocar horário de trabalho");
        System.out.println("4 - Retirar membro");
        System.out.println("5 - Fechar sistema ");
    }
}
