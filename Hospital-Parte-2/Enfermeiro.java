public class Enfermeiro extends Funcionario {
    private static final double SALARIO = 90;
    private static final double VALOR_POR_PACIENTE = 20;

    public Enfermeiro(String nome, String cpf) {
        super(nome, cpf);
        this._total_recebido += SALARIO;
    }

    @Override
    public void adicionaPagamento() {
        this._total_recebido += VALOR_POR_PACIENTE;
    }
}