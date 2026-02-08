import java.util.*;

public class Hospital {
    private Map<String, Medicacao> lista_medicacao;
    private Map<String, Exame> lista_exames;
    private PriorityQueue<Paciente> fila_pacientes;
    private List<Medico> medicos;
    private Map<String, Enfermeiro> enfermeiros;
    private Map<String, Farmaceutico> farmaceuticos;
    private List<Funcionario> funcionarios;
    private List<Atendimento> historico_atend;
    private double valores_recebidos;
    private double valores_gastos;
    private int medico_atendendo;

    public Hospital() {
        this.lista_medicacao = new HashMap<>();
        this.medicos = new ArrayList<>();
        this.medico_atendendo = 0;
        this.enfermeiros = new HashMap<>();
        this.farmaceuticos = new HashMap<>();
        this.funcionarios = new ArrayList<>();
        this.historico_atend = new ArrayList<>();
        this.fila_pacientes = new PriorityQueue<>();
        this.lista_exames = new HashMap<>();
        this.valores_recebidos = 0;
        this.valores_gastos = 0;
    }

    public void cadastrarMedicacao(String nome, double custo) {
        lista_medicacao.put(nome, new Medicacao(nome, custo, 999));
    }

    public void cadastrarExame(String nome, double custo) {
        lista_exames.put(nome, new Exame(nome, custo));
    }

    public void cadastrarFuncionario(String cargo, String nome, String cpf, Integer consultorio) {
        if (cargo.equals("MEDICO")) {
            Medico medico = new Medico(nome, cpf, consultorio);
            medicos.add(medico);
            funcionarios.add(medico);
        } else if (cargo.equals("ENFERMEIRO")) {
            Enfermeiro enfermeiro = new Enfermeiro(nome, cpf);
            enfermeiros.put(nome, enfermeiro);
            funcionarios.add(enfermeiro);
        } else if (cargo.equals("FARMACEUTICO")) {
            Farmaceutico farmaceutico = new Farmaceutico(nome, cpf);
            farmaceuticos.put(nome, farmaceutico);
            funcionarios.add(farmaceutico);
        }
    }

    public void cadastrarPacientes(String nome, String cpf, String tipoProvedor, String nomeEnfermeiro) {
        int senha = fila_pacientes.size() + historico_atend.size() + 1;

        ProvedorSaude provedor;
        if (tipoProvedor.equals("SUS")) {
            provedor = new SUS();
        } else if (tipoProvedor.equals("PARTICIPATIVO")) {
            provedor = new PlanoParticipativo();
        } else {
            provedor = new PlanoPremium();
        }

        Enfermeiro enfermeiro = enfermeiros.get(nomeEnfermeiro);

        fila_pacientes.add(new Paciente(nome, cpf, senha, 1, provedor, enfermeiro));
    }

    private Medico proxMedico() {
        if (medicos.isEmpty())
            return null;
        Medico m = medicos.get(medico_atendendo);
        medico_atendendo = (medico_atendendo + 1) % medicos.size();
        return m;
    }

    public void realizarAtendimento(String sintomas, List<String> exames_paciente, String cid,
            String nomeFarmaceutico, Map<String, Integer> lista_remedios) {

        Paciente paciente = fila_pacientes.poll();
        Medico medico = proxMedico();

        if (paciente == null || medico == null)
            return;

        Farmaceutico farmaceutico = farmaceuticos.get(nomeFarmaceutico);
        Enfermeiro enfermeiro = paciente.getEnfermeiro();

        Atendimento atendimento = new Atendimento(paciente, medico, sintomas, cid, farmaceutico);

        // add exames
        for (String exame : exames_paciente) {
            if (lista_exames.containsKey(exame)) {
                Exame ex = lista_exames.get(exame);
                atendimento.adicionarExame(ex);
                this.valores_gastos += ex.getCusto();
            }
        }

        // add medicacao
        for (Map.Entry<String, Integer> entry : lista_remedios.entrySet()) {
            String remedio = entry.getKey();
            int qtd = entry.getValue();

            if (lista_medicacao.containsKey(remedio)) {
                Medicacao med = lista_medicacao.get(remedio);
                if (med.subEstoque(qtd)) {
                    atendimento.adicionarMedicacao(med, qtd);
                    this.valores_gastos += (med.getCusto() * qtd);
                }
            }
        }

        // val atendimento
        atendimento.calcularValores();

        // pagamentos hosp
        this.valores_recebidos += atendimento.getValorPagoHospital();

        // pagamentos func
        medico.adicionaPagamento();
        enfermeiro.adicionaPagamento();
        farmaceutico.adicionaPagamento();

        historico_atend.add(atendimento);
        paciente.addProntuario(atendimento);
    }

    public void printAuditoria() {
        for (Atendimento a : historico_atend) {
            // triagem
            System.out.printf("%s fez triagem com %s\n",
                    a.getPaciente().getNome(), a.getPaciente().getEnfermeiro().getNome());

            // atendimento
            System.out.printf("%s foi atendido por %s no consultorio %d\n",
                    a.getPaciente().getNome(), a.getMedico().getNome(), a.getMedico().getConsultorio());

            // exames
            for (Exame ex : a.getExamesRealizados()) {
                System.out.printf("%s realizou %s\n", a.getPaciente().getNome(), ex.getNome());
            }

            System.out.printf("Diagnostico: %s\n", a.getCid());

            // medcacao
            for (Map.Entry<Medicacao, Integer> entry : a.getMedPrescritas().entrySet()) {
                System.out.printf("%s liberou %d doses de %s\n",
                        a.getFarmaceutico().getNome(), entry.getValue(), entry.getKey().getNome());
                System.out.printf("%s aplicou %d doses de %s em %s\n",
                        a.getPaciente().getEnfermeiro().getNome(), entry.getValue(),
                        entry.getKey().getNome(), a.getPaciente().getNome());
            }

            // pagamentos
            System.out.printf("%s pagou %.2f\n", a.getPaciente().getNome(), a.getValorCobradoPaciente());
            System.out.printf("Hospital recebeu %.2f\n", a.getValorPagoHospital());
            System.out.printf("%s recebeu alta\n", a.getPaciente().getNome());
        }
    }

    public void printRelatorio() {
        // custo com func
        for (Funcionario f : funcionarios) {
            valores_gastos += f.getTotalRecebido();
        }

        // salarios
        for (Funcionario f : funcionarios) {
            System.out.printf("%s: %.2f\n", f.getNome(), f.getTotalRecebido());
        }

        // val totais
        System.out.printf("VALORES RECEBIDOS: %.2f\n", this.valores_recebidos);
        System.out.printf("VALORES GASTOS: %.2f\n", this.valores_gastos);
    }

    public int PacientesFila() {
        if (fila_pacientes.isEmpty())
            return 0;
        return 1;
    }
}