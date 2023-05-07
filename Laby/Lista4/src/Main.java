import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Maciek","Dudziak","301310313",27141);
        Student student4 = new Student("Karol","Popiołek","2210103",33333);
        Student student3 = new Student("Marcin","Michalowski","7777",44444);
        Student student2 = new Student("Łukasz","Lipski","301123403",11111);
        OneWayListWithSentinel<Student> OW = new OneWayListWithSentinel<>();
        OneWayCycledListWithSentinel<Student> OWC = new OneWayCycledListWithSentinel<>();
        TwoWayListWithSentinel<Student> TW = new TwoWayListWithSentinel<>();
        TwoWayCycledListWithSentinel<Student> TWC = new TwoWayCycledListWithSentinel<>();


        OWC.add(student1);
        OWC.add(student2);
        OWC.add(student3);
        OWC.add(student4);

        Iterator<Student> OWCiterator = OWC.listIterator();


        while(OWCiterator.hasNext()){
            System.out.println(OWCiterator.next());


            
        }
        System.out.println();
        OWC.removeKey("nazwisko","Dudziak");
        OWCiterator = OWC.listIterator();


        while(OWCiterator.hasNext()){
            System.out.println(OWCiterator.next());



        }
        System.out.println();
        OWC.SortByKey("nazwisko");
        OWCiterator = OWC.listIterator();


        while(OWCiterator.hasNext()){
            System.out.println(OWCiterator.next());



        }




//        TWC.add(student1);
//        TWC.add(student2);
//        TWC.add(student3);
//        TWC.add(student4);
//
//        Iterator<Student> TWCiterator = OWC.listIterator();
//
//        while(TWCiterator.hasNext()){
//            System.out.println(TWCiterator.next());
//        }







    }
}