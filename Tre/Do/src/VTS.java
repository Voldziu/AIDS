public class VTS<E> extends ListStack<E>{
    int cursor_index;

    public VTS(){
        cursor_index=0;
    };

    public void CursorOnTop(){
        cursor_index=0;
    }
    public void GoDown(){
        cursor_index++;
        if(cursor_index== _list.size()-1){
            System.out.println("Reached Stack limit");
        }

    }

    @Override
    public E pop() {
        CursorOnTop();
        return super.pop();
    }

    @Override
    public void push(E elem) {
        CursorOnTop();
        super.push(elem);
    }

    public E peek(){
        E value= _list.get(cursor_index);
        return value;
    }
}
