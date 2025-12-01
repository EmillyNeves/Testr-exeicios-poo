import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String nome = sc.nextLine();
        int estoque = sc.nextInt();
        double valor = sc.nextDouble();
        double desconto = sc.nextDouble();

        Produto p = new Produto(nome, estoque, valor, desconto);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);

            if (c == 'V') {
                p.venda(sc.nextInt());
            } else if (c == 'C') {
                p.compra(sc.nextInt());
            }
        }
        System.out.printf(p.getNome() + "\n");
        System.out.printf(p.getEstoque() + "\n");
        System.out.printf("%.2f\n", p.getValor());
        System.out.printf("%.2f\n", p.getDesconto());
        System.out.printf("%.2f\n", p.preco());
        System.out.printf("%.2f\n", p.valor_vendas());

        sc.close();
    }
}
