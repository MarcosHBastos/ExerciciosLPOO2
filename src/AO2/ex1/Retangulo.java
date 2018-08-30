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
public class Retangulo extends Forma {

    private double lado1;
    private double lado2;

    public Retangulo(double lado1, double lado2) throws Exception {
        if (lado1 >= 0 && lado2 >= 0) {
            this.lado1 = lado1;
            this.lado2 = lado2;
        } else {
            throw new RuntimeException("Não deve haver lado negativo!!");
        }
    }

    @Override
    public double getArea() {
        return (this.lado1 * this.lado2);
    }

    public double getPerimetro() {
        return ((this.lado1 * 2) + (this.lado2 * 2));
    }

}
