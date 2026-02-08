import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> _produtos;

    public Carrinho() {
        this._produtos = new ArrayList<>();
    }

    public double total() {
        double total = 0;
        for (Produto p : _produtos) {
            total += p.getValor();
        }
        return total;
    }

    public void add(Produto p) {
        _produtos.add(p);
    }

    public ArrayList<Produto> getProdutos() {
        return _produtos;
    }
}