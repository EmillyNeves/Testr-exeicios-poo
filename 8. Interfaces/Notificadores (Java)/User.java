public class User {
    private String _nome;
    private String _email;
    private String _telefone;

    public User(String nome, String email, String telefone) {
        this._nome = nome;
        this._email = email;
        this._telefone = telefone;
    }

    public String get_nome(){
        return this._nome;
    }

    public String get_email(){
        return this._email;
    }

    public String get_telefone(){
        return this._telefone;
    }
}
