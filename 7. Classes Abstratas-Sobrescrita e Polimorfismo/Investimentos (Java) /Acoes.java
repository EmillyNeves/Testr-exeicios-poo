public class Acoes extends Investimento {
    private double variacao_acumulada;
    private double valor_acao;

    public Acoes(String nome, double valor_inicial, double variacao_acumulada) {
        super(nome, valor_inicial);
        this.variacao_acumulada = variacao_acumulada;
        this.valor_acao = valor_inicial * (1 + variacao_acumulada);
    }

    public double getVariacao_acumulada() {
        return this.variacao_acumulada;
    }

    public double getValor_acao() {
        return this.valor_acao;
    }

    // retorno = valor_acao(atual) - valor_inicial;
    @Override
    public double retorno() {
        return valor_acao - valor_inicial;
    }
}
