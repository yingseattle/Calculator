public class Rational {

    private int numerator, denominator;

    public Rational(String string) {
        double d = Double.parseDouble(string);
        int digitsDec = string.length() - 1 - string.indexOf('.');

        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
            d *= 10;
            denom *= 10;
        }

        int num = (int) Math.round(d);
        int gcd = gcd(num, denom);

        this.numerator = num / gcd;
        this.denominator = denom /gcd;
    }


    public Rational(int num, int denom) {
        this.numerator = num;
        this.denominator= denom;
    }

    public int gcd(int numerator, int denom) {
        return denom == 0 ? numerator : gcd(denom, numerator % denom);
    }


    public String toString() {
        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }

}