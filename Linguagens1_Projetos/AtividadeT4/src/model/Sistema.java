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
    private int auxiliar;

    public void rodar(){
        while(opcao != 0){
            personagemList = personagemDAO.getAll();
            escolha();
            switch (opcao){
                case 1:
                    String nome, raca, profissao;
                    int mana, atk, atkMag, def, defMag, velocidade, destreza, experiencia, nivel;
                    System.out.println("Informe seu Nome: ");
                    nome = scanner.next();
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
                    listaPersonagem();
                    auxiliar = Integer.parseInt(scanner.nextLine());
                    if (idExistente(auxiliar)){
                        System.out.println("Informe seu Nome: ");
                        nome = scanner.next();
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
                        Personagem atualizado = new Personagem(auxiliar,nome,raca,profissao,mana,atk,atkMag,
                                def,defMag,velocidade,destreza,experiencia,nivel);
                        personagemDAO.update(atualizado);
                    }
                    else{
                        System.out.println("Não há Personagem com tal Id!");
                    }
                    break;
                case 3:
                    listaPersonagem();
                    break;
                case 4:
                    listaPersonagem();
                    auxiliar = Integer.parseInt(scanner.nextLine());
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

    public boolean idExistente(int valor){
        for(Personagem personagem: this.personagemList){
            if(personagem.getId() == valor){
                return true;
            }
        }
        return false;
    }

    public String menuRaca(){
        int aux = 0;
        System.out.println("Raças Disponíveis: ");
        for(int i = 0; i < Raca.values().length; i++){
            System.out.println(i + ": " + Raca.values()[i]);
        }
        System.out.println("Escolha um número: ");
        while (true){
            while (aux < 0 && aux > Raca.values().length) {
                try {
                    aux = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    System.out.println("Escolha um número válido: ");
                }
            }
            break;
        }
        return Raca.values()[aux].toString();
    }

    public String menuProfissao(){
        int aux = 0;
        System.out.println("Profissões Disponíveis: ");
        for(int i = 0; i < Profissoes.values().length; i++){
            System.out.println(i + ": " + Profissoes.values()[i]);
        }
        System.out.println("Escolha um número: ");
        while (true){
            while (aux < 0 && aux > Profissoes.values().length) {
                try {
                    aux = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    System.out.println("Escolha um número válido: ");
                }
            }
            break;
        }
        return Profissoes.values()[aux].toString();
    }

    public int valorAtributo(String atributo){
        int aux = -1;
        while(true){
            while(aux<0){
                try{
                    System.out.println("Informe seu valor de "+ atributo + ": ");
                    aux = Integer.parseInt(scanner.next());
                }
                catch (NumberFormatException e){
                    System.out.println("Informe seu valor de "+ atributo + ": ");
                }
            }
            break;
        }
        return aux;
    }
}

