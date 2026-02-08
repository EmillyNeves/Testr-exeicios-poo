public class Fibonacci implements Generator<Integer> {
    private double quantidade_desejada;
    private double quantidade_produzida;
    private int penultimo;
    private int ultimo;

    public Fibonacci(double quantidade) {
        this.quantidade_desejada = quantidade;
        reset();
    }

    @Override
    public void reset() {
        this.quantidade_produzida = 0;
        this.penultimo = 1;
        this.ultimo = 1;
    }

    @Override
    public boolean is_over() {
        return quantidade_produzida >= quantidade_desejada;
    }

    @Override
    public Integer next() {
        int resultado;
        
        if (quantidade_produzida == 0 || 
            quantidade_produzida == 1) {
            resultado = 1;
        } else {
            resultado = penultimo + ultimo;
            penultimo = ultimo;
            ultimo = resultado;
        }
        
        quantidade_produzida++;
        return resultado;
    }
}