public class ListStack<E> implements IStack<E> {

    IList<E> _list;
    public ListStack(){
        _list = new TwoWayCycledListWithSentinel<>();
    }
    @Override
    public boolean isEmpty() {
        return _list.isEmpty();
    }
    @Override
    public boolean isFull() {
        return false;
    }
    @Override
    public E pop()  {
        E value=_list.remove(0);



        return value;
    }
    @Override
    public void push(E elem)  {
        _list.add(0,elem);

    }
    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public E peek() {
        return _list.get(0);
    }



}
