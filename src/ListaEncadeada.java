public class ListaEncadeada {
    No header;

    public ListaEncadeada() {
        this.header = null;
    }

    public boolean listaVazia(){
        if(header == null){
            return true;
        }else{
            return false;
        }
    }

    public void adicionarInicio(int e){
        No novo = new No(e);
        if(!listaVazia()){
            novo.proximo_no = header;
        }
        header = novo;
        //System.out.println("[" + novo.elemento_armazenado + "|" + novo.proximo_no + "]");
    }

    public void adicionarFinal(int e){
        No novo = new No(e);

        if(listaVazia()){
            header = novo;
        }else{
            No auxiliar = header;
            while(auxiliar.proximo_no != null){
                auxiliar = auxiliar.proximo_no;
            }
            auxiliar.proximo_no = novo;
        }
        //System.out.println("[" + novo.elemento_armazenado + "|" + novo.proximo_no + "]");
    }

    public No removerInicio(){
        No removido = null;
        if(listaVazia()){
            throw new RuntimeException("estrutura vazia");
        }else{
            removido = header;
            header = header.proximo_no;
        }
        return removido;
    }

    public No removerFinal(){
        No removido = null;
        if(listaVazia()){
            throw new RuntimeException("Estrutura vazia");
        }else{
            No auxiliar = header;
            removido = header;
            while(removido.proximo_no != null){
                auxiliar = removido;
                removido = removido.proximo_no;
            }
            auxiliar.proximo_no = null;
        }
        return removido;
    }


    public void printNo(){
        No atual = header;
        while (atual != null) {
            System.out.print("["+atual.elemento_armazenado+"|"+(atual.proximo_no).elemento_armazenado+"]  ");
            atual = atual.proximo_no;
        }
        System.out.println();
    }
}
