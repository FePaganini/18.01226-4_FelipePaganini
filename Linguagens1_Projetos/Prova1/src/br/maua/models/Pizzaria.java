package br.maua.models;
import br.maua.enums.EstadoPedido;
import br.maua.enums.FormaPagamento;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe concreta que representa o sistema da pizzaria, nela vemos as ações que podemos tomar
 */
public class Pizzaria {
    /**
     * @param pedidos É um ArrayList da classe Pedido
     * @param usuario É uma instância do Usuario com nome, email e senha definidos
     * @param scan É uma instância de Scanner, usaremos ela para recebermos informações do usuário que utiliza o sistema
     * @param opcao Int: será usado para tomar ações no sistema
     * @param confirmarSenha É a String que será usada para confirmar a senha do usuário
     * @param pagamento Int: será usado para escolher o tipo de pagamento do pedido
     * @param estado Int: será usado para escolher o estado do pedido
     */
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Usuario usuario = new Usuario("Michelangelo","tartarugalaranja@hotmail.com","123456");
    Scanner scan = new Scanner(System.in);
    int opcao = 1;
    String confirmarSenha;
    int pagamento,estado;

    /**
     * Método que implementará os métodos menu() e acao() até a variável "opcao" ser igual a 0
     */
    public void rodar(){
        while (opcao != 0) {
            menu();
            acao();
        }
        System.out.println("Finalizando programa!");
    }

    /**
     * Método que printa o menu de ações que você pode tomar
     */
    public void menu(){
        System.out.println("--- Pizzaria o Rato que Ri ---");
        System.out.println("1 - Adicionar pedido");
        System.out.println("2 - Quadro de pedidos");
        System.out.println("3 - Alterar pedidos");
        System.out.println("0 - Fechar sistema");
        System.out.print("Escolha a opção: ");
    }

    /**
     * Método que realizará as ações do sistema, por exemplo: adicionar pedido, mostrar todos os pedidos e alterar
     * o estado do pedido
     * Caso variável "opcao" ser igual a 1, caso a senha esteja correta,será adicionado no Array list "pedidos"
     * um novo pedido. Caso a senha esteja incorreta, o sistema reportará mensagem de erro
     * Caso variável "opcao" ser igual a 2, será mostrado os pedidos que estão no sistema
     * Caso variável "opcao" ser igual a 3, caso a senha esteja correta,será possível alterar o estado do pedido
     * desejada (a partir de seu id). Caso a senha esteja incorreta, o sistema reportará mensagem de erro
     */
    public void acao(){
        opcao = Integer.parseInt(scan.nextLine());
        switch (opcao){
            case 1:
                System.out.print("Confirme sua senha: ");
                confirmarSenha = scan.nextLine();
                if(usuario.autentificacao(confirmarSenha)){
                    menuPagamento();
                    pagamento = Integer.parseInt(scan.nextLine());
                    System.out.print("Descrição do pedido: ");
                    String descricao = scan.nextLine();
                    System.out.print("Valor: ");
                    String valor = scan.nextLine();
                    pedidos.add(new Pedido(geraId(),geraPagamento(pagamento),descricao,valor,EstadoPedido.values()[0]));
                }
                else {
                    System.out.println("Senha incorreta! Não foi possível adicionar pedido!\n");
                }
                break;
            case 2:
                geraQuadroPedidos(pedidos);
                break;
            case 3:
                System.out.print("Confirme sua senha: ");
                confirmarSenha = scan.nextLine();
                if(usuario.autentificacao(confirmarSenha)){
                    geraQuadroPedidos(pedidos);
                    System.out.print("Escolha o Id do pedido que será alterado: ");
                    String escolha = scan.nextLine();
                    int i = 0;
                    while (!escolha.equals(pedidos.get(i).getId())){
                        i+=1;
                    }
                    menuEstado();
                    estado = Integer.parseInt(scan.nextLine());
                    pedidos.get(i).setEstado(geraEstado(estado));
                }
                else {
                    System.out.println("Senha incorreta! Não foi possível adicionar pedido!");
                }
                break;
        }
    }

    /**
     * Método que gera um Id para o pedido
     * @return retorna uma String composta de 3 números (de 0 a 9) aleatórios
     */
    private String geraId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++){
           idGerado += random.nextInt(10);
        }
        return idGerado;
    }

    /**
     * Método que printa as formas de pagamento possíveis para o pedido
     */
    public void menuPagamento(){
        System.out.println("Formas de pagamento:");
        System.out.println("1 - " + FormaPagamento.values()[0]);
        System.out.println("2 - " + FormaPagamento.values()[1]);
        System.out.println("3 - " + FormaPagamento.values()[2]);
        System.out.println("4 - " + FormaPagamento.values()[3]);
        System.out.println("5 - " + FormaPagamento.values()[4]);
        System.out.print("Insira a opção de pagamento: ");
    }

    /**
     * Método que gerará a forma de pagamento para o pedido
     * @param pagamento Int: será usado para escolher o tipo de pagamento do pedido
     * @return retorna o Enum que será utilizado como forma de pagamento
     */
    public Enum geraPagamento(int pagamento){
        if(pagamento == 1){
            return FormaPagamento.values()[0];
        }
        else if(pagamento == 2){
            return FormaPagamento.values()[1];
        }
        else if(pagamento == 3){
            return FormaPagamento.values()[2];
        }
        else if(pagamento == 4){
            return FormaPagamento.values()[3];
        }
        else {
            return FormaPagamento.values()[4];
        }
    }

    /**
     * Método que printará todos os pedidos com as informações do seu construtor
     * @param pedidos É um ArrayList da classe Pedido
     */
    public void geraQuadroPedidos(ArrayList<Pedido> pedidos){
        System.out.println("------------------------------");
        for(int i=0; i< pedidos.size();i++){
            pedidos.get(i).mostrarPedidos();
            System.out.println("------------------------------");
        }
    }
    /**
     * Método que printa os estados possíveis para o pedido
     */
    public void menuEstado(){
        System.out.println("Estados:");
        System.out.println("1 - " + EstadoPedido.values()[0]);
        System.out.println("2 - " + EstadoPedido.values()[1]);
        System.out.println("3 - " + EstadoPedido.values()[2]);
        System.out.println("4 - " + EstadoPedido.values()[3]);
        System.out.println("5 - " + EstadoPedido.values()[4]);
        System.out.print("Insira o estado desejado: ");
    }

    /**
     * Método que gerará o estado que substituirá o estado atual do pedido
     * @param estado Int: será usado para escolher o estado do pedido
     * @return retorna o Enum que será utilizado como estado do pedido
     */
    public Enum geraEstado(int estado){
        if(estado == 1){
            return EstadoPedido.values()[0];
        }
        else if(estado == 2){
            return EstadoPedido.values()[1];
        }
        else if(estado == 3){
            return EstadoPedido.values()[2];
        }
        else if(estado == 4){
            return EstadoPedido.values()[3];
        }
        else {
            return EstadoPedido.values()[4];
        }
    }
}
