import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        // cad medicacao
        int qtdMed = sc.nextInt();
        for (int i = 0; i < qtdMed; i++) {
            hospital.cadastrarMedicacao(sc.next(), sc.nextDouble());
        }

        // cad exames
        int qtdEx = sc.nextInt();
        for (int i = 0; i < qtdEx; i++) {
            hospital.cadastrarExame(sc.next(), sc.nextDouble());
        }

        // cad func
        int qtdFunc = sc.nextInt();
        for (int i = 0; i < qtdFunc; i++) {
            String cargo = sc.next();
            String nome = sc.next();
            String cpf = sc.next();

            if (cargo.equals("MEDICO")) {
                int consultorio = sc.nextInt();
                hospital.cadastrarFuncionario(cargo, nome, cpf, consultorio);
            } else {
                hospital.cadastrarFuncionario(cargo, nome, cpf, null);
            }
        }

        // cad pacientes
        int qtdP = sc.nextInt();
        for (int i = 0; i < qtdP; i++) {
            String nome = sc.next();
            String cpf = sc.next();
            String provedor = sc.next();
            String nomeEnfermeiro = sc.next();
            hospital.cadastrarPacientes(nome, cpf, provedor, nomeEnfermeiro);
        }

        // atendimentos
        while (hospital.PacientesFila() != 0) {
            String sintomas = sc.next();

            int numExames = sc.nextInt();
            List<String> exames_pedidos = new ArrayList<>();
            for (int j = 0; j < numExames; j++) {
                exames_pedidos.add(sc.next());
            }

            String cid = sc.next();
            String nomeFarmaceutico = sc.next();
            int numMeds = sc.nextInt();

            Map<String, Integer> prescricoes = new LinkedHashMap<>();
            for (int j = 0; j < numMeds; j++) {
                prescricoes.put(sc.next(), sc.nextInt());
            }

            hospital.realizarAtendimento(sintomas, exames_pedidos, cid, nomeFarmaceutico, prescricoes);
        }

        // relatorios
        hospital.printAuditoria();
        hospital.printRelatorio();

        sc.close();
    }
}
