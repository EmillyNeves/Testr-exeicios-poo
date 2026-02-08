public interface ProvedorSaude {
    String getTipo();
    double pagamentoHospital(double valorProntuario);
    double pagamentoPaciente(double valorProntuario);
}
