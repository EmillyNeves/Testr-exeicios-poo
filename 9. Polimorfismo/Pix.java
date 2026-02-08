public class Pix implements MetodoPagamento {

    @Override
    public double pagar(Carrinho carrinho) {
        return carrinho.total() * 0.9;// disconto pix
    }
}