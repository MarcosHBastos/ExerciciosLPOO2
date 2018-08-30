/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteAO2;

import AO2.ex1.Circunferencia;
import AO2.ex1.Triangulo;
import AO2.ex1.Retangulo;
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
public class TesteAO2e2 {

    public void testaFormas() {
    }

    @Test
    public void testaCircunferenciaRaioNegativo() {
        try {
            Circunferencia c = new Circunferencia(-1);
            fail("Deveria lançar exceção");
        } catch (Exception ex) {
            assertEquals("O raio não pode ser negativo!!", ex.getMessage());
        }
    }

    @Test
    public void testaAreaCircunferencia() {
        try {
            Circunferencia c = new Circunferencia(1);
            assertEquals(Math.PI, c.getArea(), 0);
        } catch (Exception ex) {
        }

    }

    @Test
    public void testaRetanguloLado1Negativo() {
        try {
            Retangulo r = new Retangulo(-1, 4);
            fail("Deveria lançar exceção");
        } catch (Exception ex) {
            assertEquals("Não deve haver lado negativo!!", ex.getMessage());
        }
    }

    @Test
    public void testaRetanguloLado2Negativo() {
        try {
            Retangulo r = new Retangulo(1, -4);
            fail("Deveria lançar exceção");
        } catch (Exception ex) {
            assertEquals("Não deve haver lado negativo!!", ex.getMessage());
        }
    }

    @Test
    public void testaAreaRetangulo() {
        try {
            Retangulo r = new Retangulo(2, 5);
            assertEquals(10, r.getArea(), 0);
        } catch (Exception ex) {
        }
    }

    @Test
    public void testaPerimetroRetangulo() {
        try {
            Retangulo r = new Retangulo(2, 4);
            assertEquals(12, r.getPerimetro(), 0);
        } catch (Exception ex) {
        }
    }

    @Test
    public void testaTrianguloBaseNegativa() {
        try {
            Triangulo t = new Triangulo(-2, 5);
            fail("Deveria lançar exceção");
        } catch (Exception ex) {
            assertEquals("Não deve haver parâmetro negativo!!", ex.getMessage());
        }
    }

    @Test
    public void testaTrianguloAlturaNegativa() {
        try {
            Triangulo t = new Triangulo(2, -5);
            fail("Deveria lançar exceção");
        } catch (Exception ex) {
            assertEquals("Não deve haver parâmetro negativo!!", ex.getMessage());
        }
    }

    @Test
    public void testaAreaTriangulo() {
        try {
            Triangulo t = new Triangulo(2, 5);
            assertEquals(5, t.getArea(), 0);
        } catch (Exception ex) {
        }

    }
}
