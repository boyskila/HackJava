package readandwritetofile;

import java.io.File;
import java.io.IOException;

public class ReadAndWriteToFileMain {

    public static void main(String[] args) throws IOException {

        String text = "This is just a simple fileWriteReadProgramm";
        File file = new File("example.txt");
        FileUtils.WriteToFile(text, file);
        FileUtils.readFromFile("example.txt");

    }
}
