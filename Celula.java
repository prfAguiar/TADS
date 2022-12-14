public class Celula<T>{
    private T item;
    private Celula<T> proximo;
    
    public Celula(T item){
        this.item = item;
        this.proximo = null;
    }
    
    public Celula(T item, Celula<T> proximo){
        this.item = item;
        this.proximo = proximo;
    }

    public T getItem(){
        return this.item;
    }
    
    public void setItem(T item){
        this.item = item;
    }
    
    public Celula<T> getProximo(){
        return this.proximo;
    }
    
    public void setProximo(Celula<T> proximo){
        this.proximo = proximo;
    }
    
}
