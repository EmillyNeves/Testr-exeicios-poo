import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // cliente
        String nome = scanner.nextLine();
        String email = scanner.nextLine();
        String telefone = scanner.nextLine();
        double distancia = scanner.nextDouble();
        Cliente cliente = new Cliente(nome, email, telefone, distancia);
        int qtdItens = scanner.nextInt();
        scanner.nextLine();

        // carrinho e add produtos
        Carrinho carrinho = new Carrinho();
        for (int i = 0; i < qtdItens; i++) {
            String nomeProduto = scanner.next();
            double valorProduto = scanner.nextDouble();
            Produto produto = new Produto(nomeProduto, valorProduto);
            carrinho.add(produto);
        }
        scanner.nextLine();

        // tipo entrega
        String tipoEntrega = scanner.nextLine();
        MeioEntrega entrega = null;
        switch (tipoEntrega.toUpperCase()) {
            case "PAC":
                entrega = new Pac();
                break;
            case "SEDEX":
                entrega = new Sedex();
                break;
            case "SEDEX10":
                entrega = new Sedex10();
                break;
        }
        // metodo de pagamento
        String metodoPagamento = scanner.nextLine();
        MetodoPagamento pagamento = null;
        switch (metodoPagamento.toUpperCase()) {
            case "PIX":
                pagamento = new Pix();
                break;
            case "CARTAO":
                pagamento = new Cartao();
                break;
            case "CARNE":
                pagamento = new Carne();
                break;
        }

        // compra
        Compra compra = new Compra(carrinho, cliente);
        compra.setMeioEntrega(entrega);
        compra.setMetodoPagamento(pagamento);

        // notificadores
        compra.addNotificador(new Email());
        compra.addNotificador(new Sms("pop-up"));
        compra.addNotificador(new Sms("sms"));

        // finaliza a compra
        compra.finaliza();

        scanner.close();
    }
}