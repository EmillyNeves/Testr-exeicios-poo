import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String tipoFrete = sc.nextLine();

        FreteStrategy estrategiaFrete = null;

        switch (tipoFrete) {
            case "FretePadrao":
                estrategiaFrete = new FretePadrao();
                break;
            case "FreteExpresso":
                estrategiaFrete = new FreteExpresso();
                break;
            case "RetiradaNaLoja":
                estrategiaFrete = new RetiradaNaLoja();
                break;
            case "FreteTransportadora":
                estrategiaFrete = new FreteTransportadora();
                break;
        }
        double valor = sc.nextDouble();
        double peso = sc.nextDouble();
        double distanciaEmKm = sc.nextDouble();

        Carrinho c = new Carrinho(valor, peso, 
            distanciaEmKm, estrategiaFrete);

        System.out.printf(Locale.US, "%.2f\n", 
        c.calcularTotalCompra());

        sc.close();
    }

}