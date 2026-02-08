public class Cliente {
    private String _nome;
    private String _email;
    private String _telefone;
    private double _dist_entrega;

    public Cliente(String nome, String email, String telefone, double dist_entrega) {
        this._nome = nome;
        this._email = email;
        this._telefone = telefone;
        this._dist_entrega = dist_entrega;
    }

    public String get_nome() {
        return _nome;
    }

    public String get_email() {
        return _email;
    }

    public String get_telefone() {
        return _telefone;
    }

    public double get_dist_entrega() {
        return _dist_entrega;
    }
}