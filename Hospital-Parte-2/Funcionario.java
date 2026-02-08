public abstract class Funcionario {
    protected String _nome;
    protected String _cpf;
    protected double _total_recebido;

    public Funcionario(String nome, String cpf) {
        this._total_recebido = 0;
        this._nome = nome;
        this._cpf = cpf;
    }

    public abstract void adicionaPagamento();

    public String getNome() {
        return _nome;
    }

    public String getCpf() {
        return _cpf;
    }

    public double getTotalRecebido() {
        return _total_recebido;
    }
}
