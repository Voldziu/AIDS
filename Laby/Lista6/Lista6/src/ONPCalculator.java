import java.util.HashMap;
import java.util.Map;

public class ONPCalculator {
    public static double calculate_ONP(String ONP) {

        ListStack<Double> stack = new ListStack<Double>();
        String[] tokens = ONP.split(" ");
        for (String token : tokens) {
            System.out.println(token);
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b  = stack.pop();
                double a = stack.pop();
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }

    public static int calculate_logic_ONP(String ONP, HashMap<String, Integer> values) {

        ListStack<Integer> stack = new ListStack<Integer>();
        String[] tokens = ONP.split(" ");
        for (String token : tokens) {
            System.out.println(token);
            if ( token.equals("∧") ) {
                int b = stack.pop();
                int a = stack.pop();
                if(a==1 && b==1){
                    stack.push(1);
                }else {
                    stack.push(0);
                }

            } else if ( token.equals("v")) {
                int b = stack.pop();
                int a = stack.pop();
                if(a==0&b==0){
                    stack.push(0);
                } else{
                    stack.push(1);
                }

            } else if (token.equals("!")) {
               int a = stack.pop();
                if(a==1){
                    stack.push(0);
                }else{
                    stack.push(1);
                }
            }
            else if (token.equals("<=>")) {
                int b = stack.pop();
                int a = stack.pop();
                if(a==b){
                    stack.push(1);
                } else{
                    stack.push(0);
                }

            }
            else if (token.equals("=>")) {
                int b = stack.pop();
                int a = stack.pop();

                if(a==1 && b==0){
                    stack.push(0);
                } else{
                    stack.push(1);
                }


            }
            else {
                stack.push(values.get(token));
            }
        }
        return stack.pop();
    }
}
