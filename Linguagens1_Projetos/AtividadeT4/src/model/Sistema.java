package model;

import dao.PersonagemDAO;
import enums.Profissoes;
import enums.Raca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private int opcao = 1;
    Scanner scanner = new Scanner(System.in);
    List<Personagem> personagemList = new ArrayList<>();
    PersonagemDAO personagemDAO = new PersonagemDAO();
    private int auxiliar, aux, auxAtributos;

    public void rodar(){
        while(opcao != 0){
            personagemList = personagemDAO.getAll();
            menu();
            escolha();
            switch (opcao){
                case 1:
                    String nome, raca, profissao;
                    int mana, atk, atkMag, def, defMag, velocidade, destreza, experiencia, nivel;
                    System.out.println("Informe seu Nome: ");
                    nome = scanner.nextLine();
                    raca = menuRaca();
                    profissao = menuProfissao();
                    mana = valorAtributo("Mana");
                    atk = valorAtributo("Ataque");
                    atkMag = valorAtributo("Ataque Mágico");
                    def = valorAtributo("Defesa");
                    defMag = valorAtributo("Defesa Mágica");
                    velocidade = valorAtributo("Velocidade");
                    destreza = valorAtributo("Destreza");
                    experiencia = valorAtributo("Experiência");
                    nivel = valorAtributo("Nível");
                    Personagem novo = new Personagem(-1,nome,raca,profissao,mana,atk,atkMag,def,defMag,
                            velocidade,destreza,experiencia,nivel);
                    personagemDAO.create(novo);
                    break;
                case 2:
                    if(listaPersonagem()){
                        break;
                    }
                    System.out.println("Escolha um Id para alterar: ");
                    try{
                        auxiliar = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Não há Personagem com tal Id!");
                        break;
                    }
                    if (idExistente(auxiliar)) {
                        System.out.println("Informe seu Nome: ");
                        nome = scanner.nextLine();
                        raca = menuRaca();
                        profissao = menuProfissao();
                        mana = valorAtributo("Mana");
                        atk = valorAtributo("Ataque");
                        atkMag = valorAtributo("Ataque Mágico");
                        def = valorAtributo("Defesa");
                        defMag = valorAtributo("Defesa Mágica");
                        velocidade = valorAtributo("Velocidade");
                        destreza = valorAtributo("Destreza");
                        experiencia = valorAtributo("Experiência");
                        nivel = valorAtributo("Nível");
                        Personagem atualizado = new Personagem(auxiliar, nome, raca, profissao, mana, atk, atkMag,
                                def, defMag, velocidade, destreza, experiencia, nivel);
                        personagemDAO.update(atualizado);
                        }
                    else {
                        System.out.println("Não há Personagem com tal Id!");
                    }
                    break;
                case 3:
                    listaPersonagem();
                    break;
                case 4:
                    if(listaPersonagem()){
                        break;
                    }
                    System.out.println("Escolha um Id para deletar: ");
                    try{
                        auxiliar = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Não há Personagem com tal Id!");
                        break;
                    }
                    if (idExistente(auxiliar)){
                        Personagem deletado = new Personagem(auxiliar);
                        personagemDAO.delete(deletado);
                    }
                    else{
                        System.out.println("Não há Personagem com tal Id!");
                    }
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1- Criar Personagem\n2- Alterar Atributos do Personagem\n" +
                "3- Consulte Todos Os Personagens\n4- Deletar Personagem\n0- Fechar o Sistema");
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
            }
            catch (NumberFormatException e) {
                System.out.print("Insira uma opção válida: ");
            }
        }
    }

    public boolean listaPersonagem(){
        if(personagemList.isEmpty()){
            System.out.println("Lista de Personagens vazia!");
            return true;
        }
        else{
            System.out.println("Lista de Personagens:");
            personagemList.forEach(personagem -> System.out.println(personagem));
            return false;
        }
    }

    public boolean idExistente(int valor){
        for(Personagem personagem: this.personagemList){
            if(personagem.getId() == valor){
                return true;
            }
        }
        return false;
    }

    public String menuRaca(){
        System.out.println("Raças Disponíveis: ");
        for(int i = 0; i < Raca.values().length; i++){
            System.out.println(i + ": " + Raca.values()[i]);
        }
        System.out.println("Escolha um número: ");
        while(true){
            try{
                aux = Integer.parseInt(scanner.nextLine());
                while (aux < 0 || aux >= Raca.values().length){
                    System.out.println("Escolha um número válido: ");
                    aux = Integer.parseInt(scanner.nextLine());
                }
                break;
            }
            catch (NumberFormatException e) {
                    System.out.println("Escolha um número válido: ");
            }
        }
        return Raca.values()[aux].toString();
    }

    public String menuProfissao(){
        System.out.println("Profissões Disponíveis: ");
        for(int i = 0; i < Profissoes.values().length; i++){
            System.out.println(i + ": " + Profissoes.values()[i]);
        }
        System.out.println("Escolha um número: ");
        while (true){
            try {
                aux = Integer.parseInt(scanner.nextLine());
                while (aux < 0 || aux >= Profissoes.values().length) {
                    System.out.println("Escolha um número válido: ");
                    aux = Integer.parseInt(scanner.nextLine());
                }
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Escolha um número válido: ");
            }
        }
        return Profissoes.values()[aux].toString();
    }

    public int valorAtributo(String atributo){
        System.out.println("Informe seu valor de " + atributo + ": ");
        while(true){
            try {
                auxAtributos = Integer.parseInt(scanner.nextLine());
                while (auxAtributos < 0) {
                    System.out.println("Informe um valor válido de " + atributo + ": ");
                    auxAtributos = Integer.parseInt(scanner.nextLine());
                }
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Informe um valor válido de " + atributo + ": ");
            }
        }
        return auxAtributos;
    }
}

