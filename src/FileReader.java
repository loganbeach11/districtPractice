import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> read(String path){
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(path)));
        }catch (IOException e){
            return null;
        }
    }    
}
