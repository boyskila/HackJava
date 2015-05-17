public class TestsRepository {

    @Tester()
    public static void testJunit1() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, SimpleMethodsForTesting.fillArray(array));
        Junit.assertEquals(10, SimpleMethodsForTesting.devide(100, 10));
        Junit.assertEquals("Gosho", SimpleMethodsForTesting.conctaWords("Go", "sho"));
        Junit.assertEquals(22, SimpleMethodsForTesting.sum(20, 3));
    }
    @Tester()
    public static void testJunit2() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, SimpleMethodsForTesting.fillArray(array));
        Junit.assertEquals(12, SimpleMethodsForTesting.devide(100, 10));
        Junit.assertEquals("Hello Iva", SimpleMethodsForTesting.conctaWords("Hello", "Iva"));
        Junit.assertEquals(23, SimpleMethodsForTesting.sum(20, 3));
    }
   
    public static void testJunit3() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, SimpleMethodsForTesting.fillArray(array));
        Junit.assertEquals(10, SimpleMethodsForTesting.devide(100, 10));
        Junit.assertEquals("Gosho", SimpleMethodsForTesting.conctaWords("Go", "sho"));
        Junit.assertEquals(22, SimpleMethodsForTesting.sum(20, 3));
    }
    @Tester()
    public static void testJunit4() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, SimpleMethodsForTesting.fillArray(array));
        Junit.assertEquals(10, SimpleMethodsForTesting.devide(100, 10));
        Junit.assertEquals("Gosho", SimpleMethodsForTesting.conctaWords("go", "sho"));
        Junit.assertEquals(22, SimpleMethodsForTesting.sum(20, 3));
    }
}
