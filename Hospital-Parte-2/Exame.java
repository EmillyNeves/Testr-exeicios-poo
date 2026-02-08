public class Exame {
    private String _nome;
    private double _custo;

    public Exame(String nome, double custo) {
        this._nome = nome;
        this._custo = custo;
    }

    public String getNome() {
        return _nome;
    }

    public double getCusto() {
        return _custo;
    }
}
