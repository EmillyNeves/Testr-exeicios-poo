public class NotifierEmail implements Notifier {
    @Override
    public void notify(User user, String message) {
        System.out.printf("enviando e-mail para %s: '%s'.\n", user.get_email(), message);
    }
}
