import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DigitsCounterTest {
    DigitsCounter counter = new DigitsCounter();

    @Test
    public void digitsCounter() {
        assertEquals(10, counter.getNumberOfDigits(102322 * 12234));
        assertEquals(1, counter.getNumberOfDigits(1 + 1));
        assertEquals(2, counter.getNumberOfDigits(9 + 1));
        assertEquals(2, counter.getNumberOfDigits(10 + 2));
    }

}
