import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       functionalTest();
    }

    private static void functionalTest() {
        // write your code here
        scenariosTest();
        Scanner sc = new Scanner(System.in);
        System.out.print("? ");
        String source = sc.nextLine();
        while (true) {
            evaluateOperations(source);
            System.out.print("? ");
            source = sc.nextLine();

        }
    }

    /**
     * Test case
     */
    private static void scenariosTest() {
        String source = "1/2 * 3_3/4";
        System.out.println("? " + source);
        evaluateOperations(source);

        source = "2_3/8 + 9/8";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "4 / 2 + 8 * 2 + 3_1/2";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "2 + 3 * 1/2";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "2 + 4 5";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "5 / 0";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "2/0";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "3.0";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "1 + a";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "1/2+3";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "1 & 8";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "7_";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "6_1";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "4_1/";
        System.out.println("\n? " + source);
        evaluateOperations(source);

        source = "";
        System.out.println("\n? " + source);
        evaluateOperations(source);
    }

    /**
     * Evaluate the output based on the input
     * @param source
     */
    private static void evaluateOperations(String source) {
        if (source.isEmpty()) {
            System.out.println("Please enter input data to calculate");
            return;
        }
        if (TokenParser.tokenParserValidation(source) && StringUtility.convertStringInputArrayToNewFormat()) {
            StackUtility stackUtility = new StackUtility();
            stackUtility.pushArrIntoStacks(StringUtility.getStrInputArr());
            double decimalNum = stackUtility.popupFromStacks();
            String decimalStr = Double.toString(decimalNum);
            String fractionStr = StringUtility.ConvertDecimalStrToFractionStrFormat(decimalStr );
            System.out.println("= " + fractionStr);
            stackUtility.clearStacks();
        }
        StringUtility.clearInputArr();

    }
}
