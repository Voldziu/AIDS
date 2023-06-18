import java.util.*;

public class Calculator {
    public static int calculate_ONP(String expression) {
        expression = ONPConverter.convertToONP(expression);
        Stack<Integer> stack = new Stack<Integer>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
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

    public static boolean calculate_logic_ONP(String expression, Map<String, Boolean> values) {
        expression = ONPConverter.logicToONP(expression);
        Stack<Boolean> stack = new Stack<Boolean>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if ( token.equals("∧") ) {
                boolean b = stack.pop();
                boolean a = stack.pop();
                stack.push(a && b);
            } else if ( token.equals("∨")) {
                boolean b = stack.pop();
                boolean a = stack.pop();
                stack.push(a || b);
            } else if (token.equals("!") ) {
                boolean a = stack.pop();
                stack.push(!a);
            }
            else if (token.equals("<=>") ) {
                boolean b = stack.pop();
                boolean a = stack.pop();
                stack.push(a == b);
            }
            else if (token.equals("=>")) {
                boolean b = stack.pop();
                boolean a = stack.pop();
                stack.push(!a || b);
            }
            else {
                stack.push(values.get(token));
            }
        }
        return stack.pop();
    }


}