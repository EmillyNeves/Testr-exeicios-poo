import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int num = sc.nextInt();
        ArrayList<Transporte> transportes = new ArrayList<>();

        String nome;
        double custoBase;
        double distanciaPercorrida;
        double precoGasolinaPorKm;
        int numeroPassageiros;
        double precoPassagem;
        double horasUtilizadas;
        double precoPorHora;
        double precoManutencao;
        double taxaDesvalorizacao;
        Transporte maior_lucro;
        Transporte menor_lucro;

        for (int i = 0; i < num; i++) {
            nome = sc.next();
            custoBase = sc.nextDouble();

            if (nome.equals("Onibus")) {
                distanciaPercorrida = sc.nextDouble();
                precoGasolinaPorKm = sc.nextDouble();
                numeroPassageiros = sc.nextInt();
                precoPassagem = sc.nextDouble();
                transportes.add(
                        new Onibus(nome, custoBase, distanciaPercorrida, precoGasolinaPorKm, numeroPassageiros,
                                precoPassagem));

            } else if (nome.equals("Metro")) {
                numeroPassageiros = sc.nextInt();
                precoPassagem = sc.nextDouble();
                transportes.add(new Metro(nome, custoBase, numeroPassageiros, precoPassagem));

            } else if (nome.equals("Bicicleta")) {
                horasUtilizadas = sc.nextDouble();
                precoPorHora = sc.nextDouble();
                precoManutencao = sc.nextDouble();
                transportes.add(new BicicletaCompartilhada(nome, custoBase, horasUtilizadas, precoPorHora,
                        precoManutencao));

            } else if (nome.equals("Carro")) {
                taxaDesvalorizacao = sc.nextDouble();
                distanciaPercorrida = sc.nextDouble();
                precoGasolinaPorKm = sc.nextDouble();
                precoManutencao = sc.nextDouble();

                transportes.add(new Carro(nome, custoBase, taxaDesvalorizacao, distanciaPercorrida, precoGasolinaPorKm,
                        precoManutencao));
            }
        }
        sc.close();

        maior_lucro = transportes.get(transportes.size() - 1);
        menor_lucro = transportes.get(transportes.size() - 1);

        for (Transporte transporte : transportes) {
            transporte.imprime();
            if (maior_lucro.verifica_lucro(transporte) == 1) {
                maior_lucro = transporte;
            } else if (menor_lucro.verifica_lucro(transporte) == -1) {
                menor_lucro = transporte;
            }
        }
    }

}

/*
 * Na main, leia n e depois n linhas, podendo ser:
 * 
 * Onibus
 * Metro
 * Bicicleta
 * Carro
 * 
 * Armazene tudo num ArrayList/vector.
 * 
 * Exiba:
 * 
 * nome e lucratividade de cada transporte
 * o transporte mais lucrativo
 * o transporte menos lucrativo
 */