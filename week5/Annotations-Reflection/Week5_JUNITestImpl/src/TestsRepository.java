
public class TestsRepository {
   public static SimpleMethodsForTesting methodForTesting ;

    @Tester
    public static void testJunit1() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, methodForTesting.fillArray(array));
        Junit.assertEquals(10, methodForTesting.devide(100, 10));
        Junit.assertEquals("Gosho", methodForTesting.conctaWords("Go", "sho"));
        Junit.assertEquals(22, methodForTesting.sum(20, 3));
    }

    @BeforeMethods
    public void setup() {
        methodForTesting = new SimpleMethodsForTesting();
        System.out.println("New instance is created");
    }


    @Tester
    public static void testJunit2() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, methodForTesting.fillArray(array));
        Junit.assertEquals(12, methodForTesting.devide(100, 10));
        Junit.assertEquals("Hello Iva", methodForTesting.conctaWords("Hello", "Iva"));
        Junit.assertEquals(23, methodForTesting.sum(20, 3));
    }

    public static void testJunit3() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, methodForTesting.fillArray(array));
        Junit.assertEquals(10, methodForTesting.devide(100, 10));
        Junit.assertEquals("Gosho", methodForTesting.conctaWords("Go", "sho"));
        Junit.assertEquals(22, methodForTesting.sum(20, 3));
    }

    @Tester
    public static void testJunit4() {
        byte[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 5, 6 };
        byte[] array = new byte[10];
        Junit.assertEquals(arr, methodForTesting.fillArray(array));
        Junit.assertEquals(10, methodForTesting.devide(100, 10));
        Junit.assertEquals("Gosho", methodForTesting.conctaWords("go", "sho"));
        Junit.assertEquals(22, methodForTesting.sum(20, 3));
    }
    @AfterMethods
    public void tearDown() {
        System.out.println("If you allocate external resources in a Before method you need " + "\n"
                + "to release them after the test runs. Annotating a public void method with" + "\n"
                + " @After causes that method to be run after the Test method. All @After" + "\n"
                + " methods are guaranteed to run even if a Before or Test method throws an" + "\n"
                + " exception. The @After methods declared in superclasses will be run after " + "\n"
                + "those of the current class.");
    }
}
