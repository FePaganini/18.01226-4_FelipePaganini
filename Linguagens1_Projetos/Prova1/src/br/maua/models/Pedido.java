package br.maua.models;
import br.maua.enums.EstadoPedido;
import br.maua.enums.FormaPagamento;

public class Pedido {
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

}
