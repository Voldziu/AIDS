import java.util.ListIterator;

public interface IList<E> extends Iterable<E> {
    boolean add(E e );
    boolean add(int index,E element);

    boolean addBefore(E key, E element);

    boolean addAfter(E key, E element);
    void clear();
    boolean contains(E element);
    E get(int index);
    E set(int index, E element);
    int indexOf(E element);
    boolean isEmpty();

    ListIterator<E> listIterator();
    E remove(int index);
    boolean remove(E element);
    int size();
    void printlist();


}