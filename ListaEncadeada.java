public class ListaEncadeada<T>{

    private Celula<T> inicio;
    private int tamanho;
    private IteratorLista<T> it;

    public void inserirNoFinal(T item){
        it = new IteratorLista<>(this);
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

    public void inserirEmPosicaoEspecifica(T item, int posicao){
        Celula<T> novaCelula = new Celula<T>(item);
        if(posicao == 0){
            novaCelula.setProximo(this.inicio);
            this.inicio = novaCelula;
        }else{
            Celula<T> aux = this.inicio;
            for(int i = 0; i < posicao - 1; i++){
                aux = aux.getProximo();
            }
            novaCelula.setProximo(aux.getProximo());
            aux.setProximo(novaCelula);
        }
        this.tamanho++;
    }


    public void inserirNoInicio(T item){
        Celula<T> novaCelula = new Celula<T>(item);
        novaCelula.setProximo(this.inicio);
        this.inicio = novaCelula;
        this.tamanho++;
    }

    public void removerItemEspecifico(T item){
        it = new IteratorLista<>(this);
        if(this.inicio == null){
            System.out.println("Lista vazia");
        }else{
            Celula<T> aux = this.inicio;
            Celula<T> anterior = null;
            while(it.hasNext() && !aux.getItem().equals(item)){
                anterior = aux;
                aux = aux.getProximo();
            }
            if(aux == null){
                System.out.println("Item não encontrado");
            }else if(anterior == null){
                this.inicio = aux.getProximo();
            }else{
                anterior.setProximo(aux.getProximo());
            }
            this.tamanho--;
        }
    }

    public void removerItemInicio(){
        if(this.inicio == null){
            System.out.println("Lista vazia");
        }else{
            this.inicio = this.inicio.getProximo();
            this.tamanho--;
        }
    }

    public void removerItemFinal(){
        it = new IteratorLista<>(this);
        if(this.inicio == null){
            System.out.println("Lista vazia");
        }else{
            Celula<T> aux = this.inicio;
            Celula<T> anterior = null;
            while(it.hasNext() && aux.getProximo() != null){
                anterior = aux;
                aux = aux.getProximo();
            }
            if(anterior == null){
                this.inicio = null;
            }else{
                anterior.setProximo(null);
            }
            this.tamanho--;
        }
    }

    public int retornaTamanho(){
        return this.tamanho;
    }

    public String toString(){
        it = new IteratorLista<>(this);
        String resultado = "";
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            resultado += aux.getItem() + " ";
            aux = aux.getProximo();
        }
        return resultado;
    }

    public ListaEncadeada<T> clone(){
        it = new IteratorLista<>(this);
        ListaEncadeada<T> novaLista = new ListaEncadeada<>();
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            novaLista.inserirNoFinal(aux.getItem());
            aux = aux.getProximo();
        }
        return novaLista;
    }

    public void inserirDoArray(T[] array){
        for(int i = 0; i < array.length; i++){
            this.inserirNoFinal(array[i]);
        }
    }

    public Object[] inserirNoArray(ListaEncadeada<T> lista){
        it = new IteratorLista<>(this);
        Celula<T> aux = lista.inicio;
        Object[] array =  new Object[lista.retornaTamanho()];
        for(int i = 0; it.hasNext() && i < array.length; i++){
            array[i] = aux.getItem();
            aux = aux.getProximo();
        }
        return array;
    }

    public ListaEncadeada<T> intercecao(ListaEncadeada<T> lista){
        ListaEncadeada<T> novaLista = new ListaEncadeada<>();
        Celula<T> aux = this.inicio;
        Celula<T> aux2 = lista.inicio;
        while(aux != null && aux2 != null){
            if(aux2.getItem().equals(aux.getItem())){
                novaLista.inserirNoFinal(aux.getItem());
                aux2 = aux2.getProximo();
            }
            aux = aux.getProximo();
            if(aux == null){
                aux = this.inicio;
                aux2 = aux2.getProximo();
            }
        
        }
        return novaLista;
    }

    public boolean pertencimento(T item){
        it = new IteratorLista<>(this);
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            if(aux.getItem().equals(item)){
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    public ListaEncadeada<T> diferenca(ListaEncadeada<T> lista){
        ListaEncadeada<T> novaLista = new ListaEncadeada<>();
        Celula<T> aux = this.inicio;
        while(aux != null){
            if(!lista.pertencimento(aux.getItem())){
                novaLista.inserirNoFinal(aux.getItem());
            }
            aux = aux.getProximo();
        }
        return novaLista;
    }

    public void percorrerLista(){
        it = new IteratorLista<>(this);
        Celula<T> aux = this.inicio;
        while(it.hasNext()){
            System.out.println(aux.getItem());
            aux = aux.getProximo();
        }
    }

    public boolean equals(ListaEncadeada<T> lista){
        Celula<T> aux = this.inicio;
        Celula<T> aux2 = lista.inicio;
        if(this.tamanho != lista.tamanho){
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

