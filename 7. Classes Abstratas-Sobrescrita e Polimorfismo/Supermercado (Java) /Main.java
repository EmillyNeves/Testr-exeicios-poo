import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Supermercado s = new Supermercado(num);
        
        s.le_produtos(sc);
        s.imprime_relatorio();

        sc.close();
    }
}