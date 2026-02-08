public class Carro extends Transporte {
    private double taxaDesvalorizacao;
    private double distanciaPercorrida;
    private double precoGasolinaPorKm;
    private double precoManutencaoPorKm;
    private String nome;

    public Carro(String nome, double custoBase, double taxaDesvalorizacao, double distanciaPercorrida,
            double precoGasolinaPorKm, double precoManutencaoPorKm) {
        super(custoBase);
        this.nome = nome;
        this.taxaDesvalorizacao = taxaDesvalorizacao;
        this.distanciaPercorrida = distanciaPercorrida;
        this.precoGasolinaPorKm = precoGasolinaPorKm;
        this.precoManutencaoPorKm = precoManutencaoPorKm;
    }

    public String nome() {
        return this.nome;
    }

    public double lucratividade() {
        return custoBase * taxaDesvalorizacao
                * (custoBase + distanciaPercorrida * precoGasolinaPorKm + distanciaPercorrida * precoManutencaoPorKm);
    }
}
