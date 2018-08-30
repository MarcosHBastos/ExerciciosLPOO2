/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO1;

import AO1.ex1e2.CalculaArea;
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
public class Tarefa1ex1IT {

    public Tarefa1ex1IT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculaAreaRetangulo method, of class Tarefa1ex1.
     */
    @Test
    public void testCalculaAreaRetangulo() {
        System.out.println("calculaAreaRetangulo");
        double lado1 = 2.0;
        double lado2 = 4.0;
        double expResult = 8.0;
        double result = CalculaArea.calculaAreaRetangulo(lado1, lado2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testaCalculaAreaRetanguloLadoNegativo() {
        double lado1 = -2;
        double lado2 = -4;
        try {
            CalculaArea.calculaAreaRetangulo(lado1, lado2);
            fail("Devia ter lançado exceção");
        } catch (RuntimeException ex) {
            assertEquals("Os parâmetros não podem ser negativos!", ex);
        }
    }

    /**
     * Test of calculaAreaCircunferencia method, of class Tarefa1ex1.
     */
    @Test
    public void testCalculaAreaCircunferencia() {
        System.out.println("calculaAreaCircunferencia");
        double raio = 1.0;
        double expResult = Math.PI;
        double result = CalculaArea.calculaAreaCircunferencia(raio);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculaAreaTriangulo method, of class Tarefa1ex1.
     */
    @Test
    public void testCalculaAreaTriangulo() {
        System.out.println("calculaAreaTriangulo");
        double base = 5.5;
        double altura = 4;
        double expResult = 11.0;
        double result = CalculaArea.calculaAreaTriangulo(base, altura);
        assertEquals(expResult, result, 0.0);
    }

}
