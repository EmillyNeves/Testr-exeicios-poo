public class Post {

    private String nome;
    private String titulo;
    private int likes;
    private int dislikes;

    public Post(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
        this.dislikes = 0;
        this.likes = 0;
    }

    public void like() {
        this.likes++;
    }

    public void dislike() {
        this.dislikes++;
    }

    public String get_autor() {
        return nome;
    }

    public String get_conteudo() {
        return titulo;
    }

    public int n_likes() {
        return likes;
    }

    public int n_dislikes() {
        return dislikes;
    }

    public int sentimento() {
        if (dislikes > likes)
            return 0;
        return 1;
    }
}
