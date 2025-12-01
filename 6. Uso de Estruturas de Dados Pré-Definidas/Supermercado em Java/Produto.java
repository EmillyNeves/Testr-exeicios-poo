public class Produto {
    private String nome;
    private int qtd;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getQtd() {
        return qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionarEstoque(int quantidade) {
        this.qtd += quantidade;
    }

    public void removerEstoque(int quantidade) {
        this.qtd -= quantidade;
    }

    public boolean temEstoque(int quantidade) {
        return this.qtd >= quantidade;
    }
}