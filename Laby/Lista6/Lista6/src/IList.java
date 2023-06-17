import java.util.ListIterator;

public interface IList<E> extends Iterable<E> {

    boolean add(E e );
    boolean add(int index,E element);

    boolean addBefore(String key, String keyvalue,E value);

    boolean addAfter(String key, String keyvalue,E value);
    void clear();
    boolean contains(E element);
    E get(int index);
    E getValueKey(String key, String keyvalue);

    E set(int index, E element);
    int indexOf(E element);
    boolean isEmpty();

    ListIterator<E> listIterator();
    E remove(int index);
    boolean remove(E element);
    int size();
    void printlist();
    public boolean removeKey(String key, String keyvalue);
    public void SortByKey(String key);


}
