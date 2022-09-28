import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ariketa1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        Path path2 = Paths.get("");

        try {
        //Absolute path
        System.out.println("Sartu path absolutua:");
        path2 = Path.of(in.next());

            if (Files.notExists(path2)) {
                System.out.println("sartutako path-a ez da existitzen");
            } else {
                System.out.println("sartutako path-a existitzen da:");
            }
        } catch (Exception e){
            System.out.println("Sartutako path-arekin arazoak dagoz.");
        }finally {
            in.close();
        }


        List<File> files = Files.list(path2)
                .map(Path::toFile)
                .collect(Collectors.toList());
                //.filter(File::isFile)     //fitxeroak bakarrik


        System.out.println("Path horretan dauden artxiboak:");
        files.forEach(System.out::println);

    }
}

