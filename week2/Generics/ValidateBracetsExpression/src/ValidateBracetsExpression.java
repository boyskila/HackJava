
public class ValidateBracetsExpression {

    static boolean checkBracketsExpresion(String expression) {

        int bracketsCounter = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {

                bracketsCounter++;
            } else {
                if (bracketsCounter == 0) {
                    return false;
                }
                bracketsCounter--;

            }
        }

        return bracketsCounter == 0;

    }

    public static void main(String[] args) {
        System.out.println(checkBracketsExpresion("(())"));
    }
}
