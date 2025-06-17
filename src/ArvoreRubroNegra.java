    import java.util.Objects;

    public class ArvoreRubroNegra {

        enum Cor {
            VERMELHO, PRETO
        }

        static class NoRB {
            String valor;
            Cor cor;
            NoRB esquerdo, direito, pai;

            NoRB(String valor) {
                this.valor = valor;
                this.cor = Cor.VERMELHO;
            }
        }

        private NoRB raiz;

        public ArvoreRubroNegra() {
            this.raiz = null;
        }

        // Inserção do user
        public void inserir(String valor) {
            NoRB novo = new NoRB(valor);
            raiz = inserirRec(raiz, novo);
            corrigirInsercao(novo);
        }

        private NoRB inserirRec(NoRB atual, NoRB novo) {
            if (atual == null) return novo;

            if (novo.valor.compareTo(atual.valor) < 0) {
                atual.esquerdo = inserirRec(atual.esquerdo, novo);
                atual.esquerdo.pai = atual;
            } else {
                atual.direito = inserirRec(atual.direito, novo);
                atual.direito.pai = atual;
            }
            return atual;
        }

        private void corrigirInsercao(NoRB no) {
            while (no != raiz && no.pai.cor == Cor.VERMELHO) {
                NoRB avo = no.pai.pai;
                if (no.pai == avo.esquerdo) {
                    NoRB tio = avo.direito;
                    if (tio != null && tio.cor == Cor.VERMELHO) {
                        no.pai.cor = Cor.PRETO;
                        tio.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        no = avo;
                    } else {
                        if (no == no.pai.direito) {
                            no = no.pai;
                            rotacaoEsquerda(no);
                        }
                        no.pai.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        rotacaoDireita(avo);
                    }
                } else {
                    NoRB tio = avo.esquerdo;
                    if (tio != null && tio.cor == Cor.VERMELHO) {
                        no.pai.cor = Cor.PRETO;
                        tio.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        no = avo;
                    } else {
                        if (no == no.pai.esquerdo) {
                            no = no.pai;
                            rotacaoDireita(no);
                        }
                        no.pai.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        rotacaoEsquerda(avo);
                    }
                }
            }
            raiz.cor = Cor.PRETO;
        }

        public void remover(String valor) {
            NoRB no = buscar(raiz, valor);
            if (no == null) {
                System.out.println("Valor não encontrado!!");
                return;
            }
            removerNo(no);
        }

        private NoRB buscar(NoRB atual, String valor) {
            if (atual == null || Objects.equals(atual.valor, valor)) return atual;
            if (valor.compareTo(atual.valor) < 0) return buscar(atual.esquerdo, valor);
            else return buscar(atual.direito, valor);
        }

        private void removerNo(NoRB z) {
            NoRB y = z;
            Cor corOriginal = y.cor;
            NoRB x;

            if (z.esquerdo == null) {
                x = z.direito;
                transplantar(z, z.direito);
            } else if (z.direito == null) {
                x = z.esquerdo;
                transplantar(z, z.esquerdo);
            } else {
                y = minimo(z.direito);
                corOriginal = y.cor;
                x = y.direito;
                if (y.pai == z) {
                    if (x != null) x.pai = y;
                } else {
                    transplantar(y, y.direito);
                    y.direito = z.direito;
                    if (y.direito != null) y.direito.pai = y;
                }
                transplantar(z, y);
                y.esquerdo = z.esquerdo;
                if (y.esquerdo != null) y.esquerdo.pai = y;
                y.cor = z.cor;
            }

            if (corOriginal == Cor.PRETO && x != null) {
                corrigirRemocao(x);
            }
        }

        private void transplantar(NoRB u, NoRB v) {
            if (u.pai == null) {
                raiz = v;
            } else if (u == u.pai.esquerdo) {
                u.pai.esquerdo = v;
            } else {
                u.pai.direito = v;
            }
            if (v != null) v.pai = u.pai;
        }

        private NoRB minimo(NoRB no) {
            while (no.esquerdo != null) no = no.esquerdo;
            return no;
        }

        private void corrigirRemocao(NoRB x) {
            while (x != raiz && getCor(x) == Cor.PRETO) {
                if (x == x.pai.esquerdo) {
                    NoRB w = x.pai.direito;
                    if (getCor(w) == Cor.VERMELHO) {
                        w.cor = Cor.PRETO;
                        x.pai.cor = Cor.VERMELHO;
                        rotacaoEsquerda(x.pai);
                        w = x.pai.direito;
                    }
                    if (getCor(w.esquerdo) == Cor.PRETO && getCor(w.direito) == Cor.PRETO) {
                        w.cor = Cor.VERMELHO;
                        x = x.pai;
                    } else {
                        if (getCor(w.direito) == Cor.PRETO) {
                            if (w.esquerdo != null) w.esquerdo.cor = Cor.PRETO;
                            w.cor = Cor.VERMELHO;
                            rotacaoDireita(w);
                            w = x.pai.direito;
                        }
                        w.cor = x.pai.cor;
                        x.pai.cor = Cor.PRETO;
                        if (w.direito != null) w.direito.cor = Cor.PRETO;
                        rotacaoEsquerda(x.pai);
                        x = raiz;
                    }
                } else {
                    NoRB w = x.pai.esquerdo;
                    if (getCor(w) == Cor.VERMELHO) {
                        w.cor = Cor.PRETO;
                        x.pai.cor = Cor.VERMELHO;
                        rotacaoDireita(x.pai);
                        w = x.pai.esquerdo;
                    }
                    if (getCor(w.direito) == Cor.PRETO && getCor(w.esquerdo) == Cor.PRETO) {
                        w.cor = Cor.VERMELHO;
                        x = x.pai;
                    } else {
                        if (getCor(w.esquerdo) == Cor.PRETO) {
                            if (w.direito != null) w.direito.cor = Cor.PRETO;
                            w.cor = Cor.VERMELHO;
                            rotacaoEsquerda(w);
                            w = x.pai.esquerdo;
                        }
                        w.cor = x.pai.cor;
                        x.pai.cor = Cor.PRETO;
                        if (w.esquerdo != null) w.esquerdo.cor = Cor.PRETO;
                        rotacaoDireita(x.pai);
                        x = raiz;
                    }
                }
            }
            if (x != null) x.cor = Cor.PRETO;
        }

        private Cor getCor(NoRB no) {
            return (no == null) ? Cor.PRETO : no.cor;
        }

        private void rotacaoEsquerda(NoRB x) {
            NoRB y = x.direito;
            x.direito = y.esquerdo;
            if (y.esquerdo != null) y.esquerdo.pai = x;
            y.pai = x.pai;
            if (x.pai == null) {
                raiz = y;
            } else if (x == x.pai.esquerdo) {
                x.pai.esquerdo = y;
            } else {
                x.pai.direito = y;
            }
            y.esquerdo = x;
            x.pai = y;
        }

        private void rotacaoDireita(NoRB y) {
            NoRB x = y.esquerdo;
            y.esquerdo = x.direito;
            if (x.direito != null) x.direito.pai = y;
            x.pai = y.pai;
            if (y.pai == null) {
                raiz = x;
            } else if (y == y.pai.direito) {
                y.pai.direito = x;
            } else {
                y.pai.esquerdo = x;
            }
            x.direito = y;
            y.pai = x;
        }

        public void emOrdem() {
            emOrdemRec(raiz);
            System.out.println();
        }

        private void emOrdemRec(NoRB no) {
            if (no != null) {
                emOrdemRec(no.esquerdo);
                System.out.print(no.valor + "(" + no.cor + ") ");
                emOrdemRec(no.direito);
            }
        }
    }
