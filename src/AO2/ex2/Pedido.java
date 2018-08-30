/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO2.ex2;

import java.text.DecimalFormat;
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
        } else if ((this.getTotal() + (item.getPreco() * item.getQuantidade())) > this.totalPermitido) {
            throw new Exception("Item de Pedido não incluído. Valor do pedido excedido");
        } else {
            int index = 0;
            for (ItemPedido i : this.listaPedido) {
                if (item.getNome().equals(i.getNome())) {
                    index = this.listaPedido.indexOf(i);
                    this.listaPedido.get(index).setQuantidade((this.listaPedido.get(index).getQuantidade()) + item.getQuantidade());
                    return;
                }
            }
            this.listaPedido.add(item);
        }
    }

    public void retiraItem(String nomeItem) throws Exception {
        boolean removeu = false;
        for (ItemPedido i : this.listaPedido) {
            if (nomeItem.equals(i.getNome())) {
                this.listaPedido.remove(i);
                return;
            }
        }
        throw new Exception("Item não encontrado no pedido");
    }

    public double getTotal() {
        double total = 0;
        for (ItemPedido i : this.listaPedido) {
            total += i.getPreco() * i.getQuantidade();
        }
        return total;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String comeco = ("-------------------------------------------"
                + "\nNome do Cliente: " + this.getCliente()
                + "\nTotal do Pedido: R$" + df.format(this.getTotal())
                + "\nItem\t\t|Preço\t\t|Quantidade\n");
        String meio = "";
        for (ItemPedido i : this.listaPedido) {
            meio += (i.getNome() + "\t\t|R$" + df.format(i.getPreco()) + "\t\t|" + i.getQuantidade() + "\n");
        }
        String fim = "-------------------------------------------\n\n";
        return (comeco + meio + fim);
    }
}
