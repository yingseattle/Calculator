public class ErrorMessage {
    public static void operandError(String str) {
        System.out.println("Invalid data format!  The invalid input is " + str);
        System.out.println("Mixed numbers will be represented by whole_numerator/denominator. e.g. \"3_1/4\"");
    }

    public static void operatorError(String str) {
        System.out.println("Invalid operator! The invalid input is " + str);
        System.out.println("invalid operator +, - , *, / ");
    }

    public static void divisionByZeroError() {
        System.out.println("Division by zero is undefined");
    }

    public static void expressionFormatError() {
        System.out.println("Invalid input error, either expression length or data format");
    }

    public static void mixNumberDivisionByZeroError(String str) {
        System.out.println("Mixed number division by zero is undefined! The invalid input is "+ str);
        System.out.println("Mixed numbers will be represented by whole_numerator/denominator. e.g. \"3_1/4\"");
    }

}
