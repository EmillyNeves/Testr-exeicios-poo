import java.util.Locale;

public abstract class Transporte {
    protected double custoBase;

    public Transporte(double custoBase) {
        this.custoBase = custoBase;
    }

    public abstract String nome();

    public abstract double lucratividade();

    public void imprime() {
        System.out.printf(Locale.US, "%s %.2f\n", this.nome(), this.lucratividade());
    }

    public int verifica_lucro(Transporte t) {
        if (t.lucratividade() < this.lucratividade()) {
            return -1; //menor lucro
        }
        if (t.lucratividade() > this.lucratividade())
            return 1; // maior lucro
        return 0;
    }
}