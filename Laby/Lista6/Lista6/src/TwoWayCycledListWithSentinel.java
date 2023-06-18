import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ListIterator;
public class TwoWayCycledListWithSentinel<E> implements IList<E> {
    private String key;
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

        public void remove(){
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }
    }
    Element sentinel=null;
    public TwoWayCycledListWithSentinel() {
        sentinel=new Element(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
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
    public Element getElementKey(String key,String keyvalue){
        this.key=key;
        Element elem = sentinel.getNext();
        while(elem!=sentinel && !executeMethod(elem.getValue()).equals(keyvalue)){
            elem=elem.getNext();

        }
        return elem;


    }
    public E getValueKey(String key, String keyvalue){
        this.key=key;
        Element elem = sentinel.getNext();
        while(elem!=null && !executeMethod(elem.getValue()).equals(keyvalue)){
            elem=elem.getNext();

        }
        return elem.getValue();
    }


    @Override
    public boolean isEmpty() {
        return sentinel.getNext()==sentinel;
    }

    @Override
    public void clear() {
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
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
    public E getValue(Element elem){
        return elem.getValue();
    }

    @Override
    public E set(int index, E value) {
        Element elem=getElement(index);
        E retValue= (E) elem.getValue();
        elem.setValue(value);
        return retValue;
    }
    public E getTail(){
        return sentinel.getPrev().getValue();
    }

    @Override
    public boolean add(E value) {
        Element newElem=new Element(value);
        sentinel.insertBefore(newElem);
        return true;
    }

    @Override
    public boolean add(int index, E value) {
        Element newElem=new Element(value);
        if(index==0)
            sentinel.insertAfter(newElem);
        else{
            Element elem=getElement(index-1);
            elem.insertAfter(newElem);
        }
        return true;
    }

    @Override
    public boolean addBefore(String key, String keyvalue,E value) {
        Element keyelem = getElementKey(key,keyvalue);
        Element newElem = new Element(value);
        keyelem.insertBefore(newElem);


        return true;
    }

    @Override
    public boolean addAfter(String key, String keyvalue,E value) {
        Element keyelem = getElementKey(key,keyvalue);
        Element newElem = new Element(value);
        keyelem.insertAfter(newElem);

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
        if(elem==null){
            return null;
        } else{
            elem.remove();
            return (E) elem.getValue();
        }

    }

    @Override
    public boolean remove(E value) {
        Element elem=getElement(value);
        if(elem==null) return false;
        elem.remove();
        return true;
    }
    public boolean removeKey(String key, String keyvalue){
        Element delElem = getElementKey(key,keyvalue);
        delElem.remove();
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
    public String executeMethod(E value){
        try {
            Method method = value.getClass().getMethod(metodazkija());
            return method.invoke(value).toString();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e ){
            throw new RuntimeException(e);

        }


    }

    public String metodazkija(){
        return "get"+key.substring(0,1).toUpperCase()+key.substring(1);
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
    public void SortByKey(String key){
        this.key=key;
        if(sentinel.getNext().getNext()==sentinel){
            return;
        }
        boolean stillswapping = true;
        while(stillswapping){

            stillswapping=false;
            Element current = sentinel.getNext();
            while(current.getNext()!=sentinel){
                if(executeMethod(current.getValue()).compareTo(executeMethod(current.getNext().getValue()))>0){
                    swap(current,current.getNext());
                    stillswapping=true;
                }
                current=current.getNext();
            }
        }



    }
    public void swap(Element e1, Element e2){
        E temp = e1.getValue();

        e1.setValue(e2.getValue());
        e2.setValue(temp);



    }
}

