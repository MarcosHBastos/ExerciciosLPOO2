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
public class Circunferencia extends Forma {

    private double raio;
   
    public Circunferencia (double raio) throws Exception {
        if(raio >=0) {
            this.raio = raio;
        }
        else {
            throw new RuntimeException("O raio não pode ser negativo!!");
        }
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    @Override
    public double getArea() {
        return (Math.PI*(Math.pow(this.raio,2)));
    }

}
