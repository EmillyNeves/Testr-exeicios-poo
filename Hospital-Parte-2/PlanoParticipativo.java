public class PlanoParticipativo implements ProvedorSaude {
    @Override
    public String getTipo() {
        return "PARTICIPATIVO";
    }
    
    @Override
    public double pagamentoHospital(double val_prontuario) {
        return val_prontuario * 1.5;
    }

    @Override
    public double pagamentoPaciente(double val_prontuario) {
        return 750 + (val_prontuario * 0.1);
    }

}
