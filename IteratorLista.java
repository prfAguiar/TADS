public class IteratorLista<T> implements IteratorInterface{

    private Celula<T> atual;
    private Celula<T> aux;
    private ListaEncadeada<T> lista;
    

    public IteratorLista(ListaEncadeada<T> lista){
        this.lista = lista;
        this.atual = lista.retornaPrimeiroItem();
        this.aux = lista.retornaPrimeiroItem();
    }
    @Override
    public boolean hasNext() {
        if(lista.retornaTamanho() <= 0 || aux == null){
            aux = lista.retornaPrimeiroItem();
            return false;
        }else {
            aux = aux.getProximo();
            return true;
        }
        
    }

    @Override
    public T next() {
        T item = atual.getItem();
        atual = atual.getProximo();
        return item;
    }

    public T getElement(){
        return atual.getItem();
    }
    
}
