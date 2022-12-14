public class Fila<T> {

    private Celula<T> inicio;
    private int tamanho;
    private IteratorFila<T> it;

    public void inserir(T item){
        it = new IteratorFila<>(this);
        Celula<T> novaCelula = new Celula<T>(item);
        if(this.inicio == null){
            this.inicio = novaCelula;
        }else{
            Celula<T> aux = this.inicio;
            while(aux.getProximo() != null && it.hasNext()){
                aux = aux.getProximo();
            }
            aux.setProximo(novaCelula);
        }
        this.tamanho++;
    }

    public Celula<T> retornaPrimeiroItem(){
        return this.inicio;
    }

    public void remover(){
        if(this.inicio == null){
            System.out.println("Fila vazia");
        }else{
            this.inicio = this.inicio.getProximo();
            this.tamanho--;
        }
    }


    public int retornaTamanho(){
        return this.tamanho;
    }

    public String toString(){
        it = new IteratorFila<>(this);
        String resultado = "";
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            resultado += aux.getItem() + " ";
            aux = aux.getProximo();
        }
        return resultado;
    }

    public Fila<T> clone(){
        it = new IteratorFila<>(this);
        Fila<T> novaFila = new Fila<>();
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            novaFila.inserir(aux.getItem());
            aux = aux.getProximo();
        }
        return novaFila;
    }

    public void inserirDoArray(T[] array){
        for(int i = 0; i < array.length; i++){
            this.inserir(array[i]);
        }
    }

    public Object[] inserirNoArray(Fila<T> fila){
        it = new IteratorFila<>(this);
        Celula<T> aux = fila.inicio;
        Object[] array =  new Object[fila.retornaTamanho()];
        for(int i = 0; it.hasNext() && i < array.length; i++){
            array[i] = aux.getItem();
            aux = aux.getProximo();
        }
        return array;
    }

    // public Fila<T> intercecao(Fila<T> fila){
    //     Fila<T> novaFila = new Fila<>();
    //     Celula<T> aux = this.inicio;
    //     Celula<T> aux2 = fila.inicio;
    //     while(aux != null && aux2 != null){
    //         if(aux2.getItem().equals(aux.getItem())){
    //             novaFila.inserir(aux.getItem());
    //             aux2 = aux2.getProximo();
    //         }
    //         aux = aux.getProximo();
    //         if(aux == null){
    //             aux = this.inicio;
    //             aux2 = aux2.getProximo();
    //         }
        
    //     }
    //     return novaFila;
    // }
    // criar um metodo que verifique a intersecao entre duas filas

    public Fila<T> intersecao(Fila<T> fila){
        Fila<T> novaFila = new Fila<>();
        it = new IteratorFila<>(this);
        Celula<T> aux1 = this.inicio;
        Celula<T> aux2 = fila.inicio;
        while(it.hasNext()){
            if(aux1.getItem().equals(aux2.getItem())){
                novaFila.inserir(aux1.getItem());
            }
            aux1 = aux1.getProximo();
            aux2 = aux2.getProximo();
        }
        return novaFila;
    }
    public boolean pertencimento(T item){
        it = new IteratorFila<>(this);
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            if(aux.getItem().equals(item)){
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    public Fila<T> diferenca(Fila<T> fila){
        Fila<T> novaFila = new Fila<>();
        Celula<T> aux = this.inicio;
        while(aux != null){
            if(!fila.pertencimento(aux.getItem())){
                novaFila.inserir(aux.getItem());
            }
            aux = aux.getProximo();
        }
        return novaFila;
    }

    public void percorrerFila(){
        it = new IteratorFila<>(this);
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            System.out.println(it.next());
            aux = aux.getProximo();
        }
    }

    public boolean equals(Fila<T> fila){
        Celula<T> aux = this.inicio;
        Celula<T> aux2 = fila.inicio;
        if(this.tamanho != fila.tamanho){
            return false;
        }else{
            while(aux != null && aux2 != null){
                if(!aux.getItem().equals(aux2.getItem())){
                    return false;
                }
                aux = aux.getProximo();
                aux2 = aux2.getProximo();
            }
            return true;
        }
    }
}