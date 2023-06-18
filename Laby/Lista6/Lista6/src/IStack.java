public interface IStack<T>{
    boolean isEmpty();
    boolean isFull();
    T pop() ;
    void push(T elem) ;
    int size();  // zwraca liczb� element�w na stosie
    T peek() ;
    // zwraca element ze szczutu stosu bez usuwania go

}