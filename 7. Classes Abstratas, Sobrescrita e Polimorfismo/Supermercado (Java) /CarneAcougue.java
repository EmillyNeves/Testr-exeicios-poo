public class CarneAcougue extends ProdutoPorPeso {
    private double custoAcougueiro;

    public CarneAcougue(String nome, double custoAcougueiro, double kgComprados, double kgVendidos,
            double precoPorKgCompra, double precoPorKgVenda) {
        super(nome, kgComprados, kgVendidos, precoPorKgCompra, precoPorKgVenda);
        this.custoAcougueiro = custoAcougueiro;
    }

    @Override
    public double custo() {
        return custoAcougueiro + super.custo();
    }
}
