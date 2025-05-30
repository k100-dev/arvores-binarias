public class No {
    private final String valor;
    private No esquerdo;
    private No direito;

    public No(String valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }

    public String getValor() {
        return valor;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }
}
