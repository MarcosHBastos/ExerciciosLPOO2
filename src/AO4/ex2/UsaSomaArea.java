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
public class UsaSomaArea {

    public static void main(String[] args) {
        Quadrado quad[] = {new Quadrado(2.0), new Quadrado(5.0)};
        Circunferencia circ[] = {new Circunferencia(3.0), new Circunferencia(2.0)};
        Superficie superf[] = new Superficie[quad.length + circ.length];
        superf[0] = quad[0];
        superf[1] = quad[1];
        superf[2] = circ[0];
        superf[3] = circ[1];
        SomaArea soma = new SomaArea();
        System.out.println("Area dos quadradados = " + soma.calculaArea(quad));
        System.out.println("Area das circunferencias = "
                + soma.calculaArea(circ));
        System.out.println("Soma de todas as áreas = "
                + soma.calculaArea(superf));
    }
}
