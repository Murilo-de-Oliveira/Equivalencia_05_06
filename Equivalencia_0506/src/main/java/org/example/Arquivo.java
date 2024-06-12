package org.example;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    // Métodos que podemos realizar com o arquivo
    public void escrever(Produto produto) {
        // Instanciando os objetos que permitirão a escrita de dados
        OutputStream os = null; // fluxo de entrada
        OutputStreamWriter osw = null; //leitor de fluxo de entrada
        BufferedWriter bw = null; //buffer entrada

        // Variável auxiliar
        String linha;

        try {
            // Abrindo a saída de dados
            os = new FileOutputStream("Produtos.txt", true); // Nome do arquivo onde será salvo
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flag que indica onde começa as informações do Funcionário
            bw.write("++ Produtos ++\n");
            bw.write(produto.getNome() + "\n");
            bw.write(produto.getPreco() + "\n");
            bw.write(produto.getTipo() + "\n");

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        } finally {
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    // 2. Método ler
    public ArrayList<Produto> ler() {

        // ArrayList auxiliar para salvar funcionários encontrados no arquivo
        ArrayList<Produto> encontreiNoArquivo = new ArrayList<>();

        // Classes que permitem leitura de dados do arquivo
        InputStream is = null; //fluxo saida
        InputStreamReader isr = null; //gerador de fluxo de saida
        BufferedReader br = null; // buffer de saida

        // Variável auxiliar que servirá de flag para o while
        String linhaLer;

        try {
            // Instanciando os objetos
            is = new FileInputStream("Produtos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            linhaLer = br.readLine();

            while (linhaLer != null) {
                // Comparando se o que está em linhaLer é igual a minha flag
                if (linhaLer.contains("++ Produtos ++")) {
                    // Variável auxiliar de funcionario
                    Produto produto = new Produto();
                    produto.setNome(br.readLine());
                    produto.setPreco(Double.parseDouble(br.readLine()));
                    produto.setTipo(br.readLine());

                    // Adicionando o funcionario no array
                    encontreiNoArquivo.add(produto);
                }
                linhaLer = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Algo deu errado: " + e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        return encontreiNoArquivo;
    }
}