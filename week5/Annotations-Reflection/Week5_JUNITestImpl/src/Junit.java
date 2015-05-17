import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Junit {

    public static void run(List<Class<?>> testedClass) throws InstantiationException {
        for (int i = 0; i < testedClass.size(); i++) {
            for (Method m : testedClass.get(i).getDeclaredMethods()) {
                if (m.isAnnotationPresent(Tester.class)) {
                    try {
                        System.out.println("Class " + testedClass.get(i).getName());
                        System.out.println(m.getName() + "\n");
                        m.invoke(testedClass.get(i).newInstance());
                        System.out.println();
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void run(Class<?> testedClass) throws InstantiationException {
        for (Method m : testedClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Tester.class)) {
                try {
                    System.out.println("Class " + testedClass.getName());
                    System.out.println(m.getName() + "\n");
                    m.invoke(testedClass.newInstance());
                    System.out.println();
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Tester()
    public static void assertEquals(int expected, int expression) {
        String result = expected == expression ? "passed" : "failed";
        System.out.println(result);
    }

    @Tester()
    public static void assertEquals(String expected, String expression) {
        String result = expected.equals(expression) ? "passed" : "failed";
        System.out.println(result);
    }

    @Tester()
    public static void assertEquals(byte[] first, byte[] second) {
        String result = Arrays.equals(first, second) ? "passed" : "failed";
        System.out.println(result);
    }

    @Tester()
    public static void assertTrue(Path first, Path second) throws IOException {
        byte[] file1 = Files.readAllBytes(first);
        byte[] file2 = Files.readAllBytes(second);
        String result = Arrays.equals(file1, file2) ? "passed" : "failed";
        System.out.println(result);
    }
}
