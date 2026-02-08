import java.util.*;

public class Atendimento {
    private Paciente _paciente;
    private Medico _medico;
    private String _sintomas;
    private String _cid;
    private List<Exame> _examesRealizados;
    private Map<Medicacao, Integer> _medicacoesPrescritas;
    private Farmaceutico _farmaceutico;
    private double _valorProntuario;
    private double _valorPagoHospital;
    private double _valorCobradoPaciente;

    public Atendimento(Paciente paciente, Medico medico, String sintomas, String cid, Farmaceutico farmaceutico) {
        this._paciente = paciente;
        this._medico = medico;
        this._sintomas = sintomas;
        this._cid = cid;
        this._farmaceutico = farmaceutico;
        this._examesRealizados = new ArrayList<>();
        this._medicacoesPrescritas = new LinkedHashMap<>();
        this._valorProntuario = 0;
        this._valorPagoHospital = 0;
        this._valorCobradoPaciente = 0;
    }

    public void adicionarExame(Exame exame) {
        this._examesRealizados.add(exame);
        this._valorProntuario += exame.getCusto();
    }

    public void adicionarMedicacao(Medicacao medicacao, int quantidade) {
        this._medicacoesPrescritas.put(medicacao, quantidade);
        this._valorProntuario += (medicacao.getCusto() * quantidade);
    }

    public void calcularValores() {
        this._valorProntuario += 120; //enf + med
        
        ProvedorSaude provedor = _paciente.getProvedor();
        this._valorPagoHospital = provedor.pagamentoHospital(_valorProntuario);
        this._valorCobradoPaciente = provedor.pagamentoPaciente(_valorProntuario);
    }

    public Paciente getPaciente() {
        return _paciente;
    }

    public Medico getMedico() {
        return _medico;
    }

    public String getCid() {
        return _cid;
    }

    public List<Exame> getExamesRealizados() {
        return _examesRealizados;
    }

    public Map<Medicacao, Integer> getMedPrescritas() {
        return _medicacoesPrescritas;
    }

    public Farmaceutico getFarmaceutico() {
        return _farmaceutico;
    }

    public double getValorPagoHospital() {
        return _valorPagoHospital;
    }

    public double getValorCobradoPaciente() {
        return _valorCobradoPaciente;
    }
}
