public class ReversedStack<E> extends ListStack<E>{
    public void reverse(){
        ListStack<E> tempStack = new ListStack<>();


        while(!this.isEmpty()){
            E poppedelem = this.pop();
            tempStack.push(poppedelem);



        }
        _list=tempStack._list;

    }
}
