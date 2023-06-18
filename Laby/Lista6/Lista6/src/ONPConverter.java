public class ONPConverter {

    public static String convertToONP(String expression) {
        String[] tokens = expression.split(" ");
        Stack<String> operatorStack = new Stack<String>();
        StringBuilder output = new StringBuilder();
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                output.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && hasHigherOrEqualPrecedence(token, operatorStack.peek())) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(" ");
        }
        return output.toString();
    }

    private static boolean hasHigherOrEqualPrecedence(String operator1, String operator2) {
        return getOperatorPrecedence(operator1) <= getOperatorPrecedence(operator2);
    }

    private static int getOperatorPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":

            case "<=>":
                return 1;
            case "*":
            case "/":

            case "=>":
                return 2;
            case "∨":

                return 3;
            case "∧":
                return 4;

            case "!":
                return 5;

            default:
                return -1;
        }
    }


    public static String logicToONP(String expression) {
        String[] tokens = expression.split(" ");
        Stack<String> operatorStack = new Stack<String>();
        StringBuilder output = new StringBuilder();
        for (String token : tokens) {
            if (token.matches( "[A-Za-z]+")) {
                output.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && hasHigherOrEqualPrecedence(token, operatorStack.peek())) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(" ");
        }
        return output.toString();
    }
}

