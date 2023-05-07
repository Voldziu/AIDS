import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class InsertionSortLinear<T> extends SortingAlgorithm<T> {
    public InsertionSortLinear(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();
        for (int i = 1; i <size ; i++) {

            T key = list.get(i),temp;
            int j=i-1;
            while(j>=0 && comparator.compare(list.get(j),key)>0){
                swapper.swap(list,j+1,j);
                j--;

            }
            list.set(j+1,key);




        }
    return list;
    }
}
