import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyFileMain {

    public static void main(String[] args) throws IOException {

        Map<String, String> parsedObjects = PropetryFile.parseProperties("pair.txt");

        Properties prop = new Properties();

        try (FileOutputStream output = new FileOutputStream("pair.properties")) {

            Iterator<Entry<String, String>> it = parsedObjects.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, String> currentElement = it.next();
                prop.setProperty(currentElement.getKey(), currentElement.getValue());
            }
            prop.store(output, null);
        }
    }
}
