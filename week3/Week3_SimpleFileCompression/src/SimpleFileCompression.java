import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class SimpleFileCompression {

    public static void compress(Path path) throws FileNotFoundException, IOException {
        Map<Integer, String> w = new HashMap<>();
        StringBuilder str = new StringBuilder();
        try (Scanner input = new Scanner(path.toFile())) {
            int i = -1;
            String word; // read file by words

            while (input.hasNext()) {
                word = input.next().replaceAll("[, .]+", "");
                if (!w.containsValue(word)) {
                    w.put(++i, word);
                    str.append("~" + i + "");
                } else
                    str.append("~" + getMapKey(w, word)); // create cifer
            }
            w.put(-1, str.toString());// put cifer in map
        }

        try (FileOutputStream f = new FileOutputStream("compressed.compr")) {
            Properties prop = new Properties();
            Iterator<Entry<Integer, String>> it = w.entrySet().iterator();
            while (it.hasNext()) {
                Entry<Integer, String> current = it.next();
                prop.setProperty(current.getKey() + "", current.getValue());
            }
            prop.store(f, null);
        }

    }

    public static String getMapKey(Map<Integer, String> map, String word) {

        Iterator<Entry<Integer, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, String> current = it.next();
            if (current.getValue().equals(word))
                return current.getKey() + "";
        }

        return null;
    }

    public static String decompress(File propfile) throws IOException {

        Map<Integer, String> map = loadMapFromFile(propfile);
        StringBuilder sb = new StringBuilder();

        String compressedFile = null;
        Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, String> current = it.next();
            if (current.getKey() == -1) {
                compressedFile = current.getValue();
                break;
            }

        }
        String[] value = compressedFile.split("~");
        for (String c : value) {
            if (c.matches("\\d+"))

                sb.append(getWord(map, Integer.valueOf(c)) + " ");
        }

        return sb.toString();
    }

    public static String getWord(Map<Integer, String> map, int c) {

        Iterator<Entry<Integer, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, String> current = it.next();
            if (c == current.getKey())
                return current.getValue();
        }

        return null;
    }

    public static Map<Integer, String> loadMapFromFile(File f) throws IOException {

        Map<Integer, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String s;

            while ((s = reader.readLine()) != null) {

                if (s.charAt(0) != '#') {

                    String key = s.substring(0, s.indexOf("="));
                    String value = s.substring(s.indexOf("=") + 1, s.length());
                    if (value.equals("\\=")) {
                        map.put(Integer.valueOf(key), "=");
                    } else
                        map.put(Integer.valueOf(key), value);
                }
            }
        }

        return map;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        compress(Paths.get("C:\\Users\\Bojko\\Desktop\\buffalo.txt"));
        System.out.println(decompress(new File("compressed.compr")));

    }

}
