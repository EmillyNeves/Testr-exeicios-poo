public abstract class ProdutoProcessado extends Produto {
    private int qtdProduzida;
    private double custoMateriaPrimaPorQtd;
    private double custoFuncionario;

    public ProdutoProcessado(String nome, int qtdProduzida, double custoMateriaPrimaPorQtd, double custoFuncionario) {
        super(nome);
        this.custoMateriaPrimaPorQtd = custoMateriaPrimaPorQtd;
        this.custoFuncionario = custoFuncionario;
        this.qtdProduzida = qtdProduzida;
    }

    @Override
    public double custo() {
        return (this.qtdProduzida * this.custoMateriaPrimaPorQtd) + this.custoFuncionario;
    }

}
