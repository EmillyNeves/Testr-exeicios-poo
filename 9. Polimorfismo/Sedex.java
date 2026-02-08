public class Sedex implements MeioEntrega {
    
    @Override
    public int prazo() {
        return 5;//dias
    }
    
    @Override
    public double frete(Carrinho carrinho, double distancia) {
        return carrinho.total() * 0.2 + 0.1 * distancia;
    }
}