public class ProdutoProcessadoKg extends ProdutoProcessado {
    private double precoKgVenda;
    private double KgVendidos;

    public ProdutoProcessadoKg(String nome, int qtdProduzida, double custoMateriaPrimaPorQtd, double custoFuncionario,
            double precoKgVenda, double KgVendidos) {
        super(nome, qtdProduzida, custoMateriaPrimaPorQtd, custoFuncionario);
        this.precoKgVenda = precoKgVenda;
        this.KgVendidos = KgVendidos;
    }

    @Override
    public double entrada() {
        return this.precoKgVenda * this.KgVendidos;
    }
}
