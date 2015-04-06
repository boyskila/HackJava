import java.util.Stack;

public class Postfix {

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == '!';
    }

    public int operatorPriority(char operator) {
        if (operator == '(')
            return 5;
        if (operator == '!')
            return 4;
        if (operator == '^')
            return 3;
        if (operator == '/' || operator == '*')
            return 2;
        if (operator == '+' || operator == '-')
            return 1;
        return 0;
    }

    public boolean validateString(String expression) {

        int parentCounter = 0;

        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')') {
                parentCounter++;
            }
            if (expression.charAt(i - 1) != '!' && isOperator(expression.charAt(i))) {
                if (isOperator(expression.charAt(i - 1)) && expression.charAt(i) == '!'
                        || isOperator(expression.charAt(i - 1)) && expression.charAt(i) == '+'
                        || isOperator(expression.charAt(i - 1)) && expression.charAt(i) == '-'
                        || isOperator(expression.charAt(i - 1)) && expression.charAt(i) == '*'
                        || isOperator(expression.charAt(i - 1)) && expression.charAt(i) == '/') {

                    return false;
                }
            }
        }
        if (parentCounter % 2 == 0) {
            return true;
        }
        return true;
    }

    public String createPostFix(String expression) {

        Stack<Character> operators = new Stack<Character>();
        StringBuilder postFix = new StringBuilder();

        if (validateString(expression)) {

            expression = "(" + expression + ")"; // put brackets at the end to
                                                 // activate last operation

            for (int i = 0; i < expression.length(); i++) {

                char c = expression.charAt(i);
                int counter = i;
                if (c == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        /*
                         * append operators to stringbuilder while stack not is
                         * empty or met left bracket
                         */
                        postFix.append(operators.pop());
                        postFix.append(" ");
                    }
                }
                if (c == '.') {
                    postFix.deleteCharAt(postFix.length() - 1);// delete
                                                               // whitespce and
                                                               // put dot
                    postFix.append(c);
                }

                if (c != '(' && Character.isDigit(c)) {

                    while (Character.isDigit(expression.charAt(counter++))) {

                        postFix.append(expression.charAt(counter - 1));

                    }

                    i = counter - 2;
                    postFix.append(" ");

                } else if (isOperator(c)) {
                    if (operators.isEmpty()) {
                        operators.push(c);
                    } else if (operators.peek() == '(' && c == '(') {
                        operators.push(c);
                    } else if (operators.peek() == '(') {
                        operators.pop();
                        operators.push(c);
                    } else if (operatorPriority(c) == operatorPriority(operators.peek())) {
                        operators.push(c);
                    } else if (operatorPriority(c) < operatorPriority(operators.peek())) {

                        // int check = operatorPriority(c);
                        boolean flag = false;

                        while (operatorPriority(operators.peek()) > operatorPriority(c)) {

                            postFix.append(operators.pop() + " ");
                            // operators.pop();
                            if (operators.isEmpty()) {
                                operators.push(c);
                                flag = true;
                            }
                        }
                        if (!flag) {
                            operators.push(c);
                        }

                    } else {
                        operators.push(c);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return postFix.toString();
    }
}
