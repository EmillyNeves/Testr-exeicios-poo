import java.util.*;

public class Paciente implements Comparable<Paciente> {
    private String _nome;
    private String _cpf;
    private int _senha;
    private int _prioridade;
    private ProvedorSaude _provedorSaude;
    private Enfermeiro _enfermeiro;
    private List<Atendimento> _hist_paciente;

    public Paciente(String nome, String cpf, int senha, int prioridade, ProvedorSaude provedor, Enfermeiro enfermeiro) {
        this._nome = nome;
        this._cpf = cpf;
        this._senha = senha;
        this._prioridade = prioridade;
        this._provedorSaude = provedor;
        this._enfermeiro = enfermeiro;
        this._hist_paciente = new ArrayList<>();
    }

    public void addProntuario(Atendimento a) {
        this._hist_paciente.add(a);
    }

    @Override
    public int compareTo(Paciente paciente) {
        if (this._prioridade != paciente._prioridade) {
            return Integer.compare(this._prioridade, paciente._prioridade);
        }
        return Integer.compare(this._senha, paciente._senha);
    }

    public String getNome() {
        return _nome;
    }

    public ProvedorSaude getProvedor() {
        return _provedorSaude;
    }

    public Enfermeiro getEnfermeiro() {
        return _enfermeiro;
    }
}
