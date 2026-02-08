public class FreteTransportadora implements FreteStrategy{
    @Override
    public double calcularFrete(double pesoEmKg, double distanciaEmKm){
        return (pesoEmKg * 1.8) + (distanciaEmKm * 0.5);
    }
}
