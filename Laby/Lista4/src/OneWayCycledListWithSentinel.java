import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ListIterator;

public class OneWayCycledListWithSentinel<E> implements IList<E> {
    private String key;

    private class Element {
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


        Element(E data) {
            this.value = data;
        }


    }

    Element sentinel = null;

    public OneWayCycledListWithSentinel() {
        sentinel = new Element(null);
        sentinel.setNext(sentinel);

    }

    private Element getElement(int index) {
        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel && counter < index) {
            counter++;
            elem = elem.getNext();
        }
        if (elem == sentinel)
            return null;
        return elem;
    }

    private Element getElement(E value) {
        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel && !value.equals(elem.getValue())) {
            counter++;
            elem = elem.getNext();
        }
        if (elem == sentinel)
            return null;
        return elem;
    }

    public Element getElementKey(String key, String keyvalue) {
        this.key = key;
        Element elem = sentinel.getNext();
        while (elem != null && !executeMethod(elem.getValue()).equals(keyvalue)) {
            elem = elem.getNext();

        }
        return elem;


    }

    public E getValueKey(String key, String keyvalue) {
        this.key = key;
        Element elem = sentinel.getNext();
        while (elem != null && !executeMethod(elem.getValue()).equals(keyvalue)) {
            elem = elem.getNext();

        }
        return elem.getValue();
    }


    @Override
    public boolean isEmpty() {
        return sentinel.getNext() == sentinel;
    }

    @Override
    public void clear() {
        sentinel.setNext(sentinel);

    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public E get(int index) {
        Element elem = getElement(index);
        return (E) elem.getValue();
    }


    public E getValue(Element elem) {
        return elem.getValue();
    }

    @Override
    public E set(int index, E value) {
        Element elem = getElement(index);
        E retValue = (E) elem.getValue();
        elem.setValue(value);
        return retValue;
    }

    @Override
    public boolean add(E e) {
        Element newElem = new Element(e);
        Element prevElem = sentinel.getNext();


        if (prevElem == sentinel) {
            sentinel.setNext(newElem);
            newElem.setNext(sentinel);


        } else {

            while (prevElem.getNext() != sentinel) {
                prevElem = prevElem.getNext();
            }
            prevElem.setNext(newElem);
            newElem.setNext(sentinel);


        }
        return true;
    }

    @Override
    public boolean add(int index, E value) {
        Element newElem = new Element(value);
        if (index == 0) {
            newElem.setNext(sentinel.getNext());
            sentinel.setNext(newElem);
        } else {
            Element prevElem = getElement(index - 1);
            if (prevElem.getNext() == sentinel) {
                prevElem.setNext(newElem);
                newElem.setNext(sentinel);
            } else {
                newElem.setNext(prevElem.getNext());
                prevElem.setNext(newElem);
            }
        }
        return true;
    }

    @Override
    public boolean addBefore(String key, String keyvalue, E value) {
        Element keyelem = getElementKey(key, keyvalue);
        Element newElem = new Element(value);
        int index = indexOf(keyelem.getValue());
        if (index == 0) {
            newElem.setNext(sentinel.getNext());
            sentinel.setNext(newElem);


        } else {
            Element prevElem = getElement(index - 1);
            if (prevElem.getNext() == sentinel) {
                prevElem.setNext(newElem);
                newElem.setNext(sentinel);
            } else {
                newElem.setNext(prevElem.getNext());
                prevElem.setNext(newElem);
            }


        }


        return true;
    }

    @Override
    public boolean addAfter(String key, String keyvalue, E value) {
        Element keyelem = getElementKey(key, keyvalue);
        Element newElem = new Element(value);
        if (keyelem.getNext() == sentinel) {
            keyelem.setNext(newElem);
            newElem.setNext(sentinel);
        } else {
            newElem.setNext(keyelem.getNext());
            keyelem.setNext(newElem);

        }

        return true;
    }

    @Override
    public int indexOf(E value) {
        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel && !elem.getValue().equals(value)) {
            counter++;
            elem = elem.getNext();
        }
        if (elem == sentinel)
            return -1;
        return counter;
    }

    @Override
    public E remove(int index) {
        Element elem = getElement(index);
        if (index == 0) {
            sentinel.setNext(elem.getNext());
        } else {
            Element prevElem = getElement(index - 1);
            if (elem.getNext() != sentinel) {
                prevElem.setNext(elem.getNext());
            } else {
                prevElem.setNext(sentinel);
            }
        }
        return elem.getValue();

    }

    @Override
    public boolean remove(E value) {
        Element elem = getElement(value);
        if (sentinel.getNext() == elem) {
            sentinel.setNext(elem.getNext());
        } else {
            Element prevElem = getElement(indexOf(value) - 1);
            if (elem.getNext() != sentinel) {
                prevElem.setNext(elem.getNext());
            } else {
                prevElem.setNext(sentinel);
            }
        }

        return true;
    }

    public boolean removeKey(String key, String keyvalue) {
        Element delElem = getElementKey(key, keyvalue);
        if (sentinel.getNext() == delElem) {
            sentinel.setNext(delElem.getNext());

        } else {
            Element prevElem = getElement(indexOf(delElem.getValue()) - 1);

            if (delElem.getNext() != sentinel) {
                prevElem.setNext(delElem.getNext());
            } else {
                prevElem.setNext(sentinel);
            }
        }
        return true;


    }

    @Override
    public int size() {
        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel) {
            counter++;
            elem = elem.getNext();
        }
        return counter;
    }

    @Override
    public void printlist() {
        Element actElem = sentinel.getNext();
        while (actElem != sentinel) {
            System.out.println(actElem.getValue());
            actElem = actElem.getNext();
        }

    }

    public String executeMethod(E value) {
        try {
             Method method = value.getClass().getMethod(metodazkija());
            return method.invoke(value).toString();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);

        }


    }

    public String metodazkija() {
        return "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
    }


    @Override
    public Iterator<E> iterator() {
        return new OWCIterator();
    }

    private class OWCIterator implements Iterator<E> {

        Element _current = sentinel;

        @Override
        public boolean hasNext() {
            return _current.getNext() != sentinel;
        }

        @Override
        public E next() {
            _current = _current.getNext();
            return (E) _current.getValue();
        }

    }


    @Override
    public ListIterator<E> listIterator() {


        return new OWCListIterator();
    }


    private class OWCListIterator implements ListIterator<E> {

        Element _current = sentinel;

        @Override
        public boolean hasNext() {
            return _current.getNext() != sentinel;
        }

        @Override
        public E next() {
            _current = _current.getNext();
            return _current.getValue();
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
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
            OneWayCycledListWithSentinel.this.remove(_current.getValue());


        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
        public Element getnextElem(){
            _current=_current.getNext();
            return _current;
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

