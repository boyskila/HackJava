import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropetryFile {

    private PropetryFile() {

    }

    public static Map<String, String> parseProperties(String file) throws FileNotFoundException, IOException {

        Map<String, String> parsedProperties = new HashMap<String, String>();

        String sCurrentLine;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.charAt(0) != '#') {
                    String a = sCurrentLine.substring(0, sCurrentLine.indexOf("=")).trim();
                    parsedProperties.put(a, sCurrentLine
                            .substring(sCurrentLine.indexOf("=") + 1, sCurrentLine.length()).trim());
                }
            }

        }
        return parsedProperties;
    }
}
