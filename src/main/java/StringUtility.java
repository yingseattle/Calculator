import java.util.ArrayList;

public class StringUtility {
    private static ArrayList<String> strInputArr = new ArrayList<String>();
    /**
     * change 14_1/2 to 14.5.
     */
    public static boolean convertStringInputArrayToNewFormat() {
        String convertStr = "";
        boolean isValid = true;

        for (int i = 0; i < strInputArr.size(); i++) {
            String tokenStr = strInputArr.get(i);
            int index = strInputArr.get(i).indexOf("_");
            if (index != -1) {
                convertStr = convertFractionStrToDoubleStrFormat(tokenStr, index);
                if (convertStr != null) {
                    strInputArr.set(i, convertStr);
                } else {
                    isValid = false;
                    break;
                }

            }
            else {
                if (tokenStr.equals("0") && strInputArr.get(i-1).equals("/")) {
                    isValid = false;
                    ErrorMessage.divisionByZeroError();
                    break;
                }
                else {
                    index = tokenStr.indexOf("/");
                    if (index != -1 && tokenStr.length() > 1) {
                        convertStr = convertFractionStr(tokenStr);
                        if (convertStr != null) {
                            strInputArr.set(i, convertStr);
                        } else {
                            isValid = false;
                            ErrorMessage.mixNumberDivisionByZeroError(tokenStr);
                            break;
                        }
                    }
                }
            }

        }
        return isValid;

    }

    /**
     * or example: Convert 12_1/4 to 12.25 or (12_1 was regarded as  12_1/1, then 13.0);
     * @param numStr
     * @param index
     * @return
     */
    public static String convertFractionStrToDoubleStrFormat(String numStr, int index) {
        String wholeDigStr =  numStr.substring(0, index );
        String fractionStr = numStr.substring(index + 1, numStr.length());
        index = fractionStr.indexOf("/");
        if (fractionStr.equals("") || (index == -1) || (fractionStr.length() - 1 == index)) {
            ErrorMessage.operandError(numStr);
            return null;
        }

        String[] fractionArr = fractionStr.split("/", 2);
        String decimalStr = convertFractionStr(fractionStr);
        if (decimalStr == null) {
            ErrorMessage.mixNumberDivisionByZeroError(numStr);
            return null;
        }
        double decimalD = Double.parseDouble(decimalStr );
        double result = Double.parseDouble(wholeDigStr) + decimalD;
        return Double.toString(result);
    }

    /**
     * only change format : 1/2, or 1/3, there is no whole part.
     * @param fractionStr
     * @return
     */
    private static String convertFractionStr(String fractionStr) {
        String[] fractionArr = fractionStr.split("/", 2);
        double decimalD;
        double numeratorD = Double.parseDouble(fractionArr[0]);
        double denominatorD = Double.parseDouble(fractionArr[1]);
        if (denominatorD != 0.0 || denominatorD != 0) {
            decimalD  =  numeratorD / denominatorD;
            return Double.toString(decimalD);
        }

        return null;
    }



    /**
     * For example: Convert 12.25 to 12_1/4, 12.0 to 12
     * @return
     */
    public static String ConvertDecimalStrToFractionStrFormat(String digWithDecimalStr) {
        int index = digWithDecimalStr.indexOf(".");
        String result = digWithDecimalStr;
        if (index != -1) {
            String wholeDStr = "";
            String decimalDStr = "";
            wholeDStr = digWithDecimalStr.substring(0, index);
            decimalDStr = digWithDecimalStr.substring(index);
            if ( decimalDStr.equals(".0")) {
                result = wholeDStr;
            }
            else {
                String rationalStr = "0" + decimalDStr;
                Rational rational = new Rational("0" + rationalStr);
                if (!wholeDStr.equals("0")) {
                    result = wholeDStr + "_" + rational.toString();
                } else {
                    result = rational.toString();
                }
            }

        }

        return result;

    }



    public static ArrayList<String> getStrInputArr() {
        return strInputArr;
    }

    public static void addStrInputArr(String tokenStr) {
        strInputArr.add (tokenStr);
    }

    public static void clearInputArr() {
        strInputArr.clear();
    }


}
