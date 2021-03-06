import java.util.Random;

public class SimpleMethodsForTesting {

    public int sum(int a, int b) {
        return a + b;
    }

    public int devide(int a, int b) throws IllegalArgumentException {
        return a / b;
    }

    public byte[] fillArray(byte[] arr) {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            arr[i] = (byte) r.nextInt();
        return arr;
    }

    public String conctaWords(String word1, String word2) {
        return word1.concat(word2);
    }

    @Tester
    public void someMethodForTesting() {
        Junit.assertEquals("Pesho", conctaWords("Pe", "sho"));
    }
}
