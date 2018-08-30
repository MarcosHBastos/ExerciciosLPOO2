/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO2.ex2;

/**
 *
 * @author marcos
 */
public class ItemPedido {

    private String nome;
    private double preco;
    private int quantidade;

    public ItemPedido(String nome, double preco, int quantidade) throws Exception {
        if (preco < 0) {
            throw new Exception("O preço não deve ser negativo!");
        } else if (nome == null) {
            throw new Exception("Informe um nome para o produto!");
        } else if (quantidade <= 0) {
            throw new Exception("Quantidade mínima: 1");
        } else {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null) {
            throw new Exception("Informe um nome para o produto!");
        } else {
            this.nome = nome;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws Exception {
        if (preco < 0) {
            throw new Exception("O preço não deve ser negativo!");
        } else {
            this.preco = preco;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception {
        if (quantidade <= 0) {
            throw new Exception("Quantidade mínima: 1");
        } else {
            this.quantidade = quantidade;
        }
    }
}
