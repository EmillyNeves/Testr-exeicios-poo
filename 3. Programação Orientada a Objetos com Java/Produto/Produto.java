public class Produto {
    private String nome;
    private int estoque;
    private double valor;
    private double desconto;
    private int totalVendas;

    public Produto(String nome, int estoque, double valor, double desconto) {
        this.nome = nome;
        this.totalVendas = 0;

        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            this.estoque = 0;
            System.out.println("VALOR INVALIDO\n");
        }

        if (desconto >= 0 && desconto < 1) {
            this.desconto = desconto;
        } else {
            this.desconto = 0;
            System.out.println("VALOR INVALIDO\n");
        }

        if (valor > 0) {
            this.valor = valor;
        } else {
            this.valor = 1;
            System.out.println("VALOR INVALIDO\n");
        }
    }

    public void compra(int qtd) {
        if (qtd > 0)
            this.estoque += qtd;
        else
            System.out.println("VALOR INVALIDO\n");
    }

    public void venda(int qtd) {
        if (qtd > 0 && qtd <= this.estoque) {
            this.estoque -= qtd;
            this.totalVendas += qtd;
        } else
            System.out.println("VALOR INVALIDO\n");
    }

    public double preco() {
        return this.valor - (this.valor * this.desconto);
    }

    public double getValor() {
        return this.valor;
    }

    public double valor_vendas() {
        return this.preco() * this.totalVendas;
    }

    public String getNome() {
        return this.nome;
    }

    public double getDesconto() {
        return desconto;
    }

    public int getEstoque() {
        return estoque;
    }

}
