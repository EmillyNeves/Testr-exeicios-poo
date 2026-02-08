public class Metro extends Transporte {
    private int numeroDePassageiros;
    private double receitaPorPassageiro;
    private String nome;

    public Metro(String nome, double custoBase, int numeroDePassageiros, double receitaPorPassageiro) {
        super(custoBase);
        this.nome = nome;
        this.numeroDePassageiros = numeroDePassageiros;
        this.receitaPorPassageiro = receitaPorPassageiro;
    }

    public String nome() {
        return this.nome;
    }

    public double lucratividade() {
        return (this.receitaPorPassageiro * this.numeroDePassageiros) - this.custoBase;
    }
}
