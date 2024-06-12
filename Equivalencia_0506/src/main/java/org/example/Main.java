package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true; //flag para controlar continuidade do programa
        Scanner sc = new Scanner(System.in); //declaração do scanner
        Arquivo arquivo = new Arquivo(); //declaração do arquivo
        Produto produto = new Produto(); //produto para inserção no arquivo
        ArrayList<Produto> produtos = new ArrayList<>(); //declaração do arraylist de produtos
        System.out.println("Bem-vindo ao menu de Produtos");
        while(continuar){
            //Menu de opções
            System.out.println("1 - Cadastrar produtos");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Ordenar produtos (decrescente por preço)");
            System.out.println("4 - Mostrar quantidade de produtos (por tipo)");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            //input da opção
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                //Cadastro do cliente
                case 1 :
                    try{
                        System.out.print("Nome do produto: ");
                        produto.setNome(sc.nextLine());
                        System.out.print("Preço do produto: ");
                        var auxpreco = sc.nextDouble();
                        if(auxpreco > 0){
                            produto.setPreco(auxpreco);
                        } else {
                            throw new InfoInvalidaException("O preço do produto deve ser maior que 0");
                        }
                        sc.nextLine();
                        System.out.print("Tipo do produto: ");
                        var auxtipo = sc.nextLine().toLowerCase();
                        if(auxtipo.equalsIgnoreCase("decoração") | auxtipo.equalsIgnoreCase("higiene") | auxtipo.equalsIgnoreCase("comida")){
                            produto.setTipo(auxtipo);
                        } else {
                            throw new InfoInvalidaException("Tipo inválido, deve ser Decoração, Higiene ou Comida");
                        }
                        //a função escrever é chamada para inserir o cliente no arquivo
                        arquivo.escrever(produto);
                    } catch (InfoInvalidaException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                //Lista de clientes
                case 2 :
                    produtos = arquivo.ler(); //a lista de clientes armazena a lista retornada da função

                    //mostra os produtos cadastrados
                    for (Produto value : produtos) {
                        System.out.println("INFORMAÇÕES DO PRODUTO: ");
                        System.out.println(value.getNome());
                        System.out.println(value.getPreco());
                        System.out.println(value.getTipo());
                    }
                    break;

                //Lista reversa de preço
                case 3:
                    produtos = arquivo.ler(); //a lista de produtos armazena a lista retornada da função

                    Collections.sort(produtos); //lista os produtos do menor pro maior
                    Collections.reverse(produtos); //reverte a lista de trás pra frente

                    //lista os produtos
                    for (Produto value : produtos) {
                        System.out.println("INFORMAÇÕES DO PRODUTO: ");
                        System.out.println(value.getNome());
                        System.out.println(value.getPreco());
                        System.out.println(value.getTipo());
                    }
                    break;

                case 4:
                    produtos = arquivo.ler(); //a lista de produtos armazena a lista retornada da função
                    int comida_prod = 0;
                    int higiene_prod = 0;
                    int decoracao_prod = 0;
                    //lista os produtos
                    for (Produto item : produtos) {
                        switch (item.getTipo()) {
                            case "higiene" -> comida_prod++;
                            case "comida" -> higiene_prod++;
                            case "decoração" -> decoracao_prod++;
                        }
                    }
                    System.out.println("Comida: " + comida_prod);
                    System.out.println("Higiene: " + higiene_prod);
                    System.out.println("Decoração: " + decoracao_prod);
                    break;

                //Sai do programa
                case 5:
                    continuar = false;
                    System.out.println("Saiu do programa");
                    break;
            }
        }
    }
}