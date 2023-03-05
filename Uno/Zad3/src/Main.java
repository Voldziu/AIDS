import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] permutation = new int[]{1,2,3,4,5};
        for (int i = 0; i <119; i++) {
            Permutations.nextPermutation(permutation);
            Permutations.PrintOut(permutation);


        }



    }
}