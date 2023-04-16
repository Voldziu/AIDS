import java.util.Iterator;
import java.util.ListIterator;

public class OneWayListWithSentinel<E> implements IList<E>{


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

//        public void insertAfter(Element elem){
//            elem.setNext(this.getNext());
//            elem.setPrev(this);
//            this.getNext().setPrev(elem);
//            this.setNext(elem);
//        }
//
//        public void insertBefore(Element elem){
//            elem.setNext(this);
//            elem.setPrev(this.getPrev());
//            this.getPrev().setNext(elem);
//            this.setPrev(elem);
//        }
//
//        public void remove(){
//            this.getNext().setPrev(this.getPrev());
//            this.getPrev().setNext(this.getNext());
//        }
    }
    Element sentinel = null;

    public OneWayListWithSentinel() {
        sentinel = new Element(null);
        sentinel.setNext(null);
    }
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

    @Override
    public boolean add(E e) {
        Element newElem = new Element(e);
        Element prevElem = sentinel.getNext();

        if(prevElem==null){
            sentinel.setNext(newElem);


        } else{
            while (prevElem.getNext()!=null){
                prevElem=prevElem.getNext();
            }
            prevElem.setNext(newElem);







        } return  true;
    }

    @Override
    public boolean add(int index, E element) {
        Element newElem = new Element(element);

        if (index==0){
            newElem.setNext(sentinel.getNext());
            sentinel.setNext(newElem);

        } else  {
            Element prevElem = getElement(index-1);
            if(prevElem.getNext()==null){
                prevElem.setNext(newElem);
                newElem.setNext(null);
            } else{
                newElem.setNext(prevElem.getNext());
                prevElem.setNext(newElem);
            }


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
        return indexOf(element)>=0;
    }

    @Override
    public E get(int index) {
       Element actElem = getElement(index);
       return actElem.getValue();
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(E value) {
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && !elem.getValue().equals(value)){
            counter++;
            elem=elem.getNext();
        }
        if(elem==sentinel)
            return -1;
        return counter;
    }


    @Override
    public boolean isEmpty() {
        return sentinel.getNext()==null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public E remove(int index) {
        Element delElem =getElement(index);
        if(index==0){
            sentinel.setNext(delElem.getNext());
        } else {
            Element prevElem = getElement(index - 1);


            if (delElem.getNext() != null) {
                prevElem.setNext(delElem.getNext());
            } else {
                prevElem.setNext(null);

            }


        }


        return delElem.getValue();




    }

    @Override
    public boolean remove(E element) {
        Element delElem = getElement(element);
        if(sentinel.getNext()==delElem){
            sentinel.setNext(delElem.getNext());

        } else {
            Element prevElem = getElement(indexOf(element)-1);

            if(delElem.getNext()!=null){
                prevElem.setNext(delElem.getNext());
            } else{
                prevElem.setNext(null);
            }
        }
        return true;
    }

    @Override
    public int size() {
        Element elem = sentinel.getNext();
        int counter=0;
        while (elem.getNext()!=null){
            counter++;
            elem=elem.getNext();

        }
        return counter;
    }

    @Override
    public void printlist() {

    }

    @Override
    public Iterator<E> iterator() {
        return new OWLiterator();
    }

    private class OWLiterator implements Iterator<E>{
        Element current = sentinel;

        @Override
        public boolean hasNext() {
            return current.getNext()!=null;
        }

        @Override
        public E next() {
            current= current.getNext();
            return current.getValue();
        }

        @Override
        public void remove() {
            OneWayListWithSentinel.this.remove(current.getValue());
        }
    }

}
