import java.nio.file.*;
import java.util.Scanner;

public class Ariketa2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Path path2 = Paths.get("");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{java,class}");


        try {
            //Absolute path
            System.out.print("Zer zoaz deskribatzera? ");

            Path filename = Path.of(in.next());
            if (matcher.matches(filename)) {
                System.out.println(filename);
            }

        } catch (Exception e){
            System.out.println("Sartutako path-arekin arazoak dagoz.");
        }finally {
            in.close();
        }
    }
}
