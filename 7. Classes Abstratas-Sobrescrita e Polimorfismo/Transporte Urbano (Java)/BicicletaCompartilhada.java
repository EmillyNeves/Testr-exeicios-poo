public class BicicletaCompartilhada extends Transporte {
    private String nome;
    private double horasUtilizadas;
    private double precoPorHora;
    private double custoManutencaoPorHora;

    public BicicletaCompartilhada(String nome, double custoBase, double horasUtilizadas, double precoPorHora,
            double custoManutencaoPorHora) {
        super(custoBase);
        this.nome = nome;
        this.horasUtilizadas = horasUtilizadas;
        this.custoManutencaoPorHora = custoManutencaoPorHora;
        this.precoPorHora = precoPorHora;
    }

    public String nome() {
        return this.nome;
    }

    public double lucratividade() {
        return (this.horasUtilizadas * this.precoPorHora
                * (this.custoBase + this.custoManutencaoPorHora * this.horasUtilizadas));
    }
}
