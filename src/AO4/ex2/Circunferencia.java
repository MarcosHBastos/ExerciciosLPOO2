/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO4.ex2;

/**
 *
 * @author marcos
 */
public class Circunferencia implements Superficie {

    private double raio;
    
    public Circunferencia(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
       return (Math.pow(this.raio, 2) * Math.PI);
    }
    
    @Override
    public String toString() {
        return String.valueOf(area());
    }
    
}
