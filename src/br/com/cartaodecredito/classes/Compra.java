package br.com.cartaodecredito.classes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Compra implements Comparable<Compra> {
    private double valor;
    private String nomeProduto;
    private String dataDaCompra;
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Compra(double valor, String nomeProduto) {
        this.valor = valor;
        this.nomeProduto = nomeProduto;
        this.dataDaCompra = formatador.format(LocalDateTime.now());

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

    @Override
    public String toString(){
        return "Produto: %s; Valor: %.2f; Data da compra: %s".formatted(this.nomeProduto, this.valor, this.dataDaCompra);
    }
    @Override
    public int compareTo(Compra outraCompra) {
        Date dataCompraConvertida;
        Date dataDestaCompraConvertida;
        String dataCompra = outraCompra.dataDaCompra;
        String dataDestaCompra = this.dataDaCompra;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            dataCompraConvertida = sdf1.parse(dataCompra);
            dataDestaCompraConvertida = sdf2.parse(dataDestaCompra);

            return dataDestaCompraConvertida.compareTo(dataCompraConvertida);
        } catch (Exception error) {
            System.out.println(error);
        }

        return 0;
    }

}
