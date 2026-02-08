public class Carrinho {
    private double valor;
    private double peso;
    private double distanciaEmKm;
    private FreteStrategy frete;

    public Carrinho(double valor, double peso, 
        double distanciaEmKm, FreteStrategy frete) {
        this.peso = peso;
        this.valor = valor;
        this.distanciaEmKm = distanciaEmKm;
        this.frete = frete;
    }

    public double calcularTotalCompra() {
        return this.valor + 
        frete.calcularFrete(this.peso, this.distanciaEmKm);
    }

    public void setFreteStrategy(FreteStrategy frete) {
        this.frete = frete;
    }

}
