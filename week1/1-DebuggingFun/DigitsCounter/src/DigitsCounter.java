
public class DigitsCounter {

    public int getNumberOfDigits(int number) {

        int result;
        for (result = 0; number > 0; result++) {
            number /= 10;
        }
        return result;
    }

    public void areNumbersEquals(int answer, int question) {

        if (answer == question) {
            System.out.println("passed the test");
        } else {
            System.out.println("did not pass the test");
        }
    }

    public static void main(String[] args) {
        DigitsCounter counter = new DigitsCounter();
        System.out.println(counter.getNumberOfDigits(100 + 2));
        counter.areNumbersEquals(3, counter.getNumberOfDigits(100 + 2));
    }
}
