import java.util.*;

public class ONPConverter {

    public static String convertToONP(String input) {
        Stack<String> operatorStack = new Stack<String>();
        ArrayList<String> outputList = new ArrayList<String>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                outputList.add(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && shouldPop(operatorStack.peek(), token)) {
                    outputList.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    outputList.add(operatorStack.pop());
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            outputList.add(operatorStack.pop());
        }

        String result="";
        for (int i = 0; i <outputList.size() ; i++) {
            result+=outputList.get(i)+" ";


        }

        return result;
    }

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    public static int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean shouldPop(String topOperator, String newOperator) {
        if (topOperator.equals("(")) {
            return false;
        }
        int topPrecedence = precedence(topOperator);
        int newPrecedence = precedence(newOperator);
        if (topPrecedence > newPrecedence) {
            return true;
        } else if (topPrecedence == newPrecedence && (topOperator.equals("^") || newOperator.equals("^"))) {
            return false;
        } else {
            return false;
        }
    }
}

