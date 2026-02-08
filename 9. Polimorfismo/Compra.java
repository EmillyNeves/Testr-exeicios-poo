import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Compra {
    private Carrinho _carrinho;
    private Cliente _cliente;
    private ArrayList<Notificador> _notificadores;
    private MetodoPagamento _pgto;
    private MeioEntrega _entrega;
    private double _valorFinal;
    private int _prazoEntrega;
    private static DecimalFormat df;
    
    static {
        df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
    }

    public Compra(Carrinho carrinho, Cliente cliente) {
        this._carrinho = carrinho;
        this._cliente = cliente;
        this._notificadores = new ArrayList<>();
    }

    public void setMetodoPagamento(MetodoPagamento pgto) {
        this._pgto = pgto;
    }

    public void setMeioEntrega(MeioEntrega entrega) {
        this._entrega = entrega;
    }

    public void addNotificador(Notificador notificador) {
        this._notificadores.add(notificador);
    }

    public void finaliza() {
        double frete = _entrega.frete(_carrinho, _cliente.get_dist_entrega());
        double subtotal = _carrinho.total() + frete;
        double valorFinal;
        if (_pgto instanceof Pix) {
            valorFinal = subtotal * 0.9;
        } else if (_pgto instanceof Cartao) {
            valorFinal = subtotal;
        } else if (_pgto instanceof Carne) {
            valorFinal = subtotal * 1.2;
        } else {
            valorFinal = subtotal;
        }
        _valorFinal = valorFinal;
        _prazoEntrega = _entrega.prazo();
        
        // notifica cliente
        for (Notificador notificador : _notificadores) {
            notificador.notificar(_cliente, this);
        }
        
        // nota fiscal
        notaFiscal(frete, subtotal);
    }

    private void notaFiscal(double frete, double subtotal) {
        // lista produtos
        for (Produto p : _carrinho.getProdutos()) {
            System.out.println(p.getNome() + " " + df.format(p.getValor()));
        }
        System.out.println("soma dos itens: " + df.format(_carrinho.total()));
        System.out.println("frete: " + df.format(frete));
        System.out.println("total com frete: " + df.format(subtotal));
        System.out.println("valor total: " + df.format(_valorFinal));
    }

    public String getValorFinal() {
        return df.format(_valorFinal);
    }

    public int getPrazoEntrega() {
        return _prazoEntrega;
    }
}