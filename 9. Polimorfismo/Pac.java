public class Pac implements MeioEntrega {

    @Override
    public int prazo() {
        return 15;// dias
    }

    @Override
    public double frete(Carrinho carrinho, double distancia) {
        return carrinho.total() * 0.05 + 0.05 * distancia;
    }
}