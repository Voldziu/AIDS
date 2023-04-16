public class ListQueue<E> implements IQueue<E>{
    TwoWayCycledListWithSentinel<E> _list;
    public ListQueue() {
        _list=new TwoWayCycledListWithSentinel<E>();
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
    public E dequeue() {
        E value=_list.remove(0);

        return value;
    }
    @Override
    public void enqueue(E elem) {
        _list.add(elem);
    }
    @Override
    public int size() {

        return _list.size();
    }
    @Override
    public E first()  {
        E value=_list.get(0);

        return value;
    }
}
