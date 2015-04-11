import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BrokenLinksFinder {

    public static void findBrokenLink(Path path) throws IOException {

        File files = new File(path.toString());
        File[] file = files.listFiles();
        for (File f : file) {

            if (f.isFile()) {

                if (Files.isSymbolicLink(path))

                   try {
                       System.out.println(Files.readSymbolicLink(f.toPath()));
                       System.out.format("Symbolic link: %s \n", f);  
                } catch (Exception e) {
                    System.out.println(f);
                } 
            }

            if (f.isDirectory()) {
                if (Files.isSymbolicLink(path)){
                
                    System.out.format("Symbolic link: %s \n", f);
                    System.out.println(Files.readSymbolicLink(path)); 
                }
                  // System.out.println(Files.readSymbolicLink(f.toPath()));
                

                findBrokenLink(Paths.get(f.toString()));
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/users/bojko/desktop/empty");
        findBrokenLink(path);
    }
}
