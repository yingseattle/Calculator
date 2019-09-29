import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class TokenParser {

    public static boolean isValidNumberStr(String numStr) {
        String regexp = "[-]?[0-9]*[_]?[0-9]*[/]?[1-9]*[0-9]*";
        if (!Pattern.matches(regexp, numStr)) {
            ErrorMessage.operandError(numStr);
            return false;
        }
        return true;
    }

    public static boolean isValidOperatorStr(String numStr) {
        String regexp = "[+*/-]";
        if (!Pattern.matches(regexp, numStr)) {
            ErrorMessage.operatorError(numStr);
            return false;
        }

        return true;
    }

    /**
     * Validate each token string based the position in the expression.  operand (odd position) or operator (even position).
     * @param tokenStr
     * @param index : The position : operand (odd position) or operator (even position).
     * @return boolean.
     */
    public static boolean isInputStrValid (String tokenStr, int index) {
        boolean isValid = true;
        if ( index % 2 == 0) {
            isValid = isValidNumberStr(tokenStr);
        }
        else {
            isValid = isValidOperatorStr(tokenStr);
        }

        return isValid;
    }

    /**
     * Validate each token string based the position in the expression. on the type: operand or operator.
     * @param inputStr : the input string to be verified.
     * @return boolean : true or false;
     */

    static boolean tokenParserValidation(String inputStr) {
        boolean isValid = true;
        int i = 0;
        StringTokenizer st = new StringTokenizer(inputStr);
        if (st.countTokens() % 2 == 0) {
            isValid = false;
            ErrorMessage.expressionFormatError();
        }

        while (st.hasMoreTokens() && isValid) {
            String tokenStr = st.nextToken();
            isValid = isInputStrValid(tokenStr , i);
            if (isValid) {
                StringUtility.addStrInputArr(tokenStr );
            }
            i++;
        }

        if (!isValid) {
            StringUtility.clearInputArr();
        }
        return isValid;
    }


}
