package br.maua.Models;
import java.util.Scanner;
import br.maua.Enum.Horarios;
public class Sistema {
    Scanner scan = new Scanner(System.in);
    Enum<Horarios> tempo = Horarios.values()[0];
    int escolha = 0;

    public void rodar(){
        while (escolha != 5) {
            menu();
            acao();
        }
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
        System.out.print("Opção escolhida: ");
    }
    public void acao(){
        escolha = Integer.parseInt(scan.nextLine());
        switch(escolha){
            case 0:
                System.out.println("oi");
                break;
            case 1:
                System.out.println("oi");
                break;
            case 2:
                System.out.println("oi");
                break;
            case 3:
                if(tempo == Horarios.values()[0]){
                    tempo = Horarios.values()[1];
                }
                else{
                    tempo = Horarios.values()[0];
                }
                break;
            case 4:
                System.out.println("oi");
                break;
        }
    }
}