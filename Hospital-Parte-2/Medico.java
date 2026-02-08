public class Medico extends Funcionario {
    private int _consultorio;

    public Medico(String nome, String cpf, int consultorio) {
        super(nome, cpf);
        this._consultorio = consultorio;
    }

    @Override
    public void adicionaPagamento() {
        this._total_recebido += 100;
    }

    public int getConsultorio() {
        return _consultorio;
    }
}

