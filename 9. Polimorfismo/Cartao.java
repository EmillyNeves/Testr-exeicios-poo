public class Cartao implements MetodoPagamento {

    @Override
    public double pagar(Carrinho carrinho) {
        return carrinho.total();
    }
}