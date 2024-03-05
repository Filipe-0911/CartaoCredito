import br.com.cartaodecredito.classes.CartaoCredito;
import br.com.cartaodecredito.classes.Compra;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<CartaoCredito> listaDeCartoes = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        boolean ciclo = true;

        while(ciclo) {
            CartaoCredito cartaoEncontrado;
            System.out.println();
            System.out.println("Escolha uma opção");
            System.out.println("0 - Criar cartão");
            System.out.println("1 - Realizar compra");
            System.out.println("2 - Verificar Saldo");
            System.out.println("3 - Verificar Nome do proprietário do cartão");
            System.out.println("4 - Listar cartões");
            System.out.println("5 - Listar Extrato");
            System.out.println("6 - Sair");
            System.out.println();
            int escolha = in.nextInt();

            switch (escolha) {
                case 0: //Cria cartao
                    System.out.println("Digite o nome do priprietário do cartão: ");
                    String nome = in.next();

                    System.out.println("Digite o limite do cartão: ");
                    double saldo = in.nextDouble();

                    System.out.println("Digite o número da conta: ");
                    int numeroDaConta = in.nextInt();

                    CartaoCredito cartao = criaCartaoDeCredito(nome, saldo, numeroDaConta);
                    listaDeCartoes.add(cartao);
                    break;
                case 1: //realizaCompra
                    System.out.println("Digite o numero da conta em que fará a compra: ");
                    listarCartoes(listaDeCartoes);
                    int escolhaCase1 = in.nextInt();

                    System.out.println("Digite o valor ");
                    double valor = in.nextDouble();

                    System.out.println("Digite o nome do produto: ");
                    System.out.println("Obs.: Descreva o produto em uma palavra");
                    String nomeProduto = in.next();

                    Compra compra = new Compra(valor, nomeProduto);

                    cartaoEncontrado = findCard(listaDeCartoes, escolhaCase1);

                    if (cartaoEncontrado != null) {
                        cartaoEncontrado.realizaCompra(valor);
                        cartaoEncontrado.setCompra(compra);
                    }
                    break;
                case 2: //getSaldo
                    System.out.println("Digite o numero da conta que deseja saber o saldo");
                    listarCartoes(listaDeCartoes);
                    int escolhaDaContaCase2 = in.nextInt();

                    cartaoEncontrado = findCard(listaDeCartoes, escolhaDaContaCase2);
                    if (cartaoEncontrado != null)
                        System.out.println(cartaoEncontrado.getSaldo());
                    break;
                case 3: //getNome
                    System.out.println("Digite o numero da conta que deseja saber o nome");
                    listarCartoes(listaDeCartoes);
                    int escolhaDaContaCase3 = in.nextInt();

                    cartaoEncontrado = findCard(listaDeCartoes, escolhaDaContaCase3);
                    if (cartaoEncontrado != null)
                        System.out.println(cartaoEncontrado.getNome());
                    break;
                case 4:
                    listarCartoes(listaDeCartoes);
                    break;
                case 5:
                    System.out.println("Digite o numero da conta que deseja verificar as compras: ");
                    listarCartoes(listaDeCartoes);

                    int escolhaDaContaCase5 = in.nextInt();
                    cartaoEncontrado = findCard(listaDeCartoes, escolhaDaContaCase5);
                    if (cartaoEncontrado != null) {
                        cartaoEncontrado.getCompras();
                    }
                    break;
                case 6:
                    ciclo = false;
                    break;

            }
        }
    }
    private static CartaoCredito findCard(LinkedList<CartaoCredito> listaDeCartoes, int escolhaCase1) {
        for (CartaoCredito cardFound : listaDeCartoes) {
            if (cardFound.getNumeroDaConta() == escolhaCase1) {
                return cardFound;
            }

        }
        return null;
    }

    public static CartaoCredito criaCartaoDeCredito(String nome, double saldo, int numeroDaConta) {
        CartaoCredito cartao = new CartaoCredito(nome, saldo, numeroDaConta);
        return cartao;
    }

    public static void listarCartoes(List<CartaoCredito> lista) {
        for (CartaoCredito cartao : lista) {
            System.out.println(cartao);
        }
    }

}