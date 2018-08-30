/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO2.ex2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class SistemaPedidos {

    public static void main(String[] args) {

        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        System.out.println("Selecione uma opção do menu: ");
        do {
            System.out.println("\n1 - Incluir Pedido"
                    + "\n2 - Excluir pedido por nome do cliente"
                    + "\n3 - Listar Pedidos"
                    + "\n4 - Incluir Item de Pedido em Pedido"
                    + "\n5 - Excluir Item de Pedido em Pedido"
                    + "\n6 - Imprimir a lista de Pedidos"
                    + "\n7 - Sair");
            opt = sc.nextInt();
            sc.nextLine();

            boolean achou;
            switch (opt) {
                case 1:
                    System.out.print("Informe o nome do cliente: ");
                    String nomeCli = sc.nextLine();
                    System.out.print("Informe o valor do crédito desse cliente: ");
                    double credito = sc.nextDouble();
                    sc.nextLine();
                    Pedido p = new Pedido(nomeCli, credito);
                    listaPedidos.add(p);
                    System.out.println("Pedido criado\n");
                    break;
                case 2:
                    achou = false;
                    System.out.print("Informe o nome do cliente do pedido a ser removido: ");
                    String nomeCliRemove = sc.nextLine();
                    for (Pedido i : listaPedidos) {
                        if (nomeCliRemove.equals(i.getCliente())) {
                            listaPedidos.remove(i);
                            System.out.println("Pedido removido!\n");
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("Cliente informado não encontrado na lista\n");
                    }
                    break;
                case 3:
                    DecimalFormat df = new DecimalFormat("##,###,##0.00");
                    for(Pedido c : listaPedidos) {
                        System.out.println("Cliente: "+c.getCliente()+"\t-\t Total: R$"+df.format(c.getTotal()));
                    }
                    break;
                case 4:
                    achou = false;
                    System.out.print("Informe o nome do cliente para inserir Item no Pedido: ");
                    String cliInsere = sc.nextLine();
                    int indexInsere = 0;
                    for (Pedido i : listaPedidos) {
                        if (cliInsere.equals(i.getCliente())) {
                            indexInsere = listaPedidos.indexOf(i);
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("Cliente informado não encontrado na lista!\n");
                    } else {
                        try {
                            System.out.print("Características do Item\nNome: ");
                            String nomeItem = sc.nextLine();
                            System.out.print("Preço: ");
                            double precoItem = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Quantidade: ");
                            int qtdeItem = sc.nextInt();
                            sc.nextLine();
                            ItemPedido newItem = new ItemPedido(nomeItem, precoItem, qtdeItem);
                            listaPedidos.get(indexInsere).acrescentaItem(newItem);
                            System.out.println("Item inserido na lista de Itens do cliente " + listaPedidos.get(indexInsere).getCliente());
                        } catch (InputMismatchException ex) {
                            System.out.println("Parâmetros informados inválidos!");
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    break;
                case 5:
                    achou = false;
                    System.out.print("Informe o nome do cliente para remover Item do Pedido: ");
                    String cliRemove = sc.nextLine();
                    int indexRemove = 0;
                    for (Pedido i : listaPedidos) {
                        if (cliRemove.equals(i.getCliente())) {
                            indexRemove = listaPedidos.indexOf(i);
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("Cliente informado não encontrado na lista!\n");
                    } else {
                        System.out.print("Informe o nome do Item a ser removido da lista: ");
                        String nomeItemRemove = sc.nextLine();
                        try {
                            listaPedidos.get(indexRemove).retiraItem(nomeItemRemove);
                            System.out.println("Item \"" + nomeItemRemove + "\" removido da lista do cliente " + listaPedidos.get(indexRemove).getCliente());
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    break;
                case 6:
                    listaPedidos.forEach((listar) -> {
                        System.out.println(listar.toString());
                    });
                    break;
                case 7:
                    System.out.println("Finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            if (opt != 7) {
                System.out.println("Selecione outra opção:");
            }
        } while (opt != 7);
    }

}
