import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> listaProdutos = new ArrayList<>();

        if (sc.hasNextInt()) {
            int num = sc.nextInt();

            for (int i = 0; i < num; i++) {
                String nome = sc.next();
                double preco = sc.nextDouble();
                listaProdutos.add(new Product(nome, preco));
            }

            Collections.sort(listaProdutos);

            for (Product p : listaProdutos) {
                System.out.printf(Locale.US, 
                    "%s %.2f\n", p.get_nome(), p.get_preco());
            }
        }

        sc.close();
    }
}
