public class Medicacao {
    private String _nome;
    private double _custo;
    private int _estoque;

    public Medicacao(String nome, double custo, int estoqueInicial) {
        this._nome = nome;
        this._custo = custo;
        this._estoque = estoqueInicial;
    }

    public boolean subEstoque(int quantidade) {
        if (this._estoque >= quantidade) {
            this._estoque -= quantidade;
            return true;
        }
        return false; 
    }

    public String getNome() {
        return _nome;
    }

    public double getCusto() {
        return _custo;
    }
}
