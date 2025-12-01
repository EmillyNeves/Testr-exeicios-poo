import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Sistema sistema = new Sistema();
        
        while (true) {
            String comando = scanner.next();
            
            if (comando.equals("ENCERRAR")) {
                break;
            }
            
            switch (comando) {
                case "REGISTRAR_PRODUTO":
                    String nomeProduto = scanner.next();
                    double preco = scanner.nextDouble();
                    sistema.registrarProduto(nomeProduto, preco);
                    break;
                    
                case "REGISTRAR_CLIENTE":
                    String nomeCliente = scanner.next();
                    String cpf = scanner.next();
                    sistema.registrarCliente(nomeCliente, cpf);
                    break;
                    
                case "ADQUIRIR_PRODUTO":
                    String nomeProdutoAdq = scanner.next();
                    int quantidade = scanner.nextInt();
                    sistema.adquirirProduto(nomeProdutoAdq, quantidade);
                    break;
                    
                case "INICIAR_COMPRA":
                    String cpfCompra = scanner.next();
                    sistema.iniciarCompra(cpfCompra);
                    break;
                    
                case "ADD_ITEM":
                    String nomeProdutoItem = scanner.next();
                    int qtdItem = scanner.nextInt();
                    sistema.addItem(nomeProdutoItem, qtdItem);
                    break;
                    
                case "FINALIZAR_COMPRA":
                    sistema.finalizarCompra();
                    break;
                    
                case "REVENUE":
                    sistema.revenue();
                    break;
                    
                case "MAIS_VENDIDO":
                    sistema.maisVendido();
                    break;
                    
                case "MELHOR_CLIENTE":
                    sistema.melhorCliente();
                    break;
                    
                case "EM_FALTA":
                    sistema.emFalta();
                    break;
            }
        }
        
        scanner.close();
    }
}