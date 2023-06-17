public class Stack<T> implements IStack<T> {

    private static final int DEFAULT_CAPACITY = 32;
    T array[];
    int topIndex;

    // klasy generyczne w zasadzie s� typu Object
    // pozwalaj� jednak ju� na etapie kompilacji sprawdza� poprawno�� typ�w
    @SuppressWarnings("unchecked")
    public Stack (int initialSize){
        array=(T[])(new Object[initialSize]);
        topIndex=0;
    }

    public Stack (){
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
    public void push(T elem)  {

        array[topIndex++]=elem;

    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T peek()  {

        return array[topIndex-1];
    }

}
