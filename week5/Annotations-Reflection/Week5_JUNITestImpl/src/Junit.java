import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Junit {
    public static void run(Class<?> testedClass) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        for (Method m : testedClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Tester.class) || m.isAnnotationPresent(BeforeMethods.class)
                    || m.isAnnotationPresent(AfterMethods.class)) {
                System.out.println("Class " + testedClass.getName());
                System.out.println(m.getName() + "\n");
                m.invoke(testedClass.newInstance());
                System.out.println();
            }
        }
    }

    public static void assertEquals(int expected, int expression) {
        String result = expected == expression ? "passed" : "failed";
        System.out.println(result);
    }

    public static void assertEquals(String expected, String expression) {
        String result = expected.equals(expression) ? "passed" : "failed";
        System.out.println(result);
    }

    public static void assertEquals(byte[] first, byte[] second) {
        String result = Arrays.equals(first, second) ? "passed" : "failed";
        System.out.println(result);
    }

    public static void assertTrue(Path first, Path second) throws IOException {
        byte[] file1 = Files.readAllBytes(first);
        byte[] file2 = Files.readAllBytes(second);
        String result = Arrays.equals(file1, file2) ? "passed" : "failed";
        System.out.println(result);
    }
}
