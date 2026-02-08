public class Produto {
    private String _nome;
    private double _valor;

    public Produto(String nome, double valor) {
        this._nome = nome;
        this._valor = valor;
    }

    public String getNome() {
        return this._nome;
    }

    public double getValor() {
        return this._valor;
    }
}