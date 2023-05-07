import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertionLinked<T> extends SortingAlgorithm<T> {
    public InsertionLinked(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        LinkedList<T> linkedList = (LinkedList<T>) list;
        int size = linkedList.size();

        for (int i = 1; i <size ; ++i) {
            T key = linkedList.get(i);
            int j=i-1;
            int pos= binarySearch(linkedList,j,key);

            linkedList.remove(i);

            linkedList.add(pos,key);



        }

        return linkedList;
    }

    public int binarySearch(List<T> list,int right, T what ){
        int left=0;

        int middle;
        while(left<=right){
            middle=(left+right)/2;
            int compValue=comparator.compare(what,list.get(middle));

            if(compValue<0)
                right=middle-1;
            else
                left=middle+1;
        }
        return left; }
}
