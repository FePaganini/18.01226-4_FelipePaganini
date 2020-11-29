package model;

import dao.PersonagemDAO;
import enums.Profissoes;
import enums.Raca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que realizará a interação com o usuário
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com - 18.01226-4
 * @since 29/11/2020
 * @version 1.0
 */
public class Sistema {
    private int opcao = 1;
    Scanner scanner = new Scanner(System.in);
    List<Personagem> personagemList = new ArrayList<>();
    PersonagemDAO personagemDAO = new PersonagemDAO();
    private int auxiliar, aux, auxAtributos;
    private String nome, raca, profissao;
    private int mana, atk, atkMag, def, defMag, velocidade, destreza, experiencia, nivel;

    /**
     * Função que depdendo da opção escolhida pelo usuário realizará diversas ações
     * Caso 0: Fecha o programa
     * Caso 1: Criação de um novo Personagem e este é colocado no DB
     * Caso 2: Mostra a lista de Personagens disponíveis e a partir do Id atualiza o Personagem no DB,
     * caso não tenha Personagem no DB ou não coloque um Id disponível não fará nada
     * Caso 3: Mostra a lista de Personagens disponíveis no DB
     * Caso 4: Mostra a lista de Personagens disponíveis e a partir do Id deleta um Personagem do DB,
     * caso não tenha Personagem no DB ou não coloque um Id disponível não fará nada
     */
    public void rodar(){
        while(opcao != 0){
            personagemList = personagemDAO.getAll();
            menu();
            escolha();
            switch (opcao){
                case 1:
                    dadosPersonagem();
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
                        System.out.println("Não há Personagem com tal Id!\n");
                        break;
                    }
                    if (idExistente(auxiliar)) {
                       dadosPersonagem();
                        Personagem atualizado = new Personagem(auxiliar, nome, raca, profissao, mana, atk, atkMag,
                                def, defMag, velocidade, destreza, experiencia, nivel);
                        personagemDAO.update(atualizado);
                        }
                    else {
                        System.out.println("Não há Personagem com tal Id!\n");
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
                        System.out.println("Não há Personagem com tal Id!\n");
                        break;
                    }
                    if (idExistente(auxiliar)){
                        Personagem deletado = new Personagem(auxiliar);
                        personagemDAO.delete(deletado);
                    }
                    else{
                        System.out.println("Não há Personagem com tal Id!\n");
                    }
                    break;
            }
        }
    }

    /**
     * Função que printará o menue suas opções
     */
    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1- Criar Personagem\n2- Alterar Atributos do Personagem\n" +
                "3- Consulte Todos Os Personagens\n4- Deletar Personagem\n0- Fechar o Sistema");
        System.out.print("Insira sua opção: ");
    }

    /**
     * Função que corrige erros de digitação do usuário para selecionar uma opção do Menu
     */
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

    /**
     * Função que retorna um boolean
     * @return true: caso a lista de personagem está vazia (logo o DB também está vazio) e false: há
     * personagens na lista (logo no DB também) e mostra os personagens para o usuário
     */
    public boolean listaPersonagem(){
        if(personagemList.isEmpty()){
            System.out.println("Lista de Personagens vazia!\n");
            return true;
        }
        else{
            System.out.println("Lista de Personagens:");
            personagemList.forEach(personagem -> System.out.println(personagem));
            return false;
        }
    }

    /**
     * @param valor número inteiro que será o Id procurado na lista de personagens
     * @return true: caso o Id seja encontrado na lista de personagens e false: caso o Id não seja encontrado
     * na lista de personagens
     */
    public boolean idExistente(int valor){
        for(Personagem personagem: this.personagemList){
            if(personagem.getId() == valor){
                return true;
            }
        }
        return false;
    }

    /**
     * Função que mostra todas as Raças disponíveis através do Enum e retorna qual Enum em String foi escolhido
     * pelo usuário
     * @return String que é a Raça escolhida pelo usuário
     */
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

    /**
     * Função que mostra todas as Profissões disponíveis através do Enum e retorna qual Enum em String
     * foi escolhido pelo usuário
     * @return String que é a Profissão escolhida pelo usuário
     */
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

    /**
     * Função que corrige erros de digitação do usuário para selecionar uma opção de valor para atributo do
     * personagem (exemplo: mana, ataque, velocidade e etc)
     * @param atributo String para facilitar na escrita do código
     * @return número inteiro que vai ser acima de 0 e pode ser utilizado para preencher os parâmetros
     * do Personagem
     */
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

    /**
     * Função que recolhe os dados para o objeto Personagem, também criada para não poluir o código
     */
    public void dadosPersonagem(){
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
    }
}

