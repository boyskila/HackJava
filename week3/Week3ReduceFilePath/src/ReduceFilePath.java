import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class ReduceFilePath {
    public static String reduceFilePath(String input) {
        return Paths.get(input).normalize().toString();

    }

    public static void main(String[] args) {
        System.out.println(ReduceFilePath.reduceFilePath("/home//radorado/code/./hackbulgaria/week0/../"));

    }
}
