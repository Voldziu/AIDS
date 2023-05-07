import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class SelectSort<T> extends SortingAlgorithm<T> {

    public SelectSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size= list.size();

        for (int i = 0,j=size-1; i <j ; i++,j--) {
            int minIndex = i;
            int maxIndex = i;
            for (int k = i; k<=j; k++) {
                int comparemin = comparator.compare(list.get(k), list.get(minIndex));
                int comparemax = comparator.compare(list.get(k), list.get(maxIndex));

                if(comparemin<0 ){
                    minIndex=k;

                } else if (comparemax >0) {
                    maxIndex=k;
                }

            }

            //swap min
            swapper.swap(list,minIndex,i);

            if(maxIndex==i){ // tu sprawdzamy czy shiftnelismy maxa w poprzednim kroku (pod minIndexem jest i-ty element, czyli max.
                swapper.swap(list,j,minIndex);
            } else  {

                swapper.swap(list,j,maxIndex);

            }


        }
        return list;
    }
}
