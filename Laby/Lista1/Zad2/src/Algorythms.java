import java.util.ArrayList;
import java.util.Arrays;

public class Algorythms {
    public static void pairSwap(String text) {
        System.out.println(text);
        String[] words = text.split(" ");
        String res="";
        for (int i = 0; i < words.length; i++) {

            if (words[i].contains("=")&&ifswap(words[i])) {
                res= res+swap(words[i])+" ";



            } else {
                res = res +words[i]+" ";
            }


        }
        System.out.println(res);


    }

    public static String swap(String text) {
        String[] tuple = text.split("=");

        Character suffix;
        ArrayList<Character> InterpunctionSigns = new ArrayList<Character>(Arrays.asList(',', ';', '.', '!', '?',':'));
        if(InterpunctionSigns.contains(tuple[1].charAt(tuple[1].length()-1))){
            suffix=tuple[1].charAt(tuple[1].length()-1);
            tuple[1]=tuple[1].substring(0,tuple[1].length()-1);
            return tuple[1] + "=" + tuple[0]+ suffix;




        }else {
            return tuple[1] + "=" + tuple[0];
        }



    }


    public static boolean ifswap(String text) {
        ArrayList<Character> InterpunctionSigns = new ArrayList<Character>(Arrays.asList(',', ';', '.', '!', '?',':'));
        String[] tuple = text.split("=");
        if(tuple.length>2){ // checking if there is id====id multiple "="
            return false;
        } else{
            int i=0;
            boolean IsCrashed = false;

            if(InterpunctionSigns.contains(tuple[1].charAt(tuple[1].length()-1))){
                tuple[1]=tuple[1].substring(0,tuple[1].length()-1);


            }

            while (i < tuple.length && !IsCrashed) {
                int j=1;

                if (!((Character.isLetter(tuple[i].charAt(0))) || (tuple[i].charAt(0) == '_'))) {
                    IsCrashed = true;
                    System.out.println("1");
                    return false;

                } else {
                    while (j < tuple[i].length() && !IsCrashed) {
                        if (!((Character.isLetterOrDigit(tuple[i].charAt(j))))) {
                            IsCrashed = true;
                            System.out.println("2");
                            return false;
                        }
                        j++;
                    }
                }
                i++;
            }
            return true;
        }


        }


}






