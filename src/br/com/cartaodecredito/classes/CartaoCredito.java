package br.com.cartaodecredito.classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CartaoCredito {
    private String nome;
    private double saldo;
    private int numeroDaConta;
    private LinkedList<Compra> listaDeCompras = new LinkedList<>();

    public CartaoCredito(String nome, double saldo, int numeroDaConta) {
        this.nome = nome;
        this.saldo = saldo;
        this.numeroDaConta = numeroDaConta;

    }
    public void setCompra(Compra compra) {
        this.listaDeCompras.push(compra);
    }
    public void getCompras() {
        //this.listaDeCompras.sort(Comparator.comparing(Compra::getValor));
        Collections.sort(this.listaDeCompras);
        for (Compra compra : this.listaDeCompras) {
            System.out.println(compra);
        }

    }

    public void realizaCompra(double valor) {
        if (this.saldo - valor > 0) {
            this.saldo -= valor;
            System.out.println("Compra realizada com sucesso! Seu novo saldo é de %.2f".formatted(this.saldo));
        } else {
            System.out.println("Você não tem saldo o suficiente para realizar esta compra!");
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    @Override
    public String toString() {
        return "N. Conta: %d; Cartão do cliente %s; Saldo: %.2f".formatted(this.numeroDaConta, this.nome, this.saldo);
    }
}
