import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Supermercado {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int qtd_produtos;
    private double receita_total;
    private double custo_total;
    private double lucro_total;
    private Produto maior_entrada;
    private Produto maior_custo;
    private Produto maior_lucro;
    private Produto menor_lucro;

    public Supermercado(int qtd) {
        this.qtd_produtos = qtd;
        this.receita_total = 0;
        this.custo_total = 0;
        this.lucro_total = 0;
        this.maior_entrada = null;
        this.maior_custo = null;
        this.maior_lucro = null;
        this.menor_lucro = null;
    }

    public void le_produtos(Scanner sc) {
        String nome;
        String tipo;
        double kgComprados;
        double kgVendidos;
        double precoCompra;
        double precoVenda;
        double custoFuncinario;
        int quantidadeComprada;
        int quantidadeVendida;

        for (int i = 0; i < this.qtd_produtos; i++) {
            tipo = sc.next();
            nome = sc.next();

            if (tipo.equals("ProdutoEmpacotado")) {
                quantidadeComprada = sc.nextInt();
                quantidadeVendida = sc.nextInt();
                precoCompra = parseDouble(sc.next());
                precoVenda = parseDouble(sc.next());

                produtos.add(
                        new ProdutoEmpacotado(nome, quantidadeComprada, quantidadeVendida, precoCompra, precoVenda));

            } else if (tipo.equals("ProdutoPorPeso")) {
                kgComprados = parseDouble(sc.next());
                kgVendidos = parseDouble(sc.next());
                precoCompra = parseDouble(sc.next());
                precoVenda = parseDouble(sc.next());

                produtos.add(new ProdutoPorPeso(nome, kgComprados, kgVendidos, precoCompra, precoVenda));

            } else if (tipo.equals("CarneAcougue")) {
                kgComprados = parseDouble(sc.next());
                kgVendidos = parseDouble(sc.next());
                precoCompra = parseDouble(sc.next());
                precoVenda = parseDouble(sc.next());
                custoFuncinario = parseDouble(sc.next());
                produtos.add(new CarneAcougue(nome, custoFuncinario, kgComprados, kgVendidos, precoCompra, precoVenda));
            } else if (tipo.equals("ProdutoProcessadoKg")) {
                quantidadeComprada = sc.nextInt();
                precoCompra = parseDouble(sc.next());
                custoFuncinario = parseDouble(sc.next());
                precoVenda = parseDouble(sc.next());
                kgVendidos = parseDouble(sc.next());
                produtos.add(new ProdutoProcessadoKg(nome, quantidadeComprada, precoCompra, custoFuncinario, precoVenda,
                        kgVendidos));

            } else if (tipo.equals("ProdutoProcessadoUnidade")) {
                quantidadeComprada = sc.nextInt();
                precoCompra = parseDouble(sc.next());
                custoFuncinario = parseDouble(sc.next());
                precoVenda = parseDouble(sc.next());
                quantidadeVendida = sc.nextInt();

                produtos.add(
                        new ProdutoProcessadoUnidade(nome, quantidadeComprada, precoCompra, custoFuncinario, precoVenda,
                                quantidadeVendida));
            }
        }
    }

    public void analisa_produtos(Produto p) {
        if (this.menor_lucro.menor_lucro(p) == 1) {
            this.menor_lucro = p;
        }
        if (this.maior_lucro.maior_lucro(p) == 1) {
            this.maior_lucro = p;
        }
        if (this.maior_entrada.maior_entrada(p) == 1) {
            this.maior_entrada = p;
        }
        if (this.maior_custo.maior_custo(p) == 1) {
            this.maior_custo = p;
        }
    }

    private double parseDouble(String value) {
        // vrgula por ponto para aceitar ambos os formatos
        return Double.parseDouble(value.replace(',', '.'));
    }

    public void imprime_relatorio() {

        for (Produto produto : produtos) {
            produto.print_produto();
            this.analisa_produtos(produto);
            this.receita_total += produto.entrada();
            this.custo_total += produto.custo();
            this.lucro_total += produto.lucro();

        }
        System.out.printf(Locale.US, "Receita Total: %.2f\n", this.receita_total);
        System.out.printf(Locale.US, "Custo Total: %.2f\n", this.custo_total);
        System.out.printf(Locale.US, "Lucro Total: %.2f\n", this.lucro_total);
        System.out.printf(Locale.US, "maior receita: %s (%.2f)\n", this.maior_entrada.nome,
                this.maior_entrada.entrada());
        System.out.printf(Locale.US, "mais custoso: %s (%.2f)\n", this.maior_custo.nome, this.maior_custo.custo());
        System.out.printf(Locale.US, "mais lucrativo: %s (%.2f)\n", this.maior_lucro.nome, this.maior_lucro.lucro());
        System.out.printf(Locale.US, "menos lucrativo: %s (%.2f)\n", this.menor_lucro.nome, this.menor_lucro.lucro());
    }
}