import java.util.ArrayList;
import java.util.Arrays;

public class Algorythms {
    public static void PairSwap(String text,String pattern) {
        System.out.println(text);
        String[] words = text.split(" ");
        String res="";
        int patternstartindex;
        for (int i = 0; i < words.length; i++) {
            patternstartindex=kmp(words[i],pattern);


            if(!(patternstartindex==-1)){
                res= res+ swap(words[i],pattern);

            }else{
                res+=words[i];
            }






        }
        System.out.println(res);


    }
    public static int findEquals(String word){
        int n = word.length();

        int i=0;
        while(i<n){
            if(word.charAt(i)=='='){

                return i;

            } else{
                i++;
            }
        }

        return -1;
    }

    public static String swap(String word,String pattern) {
        int wordindex=findEquals(word);
        int patternlength= pattern.length();
        int patternindex= findEquals(pattern);
        String res="";
        char ISign=' ';


        ArrayList<Character> InterpunctionSigns = new ArrayList<Character>(Arrays.asList(',', ';', '.', '!', '?',':'));
        if(InterpunctionSigns.contains(word.charAt(word.length()-1))){
            ISign=word.charAt(word.length()-1);
            word=word.substring(0,word.length()-1);
        }



        char[] chars = word.toCharArray();
        for (int i = wordindex+1; i <chars.length; i++) {
            res+=chars[i];

        }
        res+="=";
        for (int i = 0; i <wordindex ; i++) {
            res+=chars[i];

        }
        if(ISign!=' '){
            return res+ISign+" ";
        }else{
            return res+" ";
        }





















    }
    public static int kmp(String text, String pattern){
        int[] preffixsuffixtab = makeminipatterns(pattern);

        int i=0,j=0;
        while(i<text.length()){

            if(text.charAt(i)!=pattern.charAt(j)){
                if(j==0){
                    i++;
                } else {
                    j=preffixsuffixtab[j-1];

                }

            } else{
                i++;
                j++;
            }
            if(j==pattern.length()){

                return i-pattern.length();
            }


        }

        return -1;


    }

    public static int[] makeminipatterns(String pattern){
        int[] res = new int[pattern.length()];
        int j=0;
        int i=1;
        while(i<pattern.length()){
            if(pattern.charAt(i)!=pattern.charAt(j)){
                if(j==0){
                    i++;
                } else {
                        j=res[j-1];


                }


            } else {
                res[i]=j+1;
                i++;
                j++;
            }

        }





        return res;
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






