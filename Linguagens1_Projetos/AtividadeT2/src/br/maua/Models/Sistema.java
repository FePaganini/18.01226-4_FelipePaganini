package br.maua.Models;
import java.util.ArrayList;
import java.util.Scanner;
import br.maua.Enum.Horarios;
import br.maua.Enum.TiposMembros;

/**
 * Classe concreta que representa nosso sistema principal, no qual o usuário poderá tomar decisões do que fazer
 * (adicionar membros, remover membros, mudar horário de trabalho, postar mensagens dos membros)
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public class Sistema {
    Scanner scan = new Scanner(System.in);
    Enum<Horarios> tempo = Horarios.values()[0];
    ArrayList<Membro> membros = new ArrayList<>();
    int escolha = 0;

    /**
     * Método que implementa os métodos menu() e acao() caso a opção seja diferente da saída do sistema (5)
     */
    public void rodar(){
        while (escolha != 5) {
            menu();
            acao();
        }
    }

    /**
     * Método que implementa o menu do sistema, mostrando as opções que o usuário pode escolher
     */
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

    /**
     * Método que implementa as ações a serem tomadas após a escolha da opção
     */
    public void acao(){
        escolha = Integer.parseInt(scan.nextLine());
        switch(escolha){
            /**
             * Opção 0: cadastra membros a partir de nome, email e cargo
             */
            case 0:
                System.out.print("Nome do usuário: ");
                String nome = scan.nextLine();
                System.out.print("Email do usuário: ");
                String email = scan.nextLine();
                System.out.println("Cargo do usuário: ");
                System.out.println("0 - Mobile Members \n1 - Heavy Lifters \n2 - Script Guys \n3 - Big Brothers");
                int func = Integer.parseInt(scan.nextLine());
                /**
                 * Dependendo da escolha, adiciona uma Classe (BigBrothers, HeavyLifters, ScriptGuys ou Mobile Members
                 * ao ArrayList<Membro> membros
                 */
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
            /**
             * Opção 1: Percorre o ArrayList e a cada index dele utiliza o método relatório() que implementa
             * a Interface Apresentacao
             */
            case 1:
                for(int i=0; i< membros.size();i++){
                    membros.get(i).relatorio();
                    System.out.println("-------------");
                }
                break;
            /**
             * Opção 2: Percorre o ArrayList e a cada index dele utiliza o método mensagem(tempo) que implementa
             * a Interface PostarMensagem
             */
            case 2:
                for(int i=0; i< membros.size();i++){
                    membros.get(i).mensagem(tempo);
                    System.out.println("-------------");
                }
                break;
            /**
             * Opção 3: Utiliza a váriavel tempo que salva, a partir do Enum Horários o estado atual de trabalho
             */
            case 3:
                if(tempo == Horarios.values()[0]){
                    tempo = Horarios.values()[1];
                }
                else{
                    tempo = Horarios.values()[0];
                }
                break;
            /**
             * Opção 4: Percorre o ArrayList e a cada index dele utiliza o método relatório() que implementa
             * a Interface Apresentacao, após serem mostrados os membros cadastrados, pode-se se escolher pela
             * qual o membro será removido
             * @param num número ligado ao membro que vamos remover
             */
            case 4:
                for(int i=0; i< membros.size();i++){
                    System.out.println("Número: " + (i+1));
                    membros.get(i).relatorio();
                    System.out.println("-------------");
                }
                System.out.print("Escolha um número para remover um usuário: ");
                int num = Integer.parseInt(scan.nextLine());
                membros.remove(num-1);
                break;
        }
    }
}