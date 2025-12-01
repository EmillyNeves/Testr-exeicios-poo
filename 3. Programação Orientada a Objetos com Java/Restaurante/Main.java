import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String nomeRede = sc.nextLine();

        String nomeR = sc.nextLine(); // r1

        String nomeP = sc.next();// p1
        int estoqueDiario = sc.nextInt();
        int qtd_vendas = sc.nextInt();
        double custo = sc.nextDouble();
        double preco = sc.nextDouble();
        Produto p1 = new Produto(nomeP, estoqueDiario, qtd_vendas, custo, preco);

        nomeP = sc.next();// p2
        estoqueDiario = sc.nextInt();
        qtd_vendas = sc.nextInt();
        custo = sc.nextDouble();
        preco = sc.nextDouble();
        Produto p2 = new Produto(nomeP, estoqueDiario, qtd_vendas, custo, preco);

        nomeP = sc.next();// p3
        estoqueDiario = sc.nextInt();
        qtd_vendas = sc.nextInt();
        custo = sc.nextDouble();
        preco = sc.nextDouble();
        Produto p3 = new Produto(nomeP, estoqueDiario, qtd_vendas, custo, preco);

        Restaurante r1 = new Restaurante(nomeR, p1, p2, p3);
        sc.nextLine();
        
        nomeR = sc.nextLine(); // r2

        nomeP = sc.next();// p1
        estoqueDiario = sc.nextInt();
        qtd_vendas = sc.nextInt();
        custo = sc.nextDouble();
        preco = sc.nextDouble();
        p1 = new Produto(nomeP, estoqueDiario, qtd_vendas, custo, preco);

        nomeP = sc.next();// p2
        estoqueDiario = sc.nextInt();
        qtd_vendas = sc.nextInt();
        custo = sc.nextDouble();
        preco = sc.nextDouble();
        p2 = new Produto(nomeP, estoqueDiario, qtd_vendas, custo, preco);

        nomeP = sc.next();// p3
        estoqueDiario = sc.nextInt();
        qtd_vendas = sc.nextInt();
        custo = sc.nextDouble();
        preco = sc.nextDouble();
        p3 = new Produto(nomeP, estoqueDiario, qtd_vendas, custo, preco);

        Restaurante r2 = new Restaurante(nomeR, p1, p2, p3);

        Rede rede = new Rede(nomeRede, r1, r2);
        Produto produtoMV = rede.mais_vendido();

        System.out.printf("%s ", produtoMV.get_nome());
        System.out.printf("%d\n", produtoMV.qtd_vendas());

        System.out.printf("%s ", rede.mais_lucrativo().get_nome());
        System.out.printf(Locale.US,"%.2f\n", rede.mais_lucrativo().lucro());

        System.out.printf(Locale.US,"%.2f\n", rede.valor_vendas());
        System.out.printf(Locale.US,"%.2f\n", rede.custo());
        System.out.printf(Locale.US,"%.2f\n", rede.lucro());

        sc.close();
    }
}
