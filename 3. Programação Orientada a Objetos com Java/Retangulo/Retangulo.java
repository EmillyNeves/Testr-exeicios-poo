public class Retangulo {
    private int altura;
    private int largura;

    public Retangulo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public int area() {
        return (this.altura * this.largura);
    }

    public int perimetro() {
        return ((this.altura * 2) + (this.largura * 2));
    }

    public int getAltura() {
        return this.altura;
    }

    public int getLargura() {
        return this.largura;
    }

}
