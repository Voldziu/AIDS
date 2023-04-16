import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayListWithSentino<E> implements IList<E>{
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public class Element{
        private E value;
        private Element next;
        private Element previous;

        public E getValue(){
            return value;

        }
        public void setValue(E data){
            this.value = data;
        }
        public Element getNext(){
            return next;
        }
        public Element getPrevious(){
            return previous;
        }
        public void setPrevious(Element previous){
            this.previous = previous;
        }
        public void setNext(Element next){
            this.next=next;

        }
        public void remove(){
            this.getNext().setPrevious(this.getPrevious());
            this.getPrevious().setNext(this.getNext());

        }
        Element(E data){
            this.value=data;
        }
    }

    private Element sentino = new Element(null);
    private Element tail = new Element(null);

    public TwoWayListWithSentino(){};

    @Override
    public boolean add(E element) {
        Element prevElem = sentino;
        Element newElem = new Element(element);

        while(prevElem.getNext() != null)
            prevElem=prevElem.getNext();
        prevElem.setNext(newElem);
        newElem.setPrevious(prevElem);
        tail=newElem;





        return true;
    }

    @Override
    public void add(int index, E element) {
        
        Element newElem = new Element(element);

        Element prevElem = sentino;
        while(index!=0){
            prevElem = prevElem.getNext();
            index--;

        }


            newElem.setNext(prevElem.getNext());
            prevElem.getNext().setPrevious(newElem);
            newElem.setPrevious(prevElem);
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

        Element actElem = sentino.getNext();
        while(index>0){
            index--;
            actElem=actElem.getNext();

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
    public int ElementIndexOf(Element element){
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
         Element returnElem = getElem(index);
         if(returnElem.getNext()!=null){
             returnElem.remove();
         } else{
             tail=returnElem.getPrevious();
             returnElem.getPrevious().setNext(null);

         }
         return returnElem.getValue();












    }

    @Override
    public boolean remove(E element) {
        if(sentino.getNext()==null){
            return false;
        }
        if(sentino.getNext().getValue().equals(element)){
            sentino.setNext(sentino.getNext().getNext());
            sentino.getNext().setPrevious(sentino);
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
        actElem.getNext().setPrevious(actElem);
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
        while(actElem!=null) {
            System.out.println(actElem.getValue());

            actElem=actElem.getNext();

        }
        System.out.println("-----");

    }
    public void listprint(){
        Element actElem = tail;
        while(actElem!=sentino) {
            System.out.println(actElem.getValue());

            actElem=actElem.getPrevious();


        }
        System.out.println("-------");
    }
}
