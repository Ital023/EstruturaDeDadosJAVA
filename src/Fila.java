public class Fila {
    int vetor_elementos[];
    int numero_elementos;

    public Fila(int t){
        vetor_elementos = new int [t];
        numero_elementos = 0;
    }

    public boolean listaVazia(){
        if(numero_elementos == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean listaCheia(){
        if(numero_elementos >= vetor_elementos.length){
            return true;
        }else{
            return false;
        }
    }

    public void enfileirar(int e){
        if(listaCheia()){
            System.out.println("Lista Cheia");
        }else{
            int indice = numero_elementos;
            vetor_elementos[indice] = e;
            numero_elementos = numero_elementos + 1;
        }
    }

    public int desenfileirar(){
        if(listaVazia()){
            System.out.println("Lista Vazia");
            return -1;
        }else{
            int elemento_removido = vetor_elementos[0];
            for (int indice = 1; indice <= numero_elementos-1 ; indice++) {
                vetor_elementos[indice - 1] = vetor_elementos[indice];
            }
            numero_elementos = numero_elementos - 1;
            return elemento_removido;
        }
    }

    public int getQuantidade(){
        return numero_elementos;
    }


    public int retornarElemento(){
        return vetor_elementos[0];
    }

    public void printVector(){
        for (int j = 0; j < numero_elementos; j++) {
            System.out.println("Vetor na posição "+j+ " = "+vetor_elementos[j]);
        }
    }
    public int maiorValor(){
        int maior = retornarElemento();
        for (int i = 0; i<numero_elementos; i++){
            enfileirar(desenfileirar());
            if (retornarElemento() > maior){
                maior = retornarElemento();
            }
        }
        return maior;
    }
}