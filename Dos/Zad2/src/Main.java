public class Main {
    public static void main(String[] args) {
        FibIterator fibIterator= new FibIterator(10);
        for (int i = 0; i <12 ; i++) {
            System.out.println(fibIterator.next());

        };
    }
}