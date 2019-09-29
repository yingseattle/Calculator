public class Calculator {
    double num1;
    double num2;
    char op;
    public Calculator(char op, double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public double calculating() {
        double ans = 0.0;
        switch(op) {
            case '+': ans = add(num1, num2);
                break;
            case '-': ans = subtract(num1, num2);
                break;
            case '*': ans = multiply(num1, num2);
                break;
            case '/': ans = division(num1, num2);
                break;
            default:  System.out.println("Error! Enter correct operator");

        }
        return ans;
    }



    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * stack,  3 - 2 pop up order : num1: 2 , num2 : 3, so num2 - num1;
     * @param num1
     * @param num2
     * @return
     */
    public double subtract(double num1, double num2) {
        return num2 - num1;

    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * stack,  4  / 2 pop up order : num1: 2 , num2 : 4, so num2 / num1;
     * @param num1
     * @param num2
     * @return
     */
    public double division (double num1, double num2) {
        return num2 / num1;
    }

}
