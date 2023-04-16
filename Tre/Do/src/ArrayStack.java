public class ArrayStack<T> implements IStack<T> {

    private static final int DEFAULT_CAPACITY = 16;
    T array[];
     int topIndex;

    // klasy generyczne w zasadzie s� typu Object
    // pozwalaj� jednak ju� na etapie kompilacji sprawdza� poprawno�� typ�w
    @SuppressWarnings("unchecked")
    public ArrayStack (int initialSize){
        array=(T[])(new Object[initialSize]);
        topIndex=0;
    }

    public ArrayStack (){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }

    @Override
    public boolean isFull() {
        return topIndex==array.length;
    }

    @Override
    public T pop()  {

        return array[--topIndex];
    }

    @Override
    public void push(T elem) {

        array[topIndex++]=elem;

    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top()  {

        return array[topIndex-1];
    }

}