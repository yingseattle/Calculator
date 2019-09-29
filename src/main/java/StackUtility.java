import java.util.ArrayList;
import java.util.Stack;

public class StackUtility {
    // the stack maintains all numbers.
    public Stack<Double> numStack;
    // the stack maintains all operators "+, -, *, /"
    public Stack<String> operatorStack;

    public StackUtility() {
        numStack = new Stack<Double>();
        operatorStack = new Stack<String>();
    }

    public void pushArrIntoStacks(ArrayList<String> strArr) {
        for (int i = 0; i < strArr.size(); i++) {
           if (i % 2 == 0) {
               double nextNum = Double.parseDouble(strArr.get(i));
               pushNumberIntoStack(nextNum);
           }
           else {
               operatorStack.push(strArr.get(i));
           }
        }
    }

    public double popupFromStacks() {
        while (!operatorStack.isEmpty()) {
            String op = operatorStack.pop();
            numStack.push( calculateNumbers(op));
        }
        if (numStack.size() == 1) {
            return numStack.pop();
        }
        else {
            return 0;
        }


    }

    private void pushNumberIntoStack (double nextNum){
        numStack.push(nextNum);
        //
        if (!operatorStack.isEmpty()) {
            String op = operatorStack.peek();
            if (op.equals("*") || op.equals("/")) {
                numStack.push(calculateNumbers(op));
                operatorStack.pop();
            }
        }
    }

    private double calculateNumbers (String op) {
        double num1 = numStack.pop();
        double num2 = numStack.pop();
        char opChar = op.charAt(0);
        Calculator cal = new Calculator(opChar, num1, num2);
        return cal.calculating();
    }

    public void clearStacks() {
        numStack.clear();
        operatorStack.clear();
    }


}
