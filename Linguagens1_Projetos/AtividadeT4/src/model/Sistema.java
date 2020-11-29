package model;

import dao.PersonagemDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private int opcao = 1;
    Scanner scanner = new Scanner(System.in);
    List<Personagem> personagemList = new ArrayList<>();
    PersonagemDAO personagemDAO = new PersonagemDAO();

    public void rodar(){
        while(opcao != 0){
            personagemList = personagemDAO.getAll();
            escolha();
            switch (opcao){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    listaPersonagem();
                    break;
                case 4:
                    listaPersonagem();

                    break;
            }
        }
    }

    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1- Criar Personagem\n2- Alterar Personagem\n3- Consulte Todos Os Personagens" +
            "\n4- Deletar Personagem\n0- Fechar o Sistema");
        System.out.print("Insira sua opção: ");
    }

    public void escolha(){
        while (true) {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                while(opcao > 4 || opcao < 0) {
                    System.out.print("Insira uma opção válida: ");
                    opcao = Integer.parseInt(scanner.nextLine());
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Insira uma opção válida: ");
            }
        }
    }

    public void listaPersonagem(){
        if(personagemList.isEmpty()){
            System.out.println("Lista de Personagens vazia!");
        }
        else{
            System.out.println("Lista de Personagens:");
            personagemList.forEach(personagem -> personagem.toString());
            System.out.println("");
        }
    }
}

