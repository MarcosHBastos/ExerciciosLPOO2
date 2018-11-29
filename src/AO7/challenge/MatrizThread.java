/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO7.challenge;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class MatrizThread {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 2500;
        int n = 0;
        System.out.print("Informe o número de Threads: ");
        n = sc.nextInt();
        int[][] a = Utils.matrixMaker(t);
        int[][] b = Utils.matrixMaker(t);
        Split[] s = new Split[n];

        for (int i = 0; i < n; i++) {
            s[i] = new Split(a, b, n, i);
        }
        
        LocalTime antes = LocalTime.now();
        for (int i = 0; i < n; i++) {
            s[i].start();
        }
        
        for (int i=0; i<n ; i++) {
            try {
                s[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(MatrizThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        LocalTime depois = LocalTime.now();
        Duration duration = Duration.between(antes, depois);
        long min = duration.toMinutes();
        long sec = duration.getSeconds() - (min * 60);
        System.out.println("Tempo gasto: " + min + "min " + sec + "secs");
    }
}

class Split extends Thread {
    private int[][] m1;
    private int[][] m2;
    private int cuts;
    private int number;
    
    public Split(int[][] m1, int[][] m2, int cuts, int number) {
        this.m1 = m1;
        this.m2 = m2;
        this.cuts = cuts;
        this.number = number;
    }
    
     @Override
    public synchronized void run() {
        Utils.matrixMultiplier(m1, m2, cuts, number);
    }
}




