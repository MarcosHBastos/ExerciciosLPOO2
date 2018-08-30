package AO1.ex1e2;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcos
 */
public class CalculaArea {

    public static double calculaAreaRetangulo(double lado1, double lado2) throws RuntimeException {
        if (lado1 < 0 || lado2 < 0) {
            throw new RuntimeException("Os parâmetros não podem ser negativos!");
        }
        return lado1 * lado2;
    }

    public static double calculaAreaCircunferencia(double raio) throws RuntimeException {
        if (raio < 0) {
            throw new RuntimeException("O parâmetro não pode ser negativos!");
        }
        return (Math.pow(raio, 2) * Math.PI);
    }

    public static double calculaAreaTriangulo(double base, double altura) throws RuntimeException {
        if (base < 0 || altura < 0) {
            throw new RuntimeException("Os parâmetros não podem ser negativos!");
        }
        return (base * altura) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha o tipo de objeto que quer calcular a área:\n"
                + "1 - Retangulo\n"
                + "2 - Circunferencia\n"
                + "3 - Triangulo");
        int opt = sc.nextInt();
        sc.nextLine();
        do {
            switch (opt) {
                case 1:
                    System.out.print("Informe o valor do lado 1: ");
                    int lado1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Informe o valor do lado 2: ");
                    int lado2 = sc.nextInt();
                    sc.nextLine();
                    try {
                        System.out.println("O valor da área de um retângulo com os lados informados é de: "
                                + calculaAreaRetangulo(lado1, lado2));
                    } catch (RuntimeException ex) {
                        System.out.println(ex);
                    }
                    break;
                case 2:
                    System.out.print("Informe o valor do raio: ");
                    int raio = sc.nextInt();
                    sc.nextLine();
                    try {
                        System.out.println("O valor da área de uma circunferência com o raio informado é de: "
                                + calculaAreaCircunferencia(raio));
                    } catch (RuntimeException ex) {
                        System.out.println(ex);
                    }
                    break;
                case 3:
                    System.out.print("Informe o valor do lado 1: ");
                    int base = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Informe o valor do lado 2: ");
                    int altura = sc.nextInt();
                    sc.nextLine();
                    try {
                        System.out.println("O valor da área de um triângulo com os valores informados é de: "
                                + calculaAreaRetangulo(base, altura));
                    } catch (RuntimeException ex) {
                        System.out.println(ex);
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opt > 0 && opt < 4);
    }
}
