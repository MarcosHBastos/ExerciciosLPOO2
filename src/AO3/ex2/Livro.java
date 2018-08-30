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
public class Livro {
     private String titulo;
    private List<Autor> autores = new ArrayList();

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return titulo;
    }

    public void setNome(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores.addAll(autores);
    }
}
