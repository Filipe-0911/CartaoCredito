package br.com.cartaodecredito.classes;

public class Compra {
    private double valor;
    private String nomeProduto;

    public Compra(double valor, String nomeProduto) {
        this.valor = valor;
        this.nomeProduto = nomeProduto;

    }
    public double getValor() {
        return valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }



}
