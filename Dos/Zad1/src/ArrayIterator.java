import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T Array[];
    private int pos =0;

    public ArrayIterator(T anArray[]){
        Array=anArray;
    }

    @Override
    public boolean hasNext() {
        return pos<Array.length;
    }

    @Override
    public T next() throws NoSuchElementException {
        if(hasNext()){
            return Array[pos++];
        } else
            throw new NoSuchElementException();
    }



}
