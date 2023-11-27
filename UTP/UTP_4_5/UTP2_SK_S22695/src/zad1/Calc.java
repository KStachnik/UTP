/**
 *
 *  @author Stachnik Krystian S22695
 *
 */

package zad1;


import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Calc {

    public String doCalc(String cmd) {

        cmd = cmd.replaceAll("\\s+", "");

        StringTokenizer tokens = new StringTokenizer(cmd, "+-*/", true);

        if (tokens.countTokens() < 3) {
            return "Invalid command to calc";
        }

        String num1Str = tokens.nextToken();
        String operator = tokens.nextToken();
        String num2Str = tokens.nextToken();

        BigDecimal num1 = new BigDecimal(num1Str);
        BigDecimal num2 = new BigDecimal(num2Str);
        BigDecimal result;

        switch (operator) {
            case "+":
                result = num1.add(num2);
                break;
            case "-":
                result = num1.subtract(num2);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "/":
                result = num1.divide(num2, 7, BigDecimal.ROUND_HALF_UP);
                break;
            default:
                return "Invalid command to calc";
        }

        return result.stripTrailingZeros().toPlainString();

    }
}

