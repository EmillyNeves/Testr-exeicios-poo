public class Imovel extends Investimento {
    private double area;
    private double valorizacao;
    private double aluguel;
    private int meses;

    public Imovel(String nome, double valor_inicial, double area, double valorizacao, double aluguel, int meses) {
        super(nome, valor_inicial);
        this.area = area;
        this.valorizacao = valorizacao;
        this.aluguel = aluguel;
        this.meses = meses;
    }

    public double getArea() {
        return this.area;
    }

    public double getValorizacao() {
        return this.valorizacao;
    }

    public double getAluguel() {
        return this.aluguel;
    }

    public int getMeses() {
        return this.meses;
    }

    @Override
    public double retorno() {
        // valor inicial
        double valor_m2_inicial = valor_inicial / area;
        // valor valorizacão (juros compostos)
        double valor_m2_final = valor_m2_inicial * Math.pow(1 + valorizacao, meses);
        // valor total apos valorizacão
        double valor_imovel_final = valor_m2_final * area;
        // ganho aluguel
        double ganho_alugueis = aluguel * meses;
        // retorno = valor final do imovel + aluguel - custo inicial
        return (valor_imovel_final + ganho_alugueis) - valor_inicial;
    }
}
