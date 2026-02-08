import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tipo = scanner.next();
        
        // tipo generator com wildcard
        Generator<?> gen = null;
        
        if (tipo.equals("Range")) {
            double inicio = scanner.nextDouble();
            double fim = scanner.nextDouble();
            double passo = scanner.nextDouble();
            gen = new Range(inicio, fim, passo);
        } else if (tipo.equals("Fibonacci")) {
            double quantidade = scanner.nextDouble();
            gen = new Fibonacci(quantidade);
        } else if (tipo.equals("Permutations")) {
            int tamanho = (int) scanner.nextDouble();
            gen = new Permutations(tamanho);
        }
        
        // todos os itens
        if (gen != null) {
            boolean formatar_numeros_como_double = tipo.equals("Range");
            while (!gen.is_over()) {
                Object item = gen.next();
                
                // toString() com amarra tardia
                if (item instanceof int[]) {
                    // formata como lista de num
                    int[] arr = (int[]) item;
                    System.out.print("[");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                        if (i < arr.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                } else if (formatar_numeros_como_double && item instanceof Number) {
                    System.out.println(((Number) item).doubleValue());
                } else {
                    System.out.println(item);
                }
            }
        }
        
        scanner.close();
    }
}
