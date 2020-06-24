package br.maua.models;
import br.maua.enums.EstadoPedido;
import br.maua.enums.FormaPagamento;
import br.maua.interfaces.QuadroPedidos;

/**
 * Classe concreta que representa o pedido realizado, ela implementa a interface QuadroPedidos
 * @author Felipe Dos Santos Paganini - felipespaganini@hotmail.com
 * @since 22/06/2020
 * @version 1.0
 */
public class Pedido implements QuadroPedidos {
    private String id;
    private Enum<FormaPagamento> pagamento;
    private String descricao;
    private String valor;
    private Enum<EstadoPedido> estado;

    /**
     * Construtor da classe Pedido
     * @param id String: Id do pedido
     * @param pagamento Enum: Forma de pagamento do pedido
     * @param descricao String: Descrição do pedido
     * @param valor String: Valor do pedido (em escrito ou em número)
     * @param estado Enum: Estado do pedido
     */
    public Pedido(String id, Enum<FormaPagamento> pagamento, String descricao, String valor, Enum<EstadoPedido> estado) {
        this.id = id;
        this.pagamento = pagamento;
        this.descricao = descricao;
        this.valor = valor;
        this.estado = estado;
    }

    /**
     * Método da Interface QuadroPedidos que printa as váriaveis do construtor da classe Pedido
     */
    @Override
    public void mostrarPedidos() {
        System.out.println("Id: "+ id);
        System.out.println("Forma de pagamento: "+ pagamento);
        System.out.println("Descrição: "+ descricao);
        System.out.println("Valor: "+ valor + " reais");
        System.out.println("Estado do pedido: "+ estado);
    }

    /**
     * Método que retorna o Id do pedido
     * @return retorna o id
     */
    public String getId() {
        return id;
    }

    /**
     * Método que realizará a troca do estado de um pedido para outro estado
     * @param estado estado desejado pelo usuário para determinado pedido
     */
    public void setEstado(Enum<EstadoPedido> estado) {
        this.estado = estado;
    }
}
