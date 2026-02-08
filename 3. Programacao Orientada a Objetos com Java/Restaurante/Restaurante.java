public class Restaurante {

    private String nome;
    private Produto p1;
    private Produto p2;
    private Produto p3;

    public Restaurante(String nome, Produto p1, Produto p2, Produto p3) {
        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public String get_nome() {
        return this.nome;
    }

    public int qtd_vendas() {
        return this.p1.qtd_vendas() + this.p2.qtd_vendas() + this.p3.qtd_vendas();
    }

    public double valor_vendas() {
        return this.p1.valor_vendas() + this.p2.valor_vendas() + this.p3.valor_vendas();
    }

    public double custo_producao() {
        return this.p1.custo_producao() + this.p2.custo_producao() + this.p3.custo_producao();
    }

    public double lucro() {
        return this.valor_vendas() - this.custo_producao();
    }

    public Produto mais_vendido() {
        if (this.p1.qtd_vendas() < this.p2.qtd_vendas()) {
            if (this.p3.qtd_vendas() < this.p2.qtd_vendas())
                return p2;
            else if (this.p3.qtd_vendas() > this.p2.qtd_vendas())
                return p3;
            else
                return p2;
        } else if (this.p3.qtd_vendas() > this.p1.qtd_vendas()) {
            if (this.p3.qtd_vendas() < this.p2.qtd_vendas())
                return p2;
            else if (this.p3.qtd_vendas() > this.p2.qtd_vendas())
                return p3;
            else
                return p3;
        }
        return p1;
    }

}