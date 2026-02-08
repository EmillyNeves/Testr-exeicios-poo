public abstract class Investimento {
    private String nome;
    protected double valor_inicial;

    public Investimento(String nome, double valor_inicial) {
        this.nome = nome;
        this.valor_inicial = valor_inicial;
    }

    public String getNome() {
        return this.nome;
    }

    public double getValor_inicial() {
        return this.valor_inicial;
    }

    public abstract double retorno();
}
