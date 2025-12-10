public class ProdutoPorPeso extends Produto {
    private double kgComprados;
    private double kgVendidos;
    private double precoPorKgCompra;
    private double precoPorKgVenda;

    public ProdutoPorPeso(String nome, double kgComprados, double kgVendidos, double precoPorKgCompra,
            double precoPorKgVenda) {
        super(nome);
        this.kgComprados = kgComprados;
        this.kgVendidos = kgVendidos;
        this.precoPorKgCompra = precoPorKgCompra;
        this.precoPorKgVenda = precoPorKgVenda;
    }

    @Override
    public double entrada() {
        return this.kgVendidos * this.precoPorKgVenda;
    }

    @Override
    public double custo() {
        return this.kgComprados * this.precoPorKgCompra;
    }
}
