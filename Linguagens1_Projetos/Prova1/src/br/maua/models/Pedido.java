package br.maua.models;
import br.maua.enums.EstadoPedido;
import br.maua.enums.FormaPagamento;
import br.maua.interfaces.QuadroPedidos;

public class Pedido implements QuadroPedidos {
    public String id;
    private Enum<FormaPagamento> pagamento;
    private String descricao;
    private String valor;
    private Enum<EstadoPedido> estado;

    public Pedido(String id, Enum<FormaPagamento> pagamento, String descricao, String valor, Enum<EstadoPedido> estado) {
        this.id = id;
        this.pagamento = pagamento;
        this.descricao = descricao;
        this.valor = valor;
        this.estado = estado;
    }

    @Override
    public void mostrarPedidos() {
        System.out.println("Id: "+ id);
        System.out.println("Forma de pagamento: "+ pagamento);
        System.out.println("Descrição: "+ descricao);
        System.out.println("Valor: "+ valor + " reais");
        System.out.println("Estado do pedido: "+ estado);
    }
}
