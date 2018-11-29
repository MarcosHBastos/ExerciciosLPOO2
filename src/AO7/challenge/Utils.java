/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO7.challenge;

import java.util.Random;

/**
 *
 * @author marcos
 */
public class Utils {

    public static int[][] matrixMaker(int d) {
        int[][] m = new int[d][d];
        Random random = new Random();

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                m[i][j] = random.nextInt(10);
            }
        }
        return m;
    }

    public static String matrixPrinter(int[][] a) {
        String m = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m += a[i][j] + "\t";
            }
            m += "\n";
        }
        return m;
    }

    public static int[][] matrixMultiplier(int[][] a, int b[][], int cuts, int sliceNumber) {
        int sliceSize = (int) Math.floor((double) a.length / cuts);
        int index = sliceNumber * sliceSize;
        int indexEnd;
        if (sliceNumber != cuts - 1) {
            indexEnd = index + sliceSize;
        } else {
            indexEnd = a.length;
            sliceSize = indexEnd - index;
        }
        int[][] result = new int[sliceSize][a.length];

        //System.out.println("Thread número: " + (sliceNumber+1) + " || Tamanho: " + sliceSize);
        for (int i = 0; index < indexEnd; i++, index++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    result[i][j] += (a[index][k] * b[k][j]);
                }
            }
        }
        //System.out.println("Matriz resultante:\n" + Utils.matrixPrinter(result));
        return result;
    }
}
