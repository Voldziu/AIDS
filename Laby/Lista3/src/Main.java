public class Main {

    public static void main(String[] args) {
        TwoWayListWithSentino<Student> lista = new TwoWayListWithSentino();
        lista.add(new Student(1,200));
        lista.printlist();
        lista.add(new Student(2,230));
        lista.printlist();

        lista.add(new Student(3,400));
        lista.add(new Student(4,400));
        lista.add(new Student(5,400));

        lista.printlist();
        lista.listprint();
        lista.remove(4);
        lista.listprint();
        lista.printlist();
        lista.printlist();


    }
}