public class Algorythms {
    public static void drawPiramid(int n, int h){
        String space=" ";
        String X="X";

        for (int i = 0; i <h ; i++) {
            String line;
            line = space.repeat(h-i-1)+ X.repeat(2*(n+i)+1)+space.repeat(h-i-1); //could be improved
            System.out.println(line);







        }

    }

    public static void drawAFigure(int n){
        String space=" ";
        String X="X";

        for (int i =0; i <n ; i++) {
            for (int j = i; j <n; j++) {
                String line=space.repeat(n-1-j)+X.repeat(2*j+1)+space.repeat(n-1-j);
                System.out.println(line);

            }



        }
    }
}
