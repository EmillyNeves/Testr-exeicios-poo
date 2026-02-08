import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Investimento> investimentos = new ArrayList<>();

        int num = sc.nextInt();
        
        for (int i = 0; i < num; i++) {
            String tipo = sc.next();
            String investimento = sc.next();
            double valor_inicial = sc.nextDouble();

            if (tipo.equals("Acoes")) {
                double variacao_acumulada = sc.nextDouble();
                investimentos.add(new Acoes(investimento, valor_inicial, variacao_acumulada));

            } else if (tipo.equals("RendaFixa")) {
                int duracao_meses = sc.nextInt();
                double taxa_lucro = sc.nextDouble();
                investimentos.add(new RendaFixa(investimento, valor_inicial, duracao_meses, taxa_lucro));

            } else if (tipo.equals("Imovel")) {
                double area = sc.nextDouble();
                double valorizacao = sc.nextDouble();
                double aluguel = sc.nextDouble();
                int meses = sc.nextInt();
                investimentos.add(new Imovel(investimento, valor_inicial, area, valorizacao, aluguel, meses));
            }
        }

        double soma_retornos = 0;
        double maior_retorno = 0;
        String nome_maior_retorno = "";

        for (Investimento inv : investimentos) {
            double retorno = inv.retorno();
            System.out.printf("%s %.2f\n", inv.getNome(), retorno);
            
            soma_retornos += retorno;
            
            if (retorno > maior_retorno) {
                maior_retorno = retorno;
                nome_maior_retorno = inv.getNome();
            }
        }

        System.out.printf("%.2f\n", soma_retornos);
        System.out.println(nome_maior_retorno);

        sc.close();
    }
}
