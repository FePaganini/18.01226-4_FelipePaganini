package br.maua.Models;
import java.util.ArrayList;
import java.util.Scanner;
import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;

public class Sistema {
    Scanner scan = new Scanner(System.in);
    Enum<Horarios> tempo = Horarios.values()[0];
    ArrayList<Membro> membros = new ArrayList<>();
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
                System.out.print("Nome do usuário: ");
                String nome = scan.nextLine();
                System.out.print("Email do usuário: ");
                String email = scan.nextLine();
                System.out.println("Cargo do usuário: ");
                System.out.println("0 - Mobile Members \n 1 - Heavy Lifters \n 2 - Script Guys \n 3 - Big Brothers");
                int func = Integer.parseInt(scan.nextLine());
                switch (func) {
                    case 0:
                        membros.add(new MobileMembers(nome,email,TiposMembros.values()[0]));
                        break;
                    case 1:
                        membros.add(new HeavyLifters(nome,email,TiposMembros.values()[1]));
                        break;
                    case 2:
                        membros.add(new ScriptGuys(nome,email,TiposMembros.values()[2]));
                        break;
                    case 3:
                        membros.add(new BigBrothers(nome,email,TiposMembros.values()[3]));
                        break;
                }
                break;
            case 1:
                for(int i=0; i< membros.size();i++){
                    membros.get(i).relatorio();
                    System.out.println("-------------");
                }
                break;
            case 2:
                for(int i=0; i< membros.size();i++){
                    membros.get(i).mensagem(tempo);
                    System.out.println("-------------");
                }
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