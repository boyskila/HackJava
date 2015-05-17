import java.lang.reflect.InvocationTargetException;

public class JunitMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Junit.run(TestsRepository.class);
    }
}
