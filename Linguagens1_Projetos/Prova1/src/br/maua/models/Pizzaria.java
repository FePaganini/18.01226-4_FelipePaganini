package br.maua.models;
import br.maua.enums.EstadoPedido;
import br.maua.enums.FormaPagamento;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pizzaria {
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Usuario usuario = new Usuario("Michelangelo","tartarugalaranja@hotmail.com","123456");
    Scanner scan = new Scanner(System.in);
    int opcao = 1;
    String confirmarSenha;
    int pagamento;

    public void rodar(){
        while (opcao != 0) {
            menu();
            acao();
        }
    }

    public void menu(){
        System.out.println("--- Pizzaria o Rato que Ri ---");
        System.out.println("1 - Adicionar pedido");
        System.out.println("2 - Quadro de pedidos");
        System.out.println("3 - Alterar pedidos");
        System.out.println("0 - Fechar sistema");
        System.out.print("Escolha a opção: ");
    }
    public void acao(){
        opcao = Integer.parseInt(scan.nextLine());
        switch (opcao){
            case 1:
                System.out.print("Confirme sua senha: ");
                confirmarSenha = scan.nextLine();
                if(usuario.autentificacao(confirmarSenha)){
                    menuPagamento();
                    pagamento = Integer.parseInt(scan.nextLine());
                    String descricao = scan.nextLine();
                    String valor = scan.nextLine();
                    pedidos.add(new Pedido(geraId(),geraPagamento(pagamento),descricao,valor,EstadoPedido.values()[0]));
                }
                break;
            case 2:
                pedidos.forEach(Pedido ->{

                });
                break;
            case 3:
                System.out.print("Confirme sua senha: ");
                confirmarSenha = scan.nextLine();
                if(usuario.autentificacao(confirmarSenha)){

                }
        }
    }

    private String geraId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++){
           idGerado += random.nextInt(10);
        }
        return idGerado;
    }

    public void menuPagamento(){
        System.out.println("Insira a opção de pagamento:");
        System.out.println("1 - " + FormaPagamento.values()[0]);
        System.out.println("2 - " + FormaPagamento.values()[1]);
        System.out.println("3 - " + FormaPagamento.values()[2]);
        System.out.println("4 - " + FormaPagamento.values()[3]);
        System.out.println("5 - " + FormaPagamento.values()[4]);
    }

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
    
}
