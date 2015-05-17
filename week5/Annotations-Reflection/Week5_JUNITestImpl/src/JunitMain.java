import java.util.ArrayList;
import java.util.List;

public class JunitMain {
    @Tester
    public void oneMoreTestMethod() {
        Junit.assertEquals(20, 10 + 10);
        Junit.assertEquals(20, 10 + 11);
    }

    public static void main(String[] args) throws InstantiationException {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(TestsRepository.class);
        classes.add(SimpleMethodsForTesting.class);
        classes.add(JunitMain.class);
        Junit.run(classes);
        Junit.run(TestsRepository.class);
    }
}
