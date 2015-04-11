import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;

public class Wcounter {
    private static File file;

    public static WcResult wcFromPath(Path path) throws IOException {

        file = new File(path.toString());
        return new WcResult(getLineCount(), getWordCount(), getSymbolsCount());

    }

    public static WcResult wcFromFile(File f) throws IOException {
        file = f;
        return new WcResult(getLineCount(), getWordCount(), getSymbolsCount());
    }

    public static int getSymbolsCount() throws FileNotFoundException, IOException {

        try (FileReader fr = new FileReader(file)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String text = br.readLine();
                int counter = 0;
                while (text != null) {

                    for (@SuppressWarnings("unused")
                    Character string : text.toCharArray())

                        counter++;

                    text = br.readLine();

                }

                return counter;
            } catch (IOException e) {

                e.printStackTrace();
            }
            return 0;
        }
    }

    public static int getWordCount() throws FileNotFoundException, IOException {

        try (FileReader fr = new FileReader(file)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String text = br.readLine();
                int counter = 0;
                while (text != null) {
                    String[] words = text.split(" ");
                    for (int i = 0; i < words.length; i++)
                        counter++;
                    text = br.readLine();
                }

                return counter;
            } catch (IOException e) {

                e.printStackTrace();
            }
            return 0;
        }
    }

    public static int getLineCount() throws IOException {

        try (LineNumberReader reader = new LineNumberReader(new FileReader(file))) {
            while ((reader.readLine()) != null) {

            }

            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        }
    }

}
