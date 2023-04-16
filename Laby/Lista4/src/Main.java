import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        TwoWayCycledListWithSentinel<Integer>  lol = new TwoWayCycledListWithSentinel<>();
//        Iterator<Integer> iterator = lol.iterator();
//        lol.add(1);
//        lol.add(0,2);
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        OneWayListWithSentinel<Integer> lol1 = new OneWayListWithSentinel<>();
        Iterator<Integer> iterator1 = lol1.iterator();
        lol1.add(1);
        lol1.add(2);
        lol1.add(0,3);
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        lol1.remove(1);
        iterator1 = lol1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}