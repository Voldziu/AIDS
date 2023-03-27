import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.ListIterator;

public class OneWayListWithSentino<E> implements IList<E>{
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public class Element{
        private E value;
        private Element next;

        public E getValue(){
            return value;

        }
        public void setValue(E data){
            this.value = data;
        }
        public Element getNext(){
            return next;
        }
        public void setNext(Element next){
            this.next=next;

        }
        Element(E data){
            this.value=data;
        }
    }

    private Element sentino = new Element(null);

    public OneWayListWithSentino(){};

    @Override
    public boolean add(E element) {
        Element newElem = new Element(element);
        Element tail = sentino;
        while(tail.getNext() != null){
            tail = tail.getNext();

        }
        tail.setNext(newElem);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index<0){
            throw new IndexOutOfBoundsException();
        }
        Element newElem = new Element(element);

        Element prevElem = sentino;
        while(index!=0 && prevElem!= null){
            prevElem = prevElem.getNext();
            index--;

        }
        if(prevElem==null){
            throw new IndexOutOfBoundsException();

        }
        newElem.setNext(prevElem.getNext());
        prevElem.setNext(newElem);


    }

    @Override
    public void clear() {
        sentino.setNext(null);

    }

    @Override
    public boolean contains(E element) {
        return indexOf(element)>=0;
    }


    public Element getElem(int index) {
        if(index<0) throw new IndexOutOfBoundsException();
        Element actElem = sentino.getNext();
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext();

        }
        if(actElem==null){
            throw new IndexOutOfBoundsException();

        }
        return actElem;
    }

    public E get(int index){
        Element actElem = getElem(index);
        return actElem.getValue();
    }

    @Override
    public E set(int index, E element) {
        Element actElem = getElem(index);
        E elemData = actElem.getValue();
        actElem.setValue(element);
        return elemData;
    }

    @Override
    public int indexOf(E element) {
        int pos = 0;
        Element actElem = sentino.getNext();
        while(actElem!=null){
            if(actElem.getValue().equals(element)){
                return pos;
            }
            pos++;
            actElem=actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return sentino.getNext()==null;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public E remove(int index) {
        if(index<0 || sentino.getNext()==null) {
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            E returnValue = sentino.getNext().getValue();
            sentino.setNext(sentino.getNext().getNext());
            return returnValue;
        }
        Element actElem =getElem(index-1);
        if(actElem.getNext()==null){
            throw new IndexOutOfBoundsException();

        }
        E returnValue = actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return returnValue;
    }

    @Override
    public boolean remove(E element) {
        if(sentino.getNext()==null){
            return false;
        }
        if(sentino.getNext().getValue().equals(element)){
            sentino.setNext(sentino.getNext().getNext());
            return true;
        }
        Element actElem=sentino.getNext();

        while(actElem.getNext()!=null && !actElem.getNext().getNext().equals(element)){
            actElem=actElem.getNext();

        }
        if(actElem.getNext()==null){
            return false;
        }
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    @Override
    public int size() {
        int pos=0;
        Element actElem= sentino.getNext();
        while(actElem!=null){
            pos++;
            actElem=actElem.getNext();
        }
        return pos;
    }

    @Override
    public void printlist() {
        Element actElem=sentino.getNext();
        for (int i = 0; i <size() ; i++) {
            System.out.println("Index: "+i+"Wartość: "+actElem.getValue());
            actElem=actElem.getNext();

        }

    }
}
