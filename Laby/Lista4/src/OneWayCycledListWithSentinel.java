import java.util.Iterator;
import java.util.ListIterator;

public class OneWayCycledListWithSentinel<E> implements IList<E> {
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

        Element(E data){
            this.value=data;
        }

//        public void insertAfter(Element elem){
//            elem.setNext(this.getNext());
//
//            this.setNext(elem);
//        }
//
//        public void insertBefore(Element elem){
//            elem.setNext(this);
//
//        }
//
//        public void remove(){
//            this.getNext().setPrev(this.getPrev());
//            this.getPrev().setNext(this.getNext());
//        }
    }
    Element sentinel=null;
    public OneWayCycledListWithSentinel() {
        sentinel=new Element(null);
        sentinel.setNext(sentinel);
       
    }
    private Element getElement(int index){
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

    private Element getElement(E value){
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
    public boolean isEmpty() {
        return sentinel.getNext()==sentinel;
    }

    @Override
    public void clear() {
        sentinel.setNext(sentinel);

    }

    @Override
    public boolean contains(E value) {
        return indexOf(value)!=-1;
    }

    @Override
    public E get(int index) {
        Element elem=getElement(index);
        return (E) elem.getValue();
    }

    @Override
    public E set(int index, E value) {
        Element elem=getElement(index);
        E retValue= (E) elem.getValue();
        elem.setValue(value);
        return retValue;
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
    public boolean add(int index, E value) {
        Element newElem=new Element(value);
        if(index==0) {
            newElem.setNext(sentinel.getNext());
            sentinel.setNext(newElem);
        }
        else{
            Element prevElem=getElement(index-1);
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
    public E remove(int index) {
        Element elem=getElement(index);
        if(index==0){
            sentinel.setNext(elem.getNext());
        } else{
            Element prevElem = getElement(index-1);
            if(elem.getNext()!=null){
                prevElem.setNext(elem.getNext());
            } else{
                prevElem.setNext(null);
            }
        }
        return elem.getValue();

    }

    @Override
    public boolean remove(E value) {
        Element elem=getElement(value);
        if(sentinel.getNext()==elem){
            sentinel.setNext(elem.getNext());
        } else{
            Element prevElem = getElement(indexOf(value)-1);
            if(elem.getNext()!=null){
                prevElem.setNext(elem.getNext());
            } else{
                prevElem.setNext(null);
            }
        }

        return true;
    }

    @Override
    public int size() {
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel){
            counter++;
            elem=elem.getNext();
        }
        return counter;
    }

    @Override
    public void printlist() {
        Element actElem = sentinel.getNext();
        while(actElem!= sentinel){
            System.out.println(actElem.getValue());
            actElem = actElem.getNext();
        }

    }


    @Override
    public Iterator<E> iterator() {
        return new TWCIterator();
    }

    private class TWCIterator implements Iterator<E>{

        Element _current=sentinel;

        @Override
        public boolean hasNext() {
            return _current.getNext()!=sentinel;
        }

        @Override
        public E next() {
            _current=_current.getNext();
            return (E) _current.getValue();
        }

    }


    @Override
    public ListIterator<E> listIterator() {

        return new TWCListIterator();
    }

    private class TWCListIterator implements ListIterator<E>{

        boolean wasNext=false;
        boolean wasPrevious=false;
        /** stra�nik */
        Element _current=sentinel;


        @Override
        public boolean hasNext() {
            return _current.getNext()!=sentinel;
        }

        @Override
        public boolean hasPrevious() {
            return _current!=sentinel;
        }

        @Override
        public E next() {
            wasNext=true;
            wasPrevious=false;
            _current=_current.getNext();
            return (E) _current.getValue();
        }

        @Override
        public E previous() {
            wasNext=false;
            wasPrevious=true;
            E retValue= (E) _current.getValue();
            _current=_current.getPrev();
            return retValue;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            if(wasNext){
                Element curr=_current.getPrev();
                _current.remove();
                _current=curr;
                wasNext=false;
            }
            if(wasPrevious){
                _current.getNext().remove();
                wasPrevious=false;
            }
        }

        @Override
        public void add(E data) {
            Element newElem=new Element(data);
            _current.insertAfter(newElem);
            _current=_current.getNext();
        }

        @Override
        public void set(E data) {
            if(wasNext){
                _current.setValue(data);
                wasNext=false;
            }
            if(wasPrevious){
                _current.getNext().setValue(data);
                wasNext=false;
            }
        }
    }
}

