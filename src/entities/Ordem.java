package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ordem {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private Status ordemStatus;
    private Cliente cliente;

    private List<ItemPedido> itens = new ArrayList<>();
    public Ordem() {
    }

    public Ordem(Date momento, Status ordemStatus, Cliente cliente) {
        this.momento = momento;
        this.ordemStatus = ordemStatus;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Status getOrdemStatus() {
        return ordemStatus;
    }

    public void setOrdemStatus(Status ordemStatus) {
        this.ordemStatus = ordemStatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(ItemPedido item) {
        itens.add(item);
    }

    public void removeItem(ItemPedido item) {
        itens.remove(item);
    }

    public Double total() {
        double soma = 0.0;
        for (ItemPedido item : itens) {
             soma += item.subtotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data Pedido: ");
        sb.append(sdf.format(momento)).append("\n");
        sb.append("Status do Pedido ");
        sb.append(ordemStatus).append("\n");
        sb.append(cliente).append("\n");
        sb.append("Itens do Pedido: \n");
        for (ItemPedido item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Preco total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }


}
