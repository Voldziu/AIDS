public interface IQueue<T> {
    boolean isEmpty();
    boolean isFull();
    T dequeue();
    void enqueue(T elem);
    int size();  // zwraca liczb� element�w w kolejce
    /** zwraca pierwszy element kolejki bez usuwania go */
    T first();
}
