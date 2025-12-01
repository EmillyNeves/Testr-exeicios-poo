public class Rede {

    private String nome;
    private Restaurante r1;
    private Restaurante r2;

    public Rede(String nome, Restaurante r1, Restaurante r2) {
        this.nome = nome;
        this.r1 = r1;
        this.r2 = r2;
    }

    public double valor_vendas() {
        return r1.valor_vendas() + r2.valor_vendas();
    }

    public double custo() {
        return r1.custo_producao() + r2.custo_producao();
    }

    public double lucro() {
        return valor_vendas() - custo();
    }

    public Produto mais_vendido() {
        Produto p1 = this.r1.mais_vendido();
        Produto p2 = this.r2.mais_vendido();

        if (p1.qtd_vendas() < p2.qtd_vendas())
            return p2;
        else
            return p1;
    }

    public Restaurante mais_lucrativo() {
        if (r1.lucro() < r2.lucro())
            return r2;
        else
            return r1;
    }

    public String get_nome() {
        return this.nome;
    }
}
