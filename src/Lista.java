public class Lista {
    int v[];
    int qtd_elem;

    public Lista(int qtd_elem) {
        v = new int[qtd_elem];
    }

    public int getQtd_elem() {
        return qtd_elem;
    }

    public boolean listaVazia() {
        if (qtd_elem <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean listaCheia() {
        if (qtd_elem >= v.length) {
            return true;
        } else {
            return false;
        }
    }

    public int retornarElemento(int i) {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
            return -1;
        } else {
            if (i <= 0) {
                return v[0];
            } else if (i >= qtd_elem) {
                return v[qtd_elem - 1];
            } else {
                return v[i];
            }
        }
    }

    public void addInicio(int e) {
        if (listaCheia()) {
            System.out.println("Lista Cheia!");
        } else {
            for (int c = qtd_elem; c > 0; c --) {
                v[c] = v[c - 1];
            }
            v[0] = e;
            qtd_elem++;
        }
    }

    public void addFinal(int e) {
        if (listaCheia()) {
            System.out.println("Lista Cheia!");
        } else {
            v[qtd_elem] = e;
            qtd_elem++;
        }
    }
    public void addPosicao(int e, int i) {
        if (listaCheia()) {
            System.out.println("Lista Cheia!");
        } else {
            if (i <= 0) {
                addInicio(e);
            } else if (i >= qtd_elem) {
                addFinal(e);
            } else {
                for (int c = qtd_elem; c > i; c--) {
                    v[c] = v[c - 1];
                }
                v[i] = e;
            }
            qtd_elem++;
        }
    }

    public int removerFinal() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
            return -1;
        } else {
            qtd_elem--;
            return v[qtd_elem];
        }
    }

    public int removerInicio() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
            return -1;
        } else {
            int x = v[0];
            for (int c = 0; c < qtd_elem - 1; c++) {
                v[c] = v[c + 1];
            }
            qtd_elem--;
            return x;
        }
    }

    public int removerPosicao(int i) {
        if (listaVazia()) {
            System.out.println("Lista Vazia");
            return -1;
        } else {
            int x = v[i];
            if (i <= 0) {
                removerInicio();
            } else if (i >= qtd_elem) {
                removerFinal();
            } else {
                for (int c = i; c < qtd_elem - 1; c++) {
                    v[c] = v[c + 1];
                }
            }
            qtd_elem--;
            return x;
        }
    }

    public int retornarMeio() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
            return -1;
        } else {
            if (getQtd_elem()% 2 != 0) {
                System.out.println("Não existe um elemento no meio do vetor");
                return -1;
            } else {
                return retornarElemento(getQtd_elem() / 2);
            }
        }
    }

    public void trocar() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
        } else {
            int inicio = retornarElemento(0);
            int fim = retornarElemento(getQtd_elem() - 1);
            removerFinal();
            removerInicio();
            addInicio(fim);
            addFinal(inicio);
        }
    }

    public void verifPalindromo() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
        } else {
            int s = 0;
            for (int i = 0; i < getQtd_elem(); i++) {
                for (int j = getQtd_elem() - 1; j >= 0; j--) {
                    if ((i + j) == getQtd_elem() - 1 && retornarElemento(i) != retornarElemento(j)) {
                        s++;
                    }
                }
            }
            if (s != 0) {
                System.out.println("Não é um Palíndromo");
            } else {
                System.out.println("É um Palíndromo");
            }
        }
    }
    public void printLista() {
        for (int c = 0; c < qtd_elem; c++) {
            System.out.println("\n" + v[c]);
        }
    }

}