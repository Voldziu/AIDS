import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,81,4,1,4,5,2,4,1,2,5,1,2,4,2,5,6,1,7,123,456};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<Integer>(numbers);
        InteratorK<Integer> interatorK= new InteratorK<Integer>();
        KFilterIterator<Integer> kFilterIterator = new KFilterIterator<Integer>(arrayIterator,interatorK,2);
        while(kFilterIterator.hasNext()){
            System.out.println(kFilterIterator.next());
        }

    }
}