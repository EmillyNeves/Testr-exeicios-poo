public class ProdutoProcessadoUnidade extends ProdutoProcessado {
    private double precoUnidade;
    private int UnidadesVendidas;

    public ProdutoProcessadoUnidade(String nome, int qtdProduzida, double custoMateriaPrimaPorQtd,
            double custoFuncionario,
            double precoUnidade, int UnidadesVendidas) {
        super(nome, qtdProduzida, custoMateriaPrimaPorQtd, custoFuncionario);
        this.precoUnidade = precoUnidade;
        this.UnidadesVendidas = UnidadesVendidas;
    }

    @Override
    public double entrada() {
        return this.precoUnidade * this.UnidadesVendidas;
    }

}
