public class Main {

    public static void main(String[] args) {
        OneWayListWithSentino<Student> lista = new OneWayListWithSentino();
        lista.add(new Student(1,200));
        lista.printlist();
        lista.add(new Student(2,230));
        lista.printlist();
        lista.add(new Student(3,400));
        lista.printlist();
        lista.remove(1);
        lista.printlist();



    }
}