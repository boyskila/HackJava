import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    MathOperations operations = new MathOperations();
    Postfix pf = new Postfix();

    @Test
    public void addition() {

        assertEquals("555.73", operations.calculatePostfix(pf.createPostFix("234.5+321.23")) + "");
        assertEquals("4790.0", operations.calculatePostfix(pf.createPostFix("223+4567")) + "");

    }

    @Test
    public void factorial() {

        assertEquals("6.0", operations.calculatePostfix(pf.createPostFix("3!")) + "");
        assertEquals("720.0", operations.calculatePostfix(pf.createPostFix("6!")) + "");
        assertEquals("5040.0", operations.calculatePostfix(pf.createPostFix("7!")) + "");
        assertEquals("40320.0", operations.calculatePostfix(pf.createPostFix("8!")) + "");

    }

    @Test
    public void createPostfix() {

        assertEquals("30 10 2 * - ", pf.createPostFix("30-10*2"));
        assertEquals("222 333 + ", pf.createPostFix("222+333"));
        assertEquals("34.5 23 1.5 + * 2 / ", pf.createPostFix("34.5*(23+1.5)/2"));
        assertEquals("23 3 ! ^ 4 2 - * 2 2 ^ / ", pf.createPostFix("23^3!*(4-2)/2^2"));
    }

    @Test
    public void calculatePostfix() {

        assertEquals("10.0", operations.calculatePostfix("30 10 2 * - ") + "");

        assertEquals("40875.0", operations.calculatePostfix("222 333 8 ! + + ") + "");
        assertEquals("422.625", operations.calculatePostfix("34.5 23 1.5 + * 2 / ") + "");
        assertEquals("500000.0", operations.calculatePostfix("10 3 ! ^ 4 2 - * 2 2 ^ / ") + "");
    }
}
