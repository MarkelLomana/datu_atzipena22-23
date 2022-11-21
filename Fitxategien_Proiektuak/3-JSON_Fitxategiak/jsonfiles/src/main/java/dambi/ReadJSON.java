package dambi;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;


public class ReadJSON {
    
    public static void main(String[] args) throws FileNotFoundException {
        /*READ JSON FILE */
        JsonReader reader = Json.createReader(new FileReader("data/test.json"));
        JsonStructure jsonst = reader.read();  //json structure Esttuktura sortzen da
        System.out.println(jsonst);
    }
    
}
