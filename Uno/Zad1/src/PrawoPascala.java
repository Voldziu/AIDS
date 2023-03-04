import java.util.Arrays;

public  class PrawoPascala {
    public static int[] NextPascalLine(int[] T){
        int[] returnedline =new int[T.length+1];
        returnedline[0]=1;
        returnedline[returnedline.length-1]=1;
        for (int i = 0;i<T.length-1 ; i++) {
            returnedline[i+1]=T[i]+T[i+1];




        } return returnedline;


    }
    public static void PrintOut(int[] T){
        System.out.println(Arrays.toString(T));
    }
    public static void PrintPiramid(int n){
        int[] previous = new int[]{1};
        int[] next;
        for (int i = 0; i < n; i++) {
            PrintOut(previous);
            next=NextPascalLine(previous);
            previous=next;


        }

    }

}
