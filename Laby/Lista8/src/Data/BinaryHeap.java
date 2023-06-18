package Data;

import java.util.ArrayList;
import java.util.Comparator;

public class BinaryHeap<T> {
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public BinaryHeap(Comparator<T> comparator){
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void enqueue(T value){
        heap.add(value);
        swim(heap.size()-1);
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public T dequeue(){
        T result = heap.get(0);
        if(heap.size() > 1){
            heap.set(0, heap.get(heap.size()-1));
            sink(0);
        }
        heap.remove(heap.size()-1);
        return result;
    }
    private void swim(int index){
        int parent;
        while(index != 0 && comparator.compare(heap.get(index), heap.get(parent = (index - 1)/ 2)) < 0){
            swap(index, parent);
            index = parent;
        }
    }
    private void sink(int index){
        boolean isDone = false;
        int child;
        while(!isDone && (child = 2*index + 1) < heap.size()){
            if(child < heap.size() - 1 && comparator.compare(heap.get(child), heap.get(child + 1)) > 0){
                child++;
            } if(comparator.compare(heap.get(index), heap.get(child)) > 0){
                swap(index, child);
            } else {
                isDone = true;
            }
        }
    }
    private void swap(int index, int parent){
        T temp = heap.get(index);
        heap.set(index, heap.get(parent));
        heap.set(parent, temp);
    }

}
