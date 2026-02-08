public class Product implements Comparable<Product> {
    private String _nome;
    private double _preco;

    public Product(String _nome, double _preco) {
        this._nome = _nome;
        this._preco = _preco;
    }

    public String get_nome() {
        return this._nome;
    }

    public double get_preco() {
        return this._preco;
    }

    @Override
    public int compareTo(Product other) {
        int resultadoPreco = 
        Double.compare(this._preco, other._preco);

        if (resultadoPreco != 0) {
            return resultadoPreco;
        }
        return this._nome.compareTo(other._nome);
    }
}