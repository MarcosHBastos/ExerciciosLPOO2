/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO1;

import AO1.ex1e2.CalculaSalario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class Tarefa1ex2IT {

    public Tarefa1ex2IT() {
    }

    /**
     * Test of calculaSalarioBruto method, of class Tarefa1ex2.
     */
    @Test
    public void testCalculaSalarioBruto() {
        System.out.println("calculaSalarioBruto");
        double salHora = 8.0;
        double horasTrabalhadas = 50.0;
        double expResult = 400.0;
        double result = CalculaSalario.calculaSalarioBruto(salHora, horasTrabalhadas);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculaSalarioLiquido method, of class Tarefa1ex2.
     */
    @Test
    public void testCalculaSalarioLiquido() {
        System.out.println("calculaSalarioLiquido");
        double salarioBruto = 800.0;
        double descontoINSS = 6.0;
        double expResult = 752.0;
        double result = CalculaSalario.calculaSalarioLiquido(salarioBruto, descontoINSS);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of imprimeDadosEmpregado method, of class Tarefa1ex2.
     */
    @Test
    public void testImprimeDadosEmpregado() throws Exception {
        System.out.println("imprimeDadosEmpregado");
        double salHora = 0.0;
        double horasTrabalhadas = 0.0;
        double descontoINSS = 0.0;
        String expResult = "";
        String result = CalculaSalario.imprimeDadosEmpregado(salHora, horasTrabalhadas, descontoINSS);
        assertNotEquals(expResult, result);
    }
}
