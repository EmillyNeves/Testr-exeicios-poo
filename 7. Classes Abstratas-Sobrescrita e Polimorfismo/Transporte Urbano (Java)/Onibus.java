public class Onibus extends Transporte {
    private double distanciaPercorrida;
    private double precoGasolinaPorKm;
    private int numeroPassageiros;
    private double precoPassagem;
    private String nome;

    public Onibus(String nome, double custoBase, double distanciaPercorrida, double precoGasolinaPorKm,
            int numeroPassageiros, double precoPassagem) {
        super(custoBase);
        this.nome = nome;
        this.distanciaPercorrida = distanciaPercorrida;
        this.precoGasolinaPorKm = precoGasolinaPorKm;
        this.numeroPassageiros = numeroPassageiros;
        this.precoPassagem = precoPassagem;
    }

    public String nome() {
        return this.nome;
    }

    public double lucratividade() {
        return this.numeroPassageiros * this.precoPassagem
                * (this.custoBase + this.distanciaPercorrida * this.precoGasolinaPorKm);
    }

}
