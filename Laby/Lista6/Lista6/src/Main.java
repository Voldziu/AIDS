import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //∧


        String algebraic1 = "5 * ( ( 3 - 7 ) * 2 - 3 * ( 5 + 1 ) ) - 3";
        String logic1 = "p v ! p";
        String logic2  = "( ( p => r ) ∧ ( q => r ) ) ∨ ( ( p ∨ q ) => r )";
        String logic3 = "! ( p v q ) <=> ! p ∧ ! q";
        String logic4= "p";

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("p",1);
        map.put("q",0);
        map.put("r",1);

        System.out.println(Converter.convertToONP(algebraic1));
//        System.out.println(Converter.logicToONP(logic3));

        System.out.println(ONPCalculator.calculate_logic_ONP(Converter.logicToONP(logic3),map));
        System.out.println(ONPCalculator.calculate_ONP(Converter.convertToONP(algebraic1)));



    }
}