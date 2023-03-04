public class Main {
    public static void main(String[] args) throws NoAnswerException {
        int[] nums = new int[]{5,1,2,9,3,7,5,2,1};
        try {
            System.out.println(SecondSmallest.returnSecondSmallest(nums));
        } catch (NoAnswerException e) {
            e.printStackTrace();
        }


    }
}