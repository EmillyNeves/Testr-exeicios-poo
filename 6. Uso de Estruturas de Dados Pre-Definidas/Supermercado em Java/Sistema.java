import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Sistema {
    private HashMap<String, Produto> produtos;
    private HashMap<String, Cliente> clientes;
    private ArrayList<Compras> compras;
    private Compras compraAtual;

    public Sistema() {
        this.produtos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.compras = new ArrayList<>();
        this.compraAtual = null;
    }

    public void registrarProduto(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        produtos.put(nome, produto);
    }

    public void registrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.put(cpf, cliente);
    }

    public void adquirirProduto(String nomeProduto, int quantidade) {
        Produto produto = produtos.get(nomeProduto);
        if (produto != null) {
            produto.adicionarEstoque(quantidade);
        }
    }

    public void iniciarCompra(String cpf) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            compraAtual = new Compras(cliente);
        }
    }

    public void addItem(String nomeProduto, int quantidade) {
        Produto produto = produtos.get(nomeProduto);
        if (produto != null && compraAtual != null) {
            compraAtual.adicionarProduto(produto, quantidade);
        }
    }

    public void finalizarCompra() {
        if (compraAtual != null) {
            double total = compraAtual.calcularTotal();
            System.out.printf(Locale.US,"%.2f%n", total);
            compraAtual.finalizarCompra();
            compras.add(compraAtual);
            compraAtual = null;
        }
    }

    public void revenue() {
        double total = 0;
        for (Compras compra : compras) {
            total += compra.getValorTotal();
        }
        System.out.printf(Locale.US,"%.2f%n", total);
    }

    public void maisVendido() {
        HashMap<Produto, Integer> vendas = new HashMap<>();
        
        for (Compras compra : compras) {
            for (Map.Entry<Produto, Integer> entry : compra.getProdutos().entrySet()) {
                Produto produto = entry.getKey();
                int quantidade = entry.getValue();
                vendas.put(produto, vendas.getOrDefault(produto, 0) + quantidade);
            }
        }

        Produto maisVendido = null;
        int maxVendas = 0;
        
        for (Map.Entry<Produto, Integer> entry : vendas.entrySet()) {
            if (entry.getValue() > maxVendas) {
                maxVendas = entry.getValue();
                maisVendido = entry.getKey();
            }
        }

        if (maisVendido != null) {
            System.out.println(maisVendido.getNome());
        }
    }

    public void melhorCliente() {
        HashMap<Cliente, Integer> numCompras = new HashMap<>();
        
        for (Compras compra : compras) {
            Cliente cliente = compra.getCliente();
            numCompras.put(cliente, numCompras.getOrDefault(cliente, 0) + 1);
        }

        Cliente melhorCliente = null;
        int maxCompras = 0;
        
        for (Map.Entry<Cliente, Integer> entry : numCompras.entrySet()) {
            if (entry.getValue() > maxCompras) {
                maxCompras = entry.getValue();
                melhorCliente = entry.getKey();
            }
        }

        if (melhorCliente != null) {
            System.out.println(melhorCliente.getNome());
        }
    }

    public void emFalta() {
        for (Produto produto : produtos.values()) {
            if (produto.getQtd() < 5) {
                System.out.println(produto.getNome());
            }
        }
    }
}