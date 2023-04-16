public class SinkingArrayStack<E> extends ArrayStack<E>{
    int beginindex;
    int endindex;

    int maxcapacity = 10;
    public void push1(E elem) {
        ArrayStack<E> tempStack = new ArrayStack<>();
        if(topIndex==maxcapacity){
            while (!this.isEmpty()){
                tempStack.push(this.pop());

            }





        }
    }
}
