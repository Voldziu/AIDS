public class ONP {
    private static Stack stack = new Stack();
    public static void Convert(String statement){
        String result ="";
        boolean sign = true;

        statement = statement.replace(" ","");

        for (int i = 0; i <statement.length() ; i++) {
            if(statement.charAt(i)=='('){
                stack.push("(");
                sign=true;
                result+=" ";
                
            } else if (statement.charAt(i)==')') {
                result+= " "+getUntilBracket();
                sign =false;
                
            } else if ((statement.charAt(i) == '+' ||
                    statement.charAt(i) == '-' ||
                    statement.charAt(i) == '*' ||
                    statement.charAt(i) == '/') && !sign) {
                result+=" " + getFromStack(statement.substring(i,i+1));
                sign=true;
                
            }else{
                if(sign && statement.charAt(i)=='-'){
                    result+=" ";
                }
                result+=statement.charAt(i);
                sign=false;
            }

        }
        result+=getAll();
        result=result.replace(" ","");
        System.out.println("ONP: "+result);

    }
    public static String getUntilBracket(){
        String result = "";
        String c = null;
        if (!stack.isEmpty()) {
            c = (String) stack.pop();
            while (!c.equals("(")){
                result = result + " " + c;
                if (stack.isEmpty()) break;
                c = (String) stack.pop();
            }
        }
        if (result.length() > 0) {
            result = " " + result;
        }
        return result;

    }
    public static String getFromStack(String operator){
        String result = "";
        String c = null;
        if (!stack.isEmpty()) {
            c = (String) stack.pop();
            while (((operator.equals("+") || operator.equals("-")) && !c.equals("(")) ||
                    ((operator.equals("/") || operator.equals("*")) && (c.equals("/") || c.equals("*")))){
                result += " " + c;
                if (stack.isEmpty()) break;
                c = (String) stack.pop();
            }
            stack.push(c);
        }
        stack.push(operator);

        return result;


    }

    public static String getAll(){
        String result = "";
        String c = null;
        while (!stack.isEmpty()){
            c = (String) stack.pop();
            result += " " + c;
        }
        return result;

    }

}
