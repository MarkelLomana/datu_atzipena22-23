import java.nio.file.Path;
import java.nio.file.Paths;

public class convertPath {

    public static void main(String[] args) {
        //convert to a String
        Path p1 = Paths.get("/home/logfile");
        System.out.format("%s%n", p1.toUri());          // Result is file:///home/logfile


        //The toAbsolutePath method converts a path to an absolute path
        if (args.length < 1) {
            System.out.println("usage: FileTest file");
            System.exit(-1);
        }

        // Converts the input string to a Path object.
        Path inputPath = Paths.get(args[0]);

        // Converts the input Path to an absolute path.
        // Generally, this means prepending  the current working
        // directory.  If this example were called like this:
        //     java FileTest foo
        // the getRoot and getParent methods would return null
        // on the original "inputPath"instance.  Invoking getRoot and
        // getParent on the "fullPath" instance returns expected values.
        Path fullPath = inputPath.toAbsolutePath();
    }
}
