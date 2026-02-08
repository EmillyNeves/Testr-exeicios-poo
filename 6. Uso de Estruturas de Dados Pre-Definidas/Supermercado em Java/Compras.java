import java.util.HashMap;
import java.util.Map;

public class Compras {
    private Cliente cliente;
    private HashMap<Produto, Integer> produtos;
    private double valorTotal;

    public Compras(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new HashMap<>();
        this.valorTotal = 0;
    }

    public void adicionarProduto(Produto p, int qtd) {
        if (produtos.containsKey(p)) {
            produtos.put(p, produtos.get(p) + qtd);
        } else {
            produtos.put(p, qtd);
        }
    }

    public double calcularTotal() {
        valorTotal = 0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            valorTotal += entry.getKey().getPreco() * entry.getValue();
        }
        return valorTotal;
    }

    public void finalizarCompra() {
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            entry.getKey().removerEstoque(entry.getValue());
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HashMap<Produto, Integer> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}