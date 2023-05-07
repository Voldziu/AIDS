import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ListIterator;

public class OneWayListWithSentinel<E> implements IList<E>{
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
    private Element sentinel = null;

    public OneWayListWithSentinel() {
        sentinel = new Element(null);
        sentinel.setNext(null);
    }
    public Element getElement(int index){
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=null && counter<index){
            counter++;
            elem=elem.getNext();
        }
        if(elem==sentinel)
            return null;
        return elem;
    }

    public Element getElement(E value){
        Element elem=sentinel.getNext();

        while(elem!=null && !value.equals(elem.getValue())){

            elem=elem.getNext();
        }
        if(elem==null)
            return null;
        return elem;
    }
    public Element getElementKey(String key,String keyvalue){
        this.key=key;
        Element elem = sentinel.getNext();
        while(elem!=null && !executeMethod(elem.getValue()).equals(keyvalue)){
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
    public boolean addBefore(String key, String keyvalue,E value) {
        Element keyelem = getElementKey(key,keyvalue);
        Element newElem = new Element(value);
        int index = indexOf(keyelem.getValue());
        if(index==0){
            newElem.setNext(sentinel.getNext());
            sentinel.setNext(newElem);


        }else{
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
    public boolean addAfter(String key, String keyvalue,E value) {
        Element keyelem = getElementKey(key,keyvalue);
        Element newElem = new Element(value);
        if(keyelem.getNext()==null){
            keyelem.setNext(newElem);
            newElem.setNext(null);
        } else{
            newElem.setNext(keyelem.getNext());
            keyelem.setNext(newElem);

        }

        return true;
    }

    @Override
    public void clear() {
        sentinel.setNext(null);

    }

    @Override
    public boolean contains(E element) {
        return indexOf(element)>=0;
    }


    public E get(int Index) {


       return null;
    }
    public E getValue(Element elem){
        return elem.getValue();
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
        return new OWListIterator();
    }
    private class OWListIterator implements ListIterator<E>{
       Element _current = sentinel;

        @Override
        public boolean hasNext() {
            return _current.getNext()!=null;
        }

        @Override
        public E next() {
            _current=_current.getNext();
            return _current.getValue();
        }

        @Override
        public boolean hasPrevious() {
            throw  new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
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
            OneWayListWithSentinel.this.remove(_current.getValue());


        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
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
    public boolean removeKey(String key, String keyvalue){
        Element delElem = getElementKey(key,keyvalue);
        if(sentinel.getNext()==delElem){
            sentinel.setNext(delElem.getNext());

        } else {
            Element prevElem = getElement(indexOf(delElem.getValue())-1);

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
        Element actElem = sentinel.getNext();
        while(actElem!=null){
            System.out.println(actElem.getValue());
            actElem=actElem.getNext();
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
    public void SortByKey(String key){
        this.key=key;
        if(sentinel.getNext().getNext()==sentinel){
            return;
        }
        boolean swapped = true;
        while(swapped){
            swapped=false;
            Element current = sentinel.getNext();
            while(current.getNext()!=null){
                if(executeMethod(current.getValue()).compareTo(executeMethod(current.getNext().getValue()))>0){
                    swap(current,current.getNext());
                    swapped=true;
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
