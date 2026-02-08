public class PlanoPremium implements ProvedorSaude {
    
    @Override
    public String getTipo() {
        return "PREMIUM";
    }
    @Override
    public double pagamentoHospital(double valorProntuario) {
        return valorProntuario * 1.2;
    }

    @Override
    public double pagamentoPaciente(double valorProntuario) {
        return 2500;
    }

}
