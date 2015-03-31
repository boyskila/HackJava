import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Postfix postfix = new Postfix();
        MathOperations calculate = new MathOperations();
        System.out.println("Hello!");
        System.out.println("Enter expression:> ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String expression = sc.nextLine();
            if (expression.equals("exit")) {
                sc.close();
                System.out.println("bye!");
                return;
            } else {
                System.out.println("Enter expression:> ");
                System.out.printf("Output:> %s\n", calculate.calculatePostfix(postfix.createPostFix(expression)));
            }
        }
    }
}
