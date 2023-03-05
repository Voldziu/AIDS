import java.util.Arrays;

public class Permutations {
    public static int[] nextPermutation(int[] permutation) {
        int n=permutation.length;
        int swapindex = permutation.length;
        //3,4,5,2,1
        //3,5,4,2,1
        //1, 2, 3, 5,4
        //1,2,5,3,4
        //1,2,4,3,5

        int right=permutation[n-1];

        int left=permutation[n-2];
        while(left>right){
            right=permutation[swapindex-2];
            left=permutation[swapindex-3];
            swapindex--;


        }
        int leftindex=swapindex-2;
        int rightindex=swapindex-1;
        if(swapindex==n){
            swap(permutation,n-2,n-1);
        } else {
            int min=99999999;
            int minindex=n-1;
            for(int i=n-1;i>leftindex;i--){
                if(permutation[i]<min && permutation[i]>left){
                    min = permutation[i];
                    minindex = i;

                }



            }
            swap(permutation,leftindex,minindex);


            BubbleSort(permutation,swapindex-1);

        }



















        return permutation;





    }

    public static void swap(int[] tab,int leftindex, int rightindex){
        int temp;
        temp=tab[leftindex];
        tab[leftindex]=tab[rightindex];
        tab[rightindex]=temp;



    }
    public static void BubbleSort(int[] tab,int startingindex){
        int n= tab.length;
        for (int i = startingindex; i <n ; i++) {
            for (int j = startingindex; j < n-1; j++) {
                if(tab[j]>tab[j+1]){
                      swap(tab,j,j+1);
                }

            }

        }
    }
    public static void PrintOut(int[] tab){
        System.out.println(Arrays.toString(tab));
    }

}
