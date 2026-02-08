public class SUS implements ProvedorSaude {
    
    @Override
    public String getTipo() {
        return "SUS";
    }
    @Override
    public double pagamentoHospital(double valorProntuario) {
        return valorProntuario * 2.0;
    }

    @Override
    public double pagamentoPaciente(double valorProntuario) {
        return 0;
    }

}
