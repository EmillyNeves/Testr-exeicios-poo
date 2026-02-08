public class Sms implements Notificador {
    private String _tipo;

    public Sms(String tipo) {
        this._tipo = tipo;
    }

    @Override
    public void notificar(Cliente cliente, Compra compra) {
        System.out.println("Notificacao " + _tipo + " para " + cliente.get_telefone() +
                ": Compra realizada por " + cliente.get_nome() +
                " no valor de " + compra.getValorFinal() +
                " e entrega em ate " + compra.getPrazoEntrega() + " dias.");
    }
}