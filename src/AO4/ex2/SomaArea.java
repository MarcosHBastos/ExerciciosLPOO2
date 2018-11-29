/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO4.ex2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */

public class SomaArea<T> {//? extends Superficie> {

    public SomaArea() {
    }

    public double calculaArea(T[] generic) {
        double areaTotal = 0;
        for (T item : generic) {
            Superficie s = (Superficie) item;
            areaTotal += s.area();
        }
        return areaTotal;
    }
}
