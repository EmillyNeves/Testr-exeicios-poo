import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int altura = sc.nextInt();
        int largura = sc.nextInt();

        Retangulo r = new Retangulo(altura, largura);

        System.out.printf("%d\n", r.getAltura());
        System.out.printf("%d\n", r.getLargura());
        System.out.printf("%d\n", r.area());
        System.out.printf("%d\n", r.perimetro());

        sc.close();
    }
}
