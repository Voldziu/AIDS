import java.util.Random;
import java.util.Scanner;

public class Menu {



    private static final KomparatorStudencki<Student> comp = new KomparatorStudencki<Student>();
    private static BST<Student> bst = new BST<Student>(comp);
    private static RedBullTree<Student> rb=new RedBullTree<Student>(comp);
    private static final Scanner scanner= new Scanner(System.in);
    public static void graj(){
        Random random = new Random();
        for (int i = 1; i <15 ; i++) {

            rb.insert(new Student(random.nextInt(100)));

        }
        menu();



    }

    private static void menu(){
        System.out.println("---------Witaj w Lesie--------");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1---Drzewo BST");
        System.out.println("2--- Drzewo RB");
        String drzewa = scanner.next();
        switch (drzewa){
            case "1":
                menubst();
            break;
            case "2":
                menurb();
            break;

            default:
                System.out.println("coś poszlo nietak");
        }




    }
    private static void menubst(){
        String in;
        do{
            System.out.println("---------Witaj w BST--------");
            System.out.println("Co chcesz zrobić?");
            System.out.println("1---Stworzyc nowe drzewo");
            System.out.println("2---Dodac nowy element");
            System.out.println("3---Usunac element");
            System.out.println("4---Wyszukac element");
            System.out.println("5--- Printowc drzewo");
            System.out.println("100--- Wyjsc");
             in = scanner.next();
            switch (in){
                case "1":
                    bst=new BST<Student>(comp);
                    break;
                case "2":
                    System.out.println("Podaj ID");
                    String innowe =scanner.next();
                    bst.insert(new Student(Integer.parseInt(innowe)));

                    break;
                case "3":
                    System.out.println("Podaj ID");
                    String inusun =scanner.next();
                    bst.delete(new Student(Integer.parseInt(inusun)));
                    break;
                case "4":
                    System.out.println("Podaj ID");
                    String inwyszukaj =scanner.next();
                    System.out.println(bst.find(new Student(Integer.parseInt(inwyszukaj))));
                    break;
                case "5":
                    bst.printTree();
                    break;

                default:
                    System.out.println("coś nietak");
            }

        }while (in !="100");






    }

    private static void menurb(){
        String in;
        do {
            System.out.println("---------Witaj w RB--------");
            System.out.println("Co chcesz zrobić?");
            System.out.println("1---Stworzyc nowe drzewo");
            System.out.println("2---Dodac nowy element");
            System.out.println("3---Usunac element");
            System.out.println("4---Wyszukac element");
            System.out.println("5--- Printowc drzewo");
            System.out.println("100--- Wyjść");
            in = scanner.next();

            switch (in){
                case "1":
                    rb=new RedBullTree<>(comp);

                    break;
                case "2":
                    System.out.println("Podaj ID");
                    String innowe =scanner.next();
                    rb.insert(new Student(Integer.parseInt(innowe)));

                    break;
                case "3":
                    System.out.println("Podaj ID");
                    String inusun =scanner.next();
                    rb.delete(new Student(Integer.parseInt(inusun)));
                    break;
                case "4":
                    System.out.println("Podaj ID");
                    String inwyszukaj =scanner.next();
                    System.out.println(rb.find(new Student(Integer.parseInt(inwyszukaj))));
                    break;
                case "5":
                    rb.printTree();
                    break;

                default:
                    System.out.println("coś nietak");
            }

        } while (in!="100");


    }
}
