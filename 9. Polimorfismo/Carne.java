public class Carne implements MetodoPagamento {

    @Override
    public double pagar(Carrinho carrinho) {
        return carrinho.total() * 1.2;
    }
}