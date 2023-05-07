public interface IStack<T>{
    boolean empty();
    boolean full();
    T pop() ;
    void push(T elem) ;
    int size();  // zwraca liczb� element�w na stosie
    T peek() ;
    // zwraca element ze szczutu stosu bez usuwania go

}