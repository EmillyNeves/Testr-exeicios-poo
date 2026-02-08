public interface MeioEntrega {
    int prazo();

    double frete(Carrinho carrinho, double distancia);
}