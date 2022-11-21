import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintStream;


public class createPath {
    Path p1 = Paths.get("/tmp/foo");
    Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));

    Path p4 = FileSystems.getDefault().getPath("/users/sally");

    Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");


    // None of these methods requires that the file corresponding to the Path exists.
    // Microsoft Windows syntax
    public static void main(String[] args) {

        //Absolute path
        Path path = Paths.get("C:\\home\\joe\\foo");
        // Relative path
        Path path2 = Paths.get("sally\\bar");

        System.out.format("toString: %s%n", path.toString());           //return 	C:\home\joe\foo
        System.out.format("getFileName: %s%n", path.getFileName());     //return 	foo
        System.out.format("getName(0): %s%n", path.getName(0));    //return 	home
        System.out.format("getNameCount: %d%n", path.getNameCount());   //return 	3
        System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));     //return 	home\joe
        System.out.format("getParent: %s%n", path.getParent());         //return 	\home\joe
        System.out.format("getRoot: %s%n", path.getRoot());             //return 	C:\

        //create a Path with two paths
        Path p1 = Paths.get("joe");
        Path p2 = Paths.get("sally");

        Path p1_to_p2 = p1.relativize(p2);
        Path p2_to_p1 = p2.relativize(p1);

        Path p3 = Paths.get("home");
        Path p4 = Paths.get("home/sally/bar");

        Path p3_to_p4 = p3.relativize(p3);
        Path p4_to_p3 = p4.relativize(p1);
    }
}
