import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        VTS<Integer> stos = new VTS();
//        stos.push(1);
//        System.out.println(stos.pop());
//        System.out.println(stos.pop());

//        ReversedStack<Integer> rstos = new ReversedStack<>();
//        rstos.push(1);
//        rstos.push(2);
//        rstos.push(3);
//        rstos._list.printlist();
//        rstos.reverse();
//        rstos._list.printlist();



//        Queue2Stacks<Integer> q2 = new Queue2Stacks();
//        q2.enqueue(1);
//        q2.enqueue(2);
//        q2.enqueue(3);
//        System.out.println(q2.dequeue());
//        System.out.println(q2.dequeue());
//        q2.enqueue(4);
//        System.out.println(q2.dequeue());
//        q2.enqueue(1);
//        System.out.println(q2.dequeue());



        Flawiusz<Integer> flawiusz = new Flawiusz();
        flawiusz.enqueue(1);
        flawiusz.enqueue(2);
        flawiusz.enqueue(3);
        flawiusz.enqueue(4);
        flawiusz.enqueue(5);
        flawiusz.enqueue(6);
        flawiusz.enqueue(7);
        flawiusz.enqueue(8);
        System.out.println(flawiusz.flaviusProblem(3));








    }
}