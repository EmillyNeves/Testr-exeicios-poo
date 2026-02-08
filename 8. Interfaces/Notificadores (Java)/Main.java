import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Notifier> notificacoes = new ArrayList<>();

        while (true) {
            notificacoes.add(new NotifierSMS());
            notificacoes.add(new NotifierEmail());
            notificacoes.add(new NotifierPopUp());
            notificacoes.add(new NotifierAplicativo());
            break;
        }

        String nome = sc.nextLine();
        String email = sc.nextLine();
        String telefone = sc.nextLine();
        String mensagem = sc.nextLine();

        User u = new User(nome, email, telefone);

        for (Notifier notifier : notificacoes) {
            notifier.notify(u, mensagem);
        }
        sc.close();
    }
}
