import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private Iterator<T> i1,i2;
    private boolean flipflop=true;

    public MyIterator(Iterator<T> i1, Iterator<T> i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }
    public T next(){
        if(flipflop){
            if(i1.hasNext()){
                flipflop=false;

                return i1.next();

            }else {
                flipflop=true;
                return i2.next()

            }
        }



    }
}
