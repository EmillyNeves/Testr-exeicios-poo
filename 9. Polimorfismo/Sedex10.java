public class Sedex10 implements MeioEntrega {

    @Override
    public int prazo() {
        return 1;// dia
    }

    @Override
    public double frete(Carrinho carrinho, double distancia) {
        return carrinho.total() * 0.5 + 0.75 * distancia;
    }
}