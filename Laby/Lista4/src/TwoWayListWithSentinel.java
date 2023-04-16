import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayListWithSentinel<E> implements  IList<E>{


    private class Element{
        private E value;
        private Element next;
        private Element prev;
        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
        public Element getNext() {
            return next;
        }
        public void setNext(Element next) {
            this.next = next;
        }
        public Element getPrev() {
            return prev;
        }
        public void setPrev(Element prev) {
            this.prev = prev;
        }

        Element(E data){
            this.value=data;
        }

        public void insertAfter(Element elem){
            elem.setNext(this.getNext());
            elem.setPrev(this);
            this.getNext().setPrev(elem);
            this.setNext(elem);
        }

        public void insertBefore(Element elem){
            elem.setNext(this);
            elem.setPrev(this.getPrev());
            this.getPrev().setNext(elem);
            this.setPrev(elem);
        }

        public void remove() {
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());


        }
        }
    Element sentinel = null;
    Element tail = null;

    public Element getElement(int index){
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && counter<index){
            counter++;
            elem=elem.getNext();
        }
        if(elem==sentinel)
            return null;
        return elem;
    }

    public Element getElement(E value){
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && !value.equals(elem.getValue())){
            counter++;
            elem=elem.getNext();
        }
        if(elem==sentinel)
            return null;
        return elem;
    }




    public boolean add(E e) {

        Element newElem = new Element(e);
        tail.setNext(newElem);
        tail=newElem;




        return true;


    }


    @Override
    public boolean add(int index, E element) {
        Element newElem = new Element(element);
        Element prevElem = getElement(index-1);
        if(prevElem.getNext()!=null){
            newElem.insertAfter(prevElem);
        } else{
            newElem.setNext(null);
            newElem.setPrev(prevElem);
            prevElem.setNext(newElem);

        }
        return true;




    }

    @Override
    public boolean addBefore(E key, E element) {
        return false;
    }

    @Override
    public boolean addAfter(E key, E element) {
        return false;
    }

    @Override
    public void clear() {
        sentinel.setNext(null);

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printlist() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
