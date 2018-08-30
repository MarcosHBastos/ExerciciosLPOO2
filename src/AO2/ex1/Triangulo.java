/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO2.ex1;

/**
 *
 * @author Marcos
 */
public class Triangulo extends Forma {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) throws Exception {
        if (base >= 0 && altura >= 0) {
            this.base = base;
            this.altura = altura;
        } else {
            throw new RuntimeException("Não deve haver parâmetro negativo!!");
        }
    }
    
    @Override
    public double getArea() {
        return ((this.base * this.altura) / 2);
    }

}
