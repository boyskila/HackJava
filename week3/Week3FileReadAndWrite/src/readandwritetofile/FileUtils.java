package readandwritetofile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    private FileUtils() {

    }

    public static void WriteToFile(String text, File path) throws IOException {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(path))) {
            output.write(text);
        }
    }

    public static void readFromFile(String path) {

        try {
            System.out.println(new String(Files.readAllBytes(Paths.get(path))));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
