package model;

import java.util.Scanner;

public class Sistema {

    private int opcao = 1;
    Scanner scanner = new Scanner(System.in);

    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1- Procurar Anime\n2- Procurar Manga\n3- Visualizar Dados de Anime" +
                "\n4- Visualizar Dados de Manga\n0- Fechar o Sistema");
        System.out.println("Insira sua opção: ");
    }

    public void rodar() {
        while (opcao != 0) {
            menu();
            while (true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    while (opcao > 4 || opcao < 0) {
                        System.out.println("Insira uma opção válida: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Insira uma opção válida: ");
                }
            }
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
        System.exit(0);
    }
}
