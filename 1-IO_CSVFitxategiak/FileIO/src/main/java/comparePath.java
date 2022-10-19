import java.nio.file.Path;
import java.nio.file.Paths;

public class comparePath {

    public static void main(String[] args) {
        Path path = Paths.get("joe");
        Path otherPath = Paths.get("sally");

        Path beginning = Paths.get("/home");
        Path ending = Paths.get("foo");

        if (path.equals(otherPath)) {
            // equality logic here
        } else if (path.startsWith(beginning)) {
            // path begins with "/home"
        } else if (path.endsWith(ending)) {
            // path ends with "foo"
        }

        //Iterable class
        Path path5 = Paths.get("joe");
        for (Path name: path5) {
            System.out.println(name);
        }
    }
}
