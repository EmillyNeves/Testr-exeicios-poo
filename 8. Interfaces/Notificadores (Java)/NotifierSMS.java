public class NotifierSMS implements Notifier{
    @Override
    public void notify(User user, String message) {
        System.out.printf("enviando SMS para %s: '%s'.\n", user.get_telefone(), message);
    }
}
