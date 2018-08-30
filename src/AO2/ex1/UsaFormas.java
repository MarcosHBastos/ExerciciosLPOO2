/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO2.ex1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class UsaFormas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numFormas = 0, opt = 0;
        double parametro1, parametro2;

        System.out.print("Informe o número de formas que deseja criar: ");
        numFormas = sc.nextInt();
        sc.nextLine();

        Forma[] formas = new Forma[numFormas];

        for (int i = 0; i < numFormas; i++) {
            boolean quit = false;

            System.out.println("\nInforme o tipo da forma " + (i + 1) + ": \n"
                    + "1 - Circunferência\n"
                    + "2 - Retângulo\n"
                    + "3 - Triângulo\n"
                    + "4 - Sair");
            switch (sc.nextLine()) {

                case "1":
                    try {
                        System.out.print("Informe o valor do raio da circunferência: ");
                        parametro1 = sc.nextDouble();
                        sc.nextLine();

                        formas[i] = new Circunferencia(parametro1);
                    } catch (InputMismatchException ex) {
                        System.out.println("Valor informado inválido!");
                        sc.nextLine();
                        i--;
                    } catch (Exception ex) {
                        System.out.println(ex);
                        i--;
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Informe o valor do 1º lado do retângulo: ");
                        parametro1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Informe o valor do 2º lado do retângulo: ");
                        parametro2 = sc.nextDouble();
                        sc.nextLine();

                        formas[i] = new Retangulo(parametro1, parametro2);
                    } catch (InputMismatchException ex) {
                        System.out.println("Valor informado inválido!");
                        sc.nextLine();
                        i--;
                    } catch (Exception ex) {
                        System.out.println(ex);
                        i--;
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Informe o valor da base do triângulo: ");
                        parametro1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Informe o valor da altura do triângulo: ");
                        parametro2 = sc.nextDouble();
                        sc.nextLine();

                        formas[i] = new Triangulo(parametro1, parametro2);
                    } catch (InputMismatchException ex) {
                        System.out.println("Valor informado inválido!");
                        sc.nextLine();
                        i--;
                    } catch (Exception ex) {
                        System.out.println(ex);
                        i--;
                    }
                    break;

                case "4":
                    numFormas = i;
                    quit = true;
                    break;

                default:
                    System.out.println("Informe uma opção válida!");
                    i--;
                    break;
            }
            if (quit) {
                break;
            }
        }

        if (numFormas == 0) {
            System.out.println("\nNenhuma forma!!!");
        } else {
            for (int i = 0; i < numFormas; i++) {
                System.out.print("\nÁrea da forma " + (i + 1) + "(" + (formas[i].getClass().getSimpleName()).toLowerCase() + "): " + formas[i].getArea());
            }
        }
        System.out.println("\n\n");
    }

}
