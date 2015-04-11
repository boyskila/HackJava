import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FixSubtitlesMain {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                "C:/Users/Bojko/Desktop/lost.s04e11.hdtv.xvid-2hd.srt"), "windows-1251"))) {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Bojko/Desktop/lostSubs.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
System.out.println(line);
                    bw.write(line);
                }
            }
        }
    }
}
