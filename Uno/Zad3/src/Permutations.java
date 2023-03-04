import java.util.Arrays;

public class Permutations {
    public static int[] nextPermutation(int[] permutation) {
        int n=permutation.length;
        int i = permutation.length;
        //3,4,5,2,1
        //3,5,4,2,1
        //1, 2, 3, 5,4
        //1,2,5,3,4
        //1,2,4,3,5

        int right=permutation[n-1];

        int left=permutation[n-2];
        while(left>right){
            right=permutation[i-2];
            left=permutation[i-3];
            i--;


        }


        swap(permutation,i-2,i-1);
        if(i<n) {

            swap(permutation, i - 2, n - 1);
        }














        return permutation;





    }

    public static void swap(int[] tab,int leftindex, int rightindex){
        int temp;
        temp=tab[leftindex];
        tab[leftindex]=tab[rightindex];
        tab[rightindex]=temp;



    }
    public static void PrintOut(int[] tab){
        System.out.println(Arrays.toString(tab));
    }
}
