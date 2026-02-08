import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String autor = sc.next();
        String conteudo = sc.next();

        Post p = new Post(autor, conteudo);

        int interacoes = sc.nextInt();

        for (int i = 0; i < interacoes; i++) {
            int acao = sc.nextInt();

            if (acao == 0) {
                p.dislike();
            } else {
                p.like();
            }
        }

        System.out.printf("%s\n", p.get_conteudo());
        System.out.printf("%s\n", p.get_autor());
        System.out.printf("%d\n", p.n_likes());
        System.out.printf("%d\n", p.n_dislikes());
        System.out.printf("%d\n", p.sentimento());

        sc.close();
    }
}
