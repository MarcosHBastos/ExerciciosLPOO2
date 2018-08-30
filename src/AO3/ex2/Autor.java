/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO3.ex2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Autor {

    private String nome;
    private List<Livro> livros = new ArrayList();

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros.addAll(livros);
    }
}
