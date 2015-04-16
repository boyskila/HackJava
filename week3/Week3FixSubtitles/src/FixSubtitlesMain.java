import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FixSubtitlesMain {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("lost.s04e11.hdtv.xvid-2hd.srt");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "windows-1251"))) {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("lostSubs.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    bw.write(line);
                }
            }
        }
    }
}
