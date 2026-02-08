public class NotifierPopUp implements Notifier {
    @Override
    public void notify(User user, String message) {
        System.out.printf("enviando pop-up para %s: '%s'.\n", user.get_telefone(), message);
    }
}
