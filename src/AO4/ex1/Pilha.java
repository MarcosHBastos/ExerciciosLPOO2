/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO4.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Pilha<T> {

    private List<T> valor = new ArrayList<T>();
    

    public Pilha() {
    }

    public void empilha(T valor) {
        if (valor == null) {
            throw new RuntimeException("valor == null");
        }
        this.valor.add(valor);
    }

    public T desempilha() {
        if (!this.valor.isEmpty()) {
            T aux = this.valor.get(this.valor.size() - 1);
            this.valor.remove(this.valor.size() - 1);
            return aux;
        }
        throw new RuntimeException("Não há o que desempilhar, pilha vazia!");
    }

    @Override
    public String toString() {
        if (this.valor.isEmpty()) {
            return "Pilha vazia!";
        }
        String str = " ]";
        for (T generic : this.valor) {
            str = ", " + generic.toString() + str;
        }
        str = "[" + str.replaceFirst(",", "");
        return str;
    }
}
