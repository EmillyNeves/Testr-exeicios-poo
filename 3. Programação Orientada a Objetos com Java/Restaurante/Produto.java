public class Produto {

    private String nome;
    private int estoqueDiario;
    private int qtd_vendas;
    private double custo;
    private double preco;

    public Produto(String nome, int estoqueDiario, int qtd_vendas, double custo, double preco) {
        this.nome = nome;
        this.estoqueDiario= estoqueDiario;
        this.qtd_vendas = qtd_vendas;
        this.custo = custo;
        this.preco = preco;
    }

    public String get_nome() {
        return this.nome;
    }

    public int qtd_vendas() {
        return this.qtd_vendas;
    }

    public double valor_vendas() {
        return this.qtd_vendas * this.preco;
    }

    public double custo_producao() {
        return this.custo * this.estoqueDiario;
    }

    public double lucro() {
        return this.valor_vendas() - this.custo_producao();
    }

}
