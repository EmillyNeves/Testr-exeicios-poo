import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        int qtd_op;
        String op;
        Scanner sc = new Scanner(System.in);
        qtd_op = sc.nextInt();

        for (int i = 0; i < qtd_op; i++) {
            int num;
            op = sc.next();
            if (op.equals("INSERIR")) {
                num = sc.nextInt();
                numeros.add(num);
            } else if (op.equals("REMOVER")) {
                if (!numeros.isEmpty()) { 
                    System.out.println(numeros.get(numeros.size() - 1));
                    numeros.remove(numeros.size() - 1);
                }
            } else if (op.equals("VER")) {
                num = sc.nextInt();
                if (num >= 0 && num < numeros.size()) {
                    System.out.println(numeros.get(num));
                }
            } else if (op.equals("MOSTRAR")) {
                for (int n : numeros) {
                    System.out.println(n);
                }
            } else if (op.equals("TAMANHO")) {
                System.out.println(numeros.size());
            } else if (op.equals("ORDENAR")) {
                Collections.sort(numeros);
            } else if (op.equals("BUSCAR")) {
                num = sc.nextInt();
                System.out.println(numeros.indexOf(num));
            }
        }
        sc.close();
    }
}