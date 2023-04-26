package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       System.out.println("Entre com dados do cliente: ");
        System.out.print("Name: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de Nasceimento: ");
        Date dataAniversario = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome, email, dataAniversario);

        System.out.println("Insira os dados do pedido: ");
        System.out.print("Status: ");
        Status status = Status.valueOf(sc.next());

        Ordem ordem = new Ordem(new Date(), status, cliente);

        System.out.print("Quantos itens para este pedido? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Entre com #" + i + " item data: ");
            System.out.print("Produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preco: ");
            double preco = sc.nextDouble();

            Produto produto = new Produto(nomeProduto, preco);

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            ItemPedido pedido = new ItemPedido(quantidade, preco, produto);
            ordem.addItem(pedido);

        }

        System.out.println();
        System.out.println("Resumo do pedido: ");
        System.out.println(ordem);

        sc.close();
    }
}