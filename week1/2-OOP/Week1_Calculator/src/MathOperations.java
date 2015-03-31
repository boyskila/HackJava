import java.util.Stack;

public class MathOperations {

    public double calculateFactorial(double n) {

        long factorial = 1;
        for (int i = 1; i <= n; i++)
            factorial = factorial * i;

        return factorial;

    }

    public boolean isNumeric(String str) {

        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Double calculatePostfix(String postFix) {

        String[] pf = postFix.split(" ");
        Stack<Double> result = new Stack<Double>();

        for (String c : pf) {

            if (isNumeric(c)) {
                result.push(Double.valueOf(c));
            } else if (c.matches("[*-/+^!]")) {
                if (c.equals("*")) {
                    double x = result.pop();
                    double y = result.pop();
                    double sum = y * x;
                    result.push(sum);
                } else if (c.equals("/")) {
                    double x = result.pop();
                    double y = result.pop();
                    double sum = y / x;
                    result.push(sum);
                } else if (c.equals("+")) {
                    double x = result.pop();
                    double y = result.pop();
                    double sum = y + x;
                    result.push(sum);
                } else if (c.equals("-")) {
                    double x = result.pop();
                    double y = result.pop();
                    double sum = y - x;
                    result.push(sum);
                } else if (c.equals("!")) {
                    double x = result.pop();
                    double sum = calculateFactorial(x);
                    result.push(sum);
                } else if (c.equals("^")) {
                    double x = result.pop();
                    double y = result.pop();
                    double sum = Math.pow(y, x);
                    result.push(sum);
                }
            }
        }

        return result.pop();
    }
}
