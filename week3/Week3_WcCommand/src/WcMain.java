import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WcMain {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\Bojko\\Desktop\\Generics.txt");

        WcResult wc1 = Wcounter.wcFromPath(path);
        System.out.println(wc1);

        WcResult wc2 = Wcounter.wcFromFile(new File("example.txt"));
        System.out.println(wc2);
    }
}
