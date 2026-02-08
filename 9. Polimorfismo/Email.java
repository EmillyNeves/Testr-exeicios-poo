public class Email implements Notificador {

    @Override
    public void notificar(Cliente cliente, Compra compra) {
        System.out.println("Notificacao e-mail para " + cliente.get_email() +
                ": Compra realizada por " + cliente.get_nome() +
                " no valor de " + compra.getValorFinal() +
                " e entrega em ate " + compra.getPrazoEntrega() + " dias.");
    }
}