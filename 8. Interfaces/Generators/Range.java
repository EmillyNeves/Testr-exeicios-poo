public class Range implements Generator<Double> {
    private double valor_inicial;
    private double valor_final;
    private double passo;
    private double valor_atual;

    public Range(double inicio, double fim, double passo) {
        this.valor_inicial = inicio;
        this.valor_final = fim;
        this.passo = passo;
        reset();
    }

    @Override
    public void reset() {
        this.valor_atual = this.valor_inicial;
    }

    @Override
    public boolean is_over() {
        if (passo > 0) {
            return valor_atual >= valor_final;
        } else if (passo < 0) {
            return valor_atual <= valor_final;
        }
        return true;
    }

    @Override
    public Double next() {
        double resultado = valor_atual;
        valor_atual += passo;
        return resultado;
    }
}