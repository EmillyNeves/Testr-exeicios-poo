public class Farmaceutico extends Funcionario {
    private static final double SALARIO_FIXO = 150;

    public Farmaceutico(String nome, String cpf) {
        super(nome, cpf);
        this._total_recebido = SALARIO_FIXO;
    }

    @Override
    public void adicionaPagamento() {
    }
}