public class No {
    private final String valor;
    private No esquerdo;
    private No direito;
    private int altura;

    public No(String valor) {
        this.valor = valor;
        this.altura = 1; // importante para AVL
    }

    public String getValor() {
        return valor;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
