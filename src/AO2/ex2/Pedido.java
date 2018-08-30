/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao2ex2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Pedido {

    private String nomeCli;
    private List<ItemPedido> listaPedido = new ArrayList<ItemPedido>();
    private double totalPermitido;

    public Pedido(String nomeCli, double totalPermitido) {
        this.nomeCli = nomeCli;
        this.totalPermitido = totalPermitido;
    }

    public String getCliente() {
        return this.nomeCli;
    }

    public List<ItemPedido> getItens() {
        return this.listaPedido;
    }

    public void acrescentaItem(ItemPedido item) throws Exception {
        if (item == null) {
            throw new Exception("Especifique um item válido!");
        } else if (this.totalPermitido == 0) {
            throw new Exception("Cliente não tem nenhum crédito");
        } else if ((item.getPreco() * item.getQuantidade()) > this.totalPermitido) {
            throw new Exception("Item de Pedido não incluído. Valor do pedido excedido");
        } else if (this.listaPedido.contains(item)) {
            int index = this.listaPedido.indexOf(item);
            this.listaPedido.get(index).setQuantidade((this.listaPedido.get(index).getQuantidade())+1);
        } else {
            this.listaPedido.add(item);
        }
    }
    
    public void retiraItem(String nomeItem) throws Exception {
        boolean removeu = false;
        for (ItemPedido i : this.listaPedido) {
            if(nomeItem.equals(i.getNome())) {
                this.listaPedido.remove(i);
                return;
            }
        }
        throw new Exception("Item não encontrado no pedido");
    }
    
    public double getTotal() {
        double total = 0;
        for (ItemPedido i : this.listaPedido) {
            total += i.getPreco();
        }
        return total;
    }
    
    public String toString() {
        String comeco = ("-----------------------"
                + "\nNome do Cliente: "+ this.getCliente()
                + "\nTotal do Pedido: "+ this.getTotal()
                + "\nItem\t\t|Preço\n");
        String meio = "";
        for (ItemPedido i : this.listaPedido) {
            meio += (i.getNome()+"\t\t|R$"+i.getPreco()+"\n");
        }
        String fim = "-----------------------\n\n";
        return (comeco+meio+fim);
    }
}
