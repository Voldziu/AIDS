import java.util.Iterator;

public class FibIterator implements Iterator<Integer> {
    private int n;
    private  int current = 0;
    private int previous =1;

    public FibIterator(int n) {
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return n>0;
    }

    @Override
    public Integer next() {
        n--;
        int temp=current;
        current+=previous;
        previous=temp;
        return current;
    }
}
