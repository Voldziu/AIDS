public class ArrayQueue<T> implements IQueue<T> {

    private static final int DEFAULT_CAPACITY = 16;
    T array[];
    int beginIndex;
    int endIndex;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        array=(T[])new Object[size+1];
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public boolean isEmpty() {
        return beginIndex==endIndex;
    }

    @Override
    public boolean isFull() {
        return beginIndex==(endIndex+1)%array.length;
    }

    @Override
    public T dequeue()  {

        T retValue=array[beginIndex++];
        beginIndex%=array.length;
        return retValue;
    }

    @Override
    public void enqueue(T elem)  {

        array[endIndex++]=elem;
        endIndex%=array.length;
    }

    @Override
    public int size() {
        return (endIndex+array.length-beginIndex) % array.length;
    }

    @Override
    public T first()  {

        return array[beginIndex];
    }

}
