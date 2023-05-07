import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class CocktailSort<T> extends SortingAlgorithm<T> {

    public CocktailSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();
        int bottom = 0;
        int top = size-1;
        boolean swapped=true;
        while (swapped == true) {
            swapped=false;
            for (int i = bottom ; i < top; i++) {
                int compValue = comparator.compare(list.get(i), list.get(i + 1));
                if (compValue > 0) {
                    swapper.swap(list, i, i + 1);
                    swapped = true;
                }
            }
            top--;
            for (int j = top; j >bottom ; j--) {
                int Valuecomp = comparator.compare(list.get(j),list.get(j-1));
                    if(Valuecomp <0){
                        swapper.swap(list,j,j-1);
                        swapped=true;
                    }
                }
            bottom++;





            }
        return list;
        }

    }

