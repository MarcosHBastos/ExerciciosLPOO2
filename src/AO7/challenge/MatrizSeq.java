/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO7.challenge;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author marcos
 */
public class MatrizSeq {

    public static void main(String[] args) {

        int n = 1700;
        int[][] a = Utils.matrixMaker(n);
        int[][] b = Utils.matrixMaker(n);

        LocalTime antes = LocalTime.now();

        Utils.matrixMultiplier(a, b, 1, 0);

        LocalTime depois = LocalTime.now();
        Duration duration = Duration.between(antes, depois);
        long min = duration.toMinutes();
        long sec = duration.getSeconds() - (min * 60);
        System.out.println("Tempo gasto: " + min + "min " + sec + "secs");
    }
}
