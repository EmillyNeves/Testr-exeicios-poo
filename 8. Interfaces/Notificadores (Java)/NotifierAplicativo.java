public class NotifierAplicativo implements Notifier {

    @Override
    public void notify(User user, String message) {
        System.out.printf("enviando notificação no aplicativo instalado em %s: '%s'.\n", user.get_telefone(), message);
    }

}
