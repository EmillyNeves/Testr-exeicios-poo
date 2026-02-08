class FretePadrao implements FreteStrategy {
    @Override
    public double calcularFrete(double pesoEmKg, double distanciaEmKm) {
        return 5.0 + (pesoEmKg * 1.0);
    }
}