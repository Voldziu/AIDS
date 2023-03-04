public class SecondSmallest {
    public static int returnSecondSmallest(int[] Stream) throws NoAnswerException {
        int min = Stream[0];
        int min2 = Stream[1];
        int temp;
        if(min>min2){
            temp=min2;
            min2=min;   //Reverse the min2 with min (in case when min2 is smaller than min)
            min=temp;


        }
        for (int i = 2; i < Stream.length; i++) {
            if (Stream[i] < min) {
                min2 = min;
                min = Stream[i];
            } else if (Stream[i] < min2 && Stream[i] != min) {
                min2 = Stream[i];
            }


        }


        if (min2 == min || Stream.length==0) {
            throw new NoAnswerException();

        }else {
            return min2;
        }


    }

}
