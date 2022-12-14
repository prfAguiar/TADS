public class IteratorFila<T> implements IteratorInterface {

    private Celula<T> atual;
    private Celula<T> aux;
    Fila<T> fila;

    public IteratorFila(Fila<T> fila) {
        this.fila = fila;
        this.atual = fila.retornaPrimeiroItem();
        this.aux = fila.retornaPrimeiroItem();
    }

    @Override
    public boolean hasNext() {
        if (fila.retornaTamanho() <= 0 || aux == null) {
            aux = fila.retornaPrimeiroItem();
            return false;
        } else {
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

    public T getElement() {
        return atual.getItem();
    }

}
