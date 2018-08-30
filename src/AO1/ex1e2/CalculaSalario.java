/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO1.ex1e2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class CalculaSalario {

    public static double calculaSalarioBruto(double salHora, double horasTrabalhadas) {
        return salHora * horasTrabalhadas;
    }

    public static double calculaSalarioLiquido(double salarioBruto, double descontoINSS) {
        double valorDescontado = (salarioBruto * descontoINSS) / 100;
        return salarioBruto - valorDescontado;
    }

    public static String imprimeDadosEmpregado(double salHora, double horasTrabalhadas, double descontoINSS) throws Exception {
        if (salHora < 0 || horasTrabalhadas < 0 || descontoINSS < 0) {
            throw new Exception("Os parâmetros informados não devem ser negativos!");
        } else {
            return ("\nExtrato de salário\n\n"
                    + "Valor Hora: R$ " + salHora
                    + "\n\nHoras Trabalhadas: " + horasTrabalhadas + "horas\n\n"
                    + "Salário Bruto: R$ " + calculaSalarioBruto(salHora, horasTrabalhadas)
                    + "\n\nSalário Líquido: R$ " + calculaSalarioLiquido((calculaSalarioBruto(salHora, horasTrabalhadas)), descontoINSS));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ok;
        double salHora, horasTrabalhadas, descontoINSS;

        do {
            try {
                ok = true;
                System.out.print("Informe os dados do empregado: \nValor recebido por hora: ");
                salHora = sc.nextDouble();
                sc.nextLine();
                System.out.print("Quantidade de horas trabalhadas: ");
                horasTrabalhadas = sc.nextDouble();
                sc.nextLine();
                System.out.print("Valor do desconto do INSS: ");
                descontoINSS = sc.nextDouble();
                sc.nextLine();
                imprimeDadosEmpregado(salHora, horasTrabalhadas, descontoINSS);
            } catch (InputMismatchException ex) {
                System.out.println("Valor informado inválido!");
                ok = false;
            } catch (Exception ex) {
                System.out.println(ex);
                ok = false;
            }
        } while (!ok);

    }

}
