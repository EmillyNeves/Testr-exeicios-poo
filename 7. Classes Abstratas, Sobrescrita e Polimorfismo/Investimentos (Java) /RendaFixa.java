public class RendaFixa extends Investimento {
    private int duracao_meses;
    private double taxa_lucro;

    public RendaFixa(String nome, double valor_inicial, int duracao_meses, double taxa_lucro) {
        super(nome, valor_inicial);
        this.duracao_meses = duracao_meses;
        this.taxa_lucro = taxa_lucro;
    }

    public int getDuracao(){
        return this.duracao_meses;
    }

    public double getTaxa(){
        return this.taxa_lucro;
    }

    // retorno = investimento inicial + lucros (valor final)
    @Override
    public double retorno(){
        return valor_inicial * Math.pow(1 + taxa_lucro, duracao_meses);
    }
}
