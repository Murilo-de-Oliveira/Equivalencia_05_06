package org.example;

public class Produto implements Comparable<Produto>{
    private String nome;
    private double preco;
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public int compareTo(Produto o) {
        return Double.compare(this.preco,o.preco);
    }
}
