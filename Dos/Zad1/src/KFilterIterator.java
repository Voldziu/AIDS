import java.util.Iterator;

public class KFilterIterator<T> implements Iterator<T> {
    private ArrayIterator<T> arrayIterator;
    private Predicate<T> predicate;
    private int k;
    private T elemnext= null;
    private boolean bHasNext = true;


    public KFilterIterator(ArrayIterator<T> arrayIterator, Predicate<T> predicate,int k) {
        super();
        this.arrayIterator = arrayIterator;
        this.predicate = predicate;
        this.k=k;
        findNextValid();
    }

    public void findNextValid(){
        while(arrayIterator.hasNext()){
            elemnext= arrayIterator.next();
            if(predicate.accept(elemnext,k)){
                return;
            }

        }
        bHasNext=false;
        elemnext=null;

    }

    @Override
    public boolean hasNext() {
        return bHasNext;
    }

    @Override
    public T next() {
        T nextValue = elemnext;
        findNextValid();
        return nextValue;
    }
}
