import java.util.Comparator;
import java.util.List;


import core.SortingAlgorithm;

public class InsertionSort<T> extends SortingAlgorithm<T>{
    public InsertionSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();
        for (int i = 1; i <size ; ++i) {
            T key = list.get(i);
            int j=i-1;
            int pos= binarySearch(list,j,key);
            while(j>=pos ){
                swapper.swap(list,j,j+1);
                j--;
            }
//            list.set(pos,key);



        }

        return list;
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
