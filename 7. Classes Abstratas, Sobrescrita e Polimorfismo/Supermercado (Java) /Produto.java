import java.util.Locale;

public abstract class Produto {
    protected String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public abstract double custo();

    public abstract double entrada();

    public String get_nome() {
        return this.nome;
    }

    public double lucro() {
        return this.entrada() - this.custo();
    }

    public int maior_custo(Produto p) {
        if (p.custo() > this.custo()) {
            return 1;
        }
        return 0;
    }

    public int maior_entrada(Produto p) {
        if (p.entrada() > this.entrada()) {
            return 1;
        }
        return 0;
    }

    public int maior_lucro(Produto p) {
        if (p.lucro() > this.lucro()) {
            return 1;
        }
        return 0;
    }

    public int menor_lucro(Produto p) {
        if (p.lucro() < this.lucro()) {
            return 1;
        }
        return 0;
    }

    public void print_produto() {
        System.out.printf(Locale.US,"%s: Receita=%.2f, Custo=%.2f, Lucro=%.2f\n", this.nome, this.entrada(), this.custo(),
                this.lucro());
    }
}