import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String pattern ="AB=CDa";
        String text1="LubAB=Ca lolololAB=a";
        Algorythms.PairSwap(text1,pattern);







        System.out.println(Arrays.toString(Algorythms.makeminipatterns("ababcfabcfabcdabce")));
        System.out.println(Algorythms.kmp("ababcfabcfabcdabce","abcf"));
        System.out.println("ababcfabcfabcdabce");
        System.out.println(Algorythms.swap("zuj=muj","j=m"));
    }
}