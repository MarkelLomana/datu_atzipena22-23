import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;

import java.util.*;


public class Ariketa2 {

    public static class Finder extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;
        private int numMatches = 0;

        Finder(String pattern) {
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                numMatches++;
                System.out.println(file);
                file.getFileName();
            }
        }


        // Prints the total number of
        // matches to standard out.
        void done() {
            System.out.println("Matched: " + numMatches);
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc);
            return CONTINUE;
        }
    }
    private static String finded(Path file){
        PathMatcher matcher = null;
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            return name.toString();
        }
        return null;
    }

    static void usage() {
        System.err.println("java Find <path>" + " -name \"<glob_pattern>\"");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        Path startingDir = Paths.get("karpeta_berria");
        String pattern = "*";

        Finder finder = new Finder(pattern);
        Files.walkFileTree(startingDir, finder);
        finder.done();

        System.out.print("Zer zoaz deskribatzera?");
        String karpeta = in.next();

        System.out.print("Zein?");
        String fitxategia = in.next() + ".txt";

        System.out.print("Nolakoa?");
        String edukia = in.next();

        PathMatcher matcher =
                FileSystems.getDefault().getPathMatcher("glob:*");

        /*EZIN NAIZ SARTU NAHI DUDAN KARPETAN BERTAN SORTZEKO FITXATEGIA*/
        Path foldername = Path.of(karpeta);
        if (matcher.matches(foldername)) {

            System.out.println(foldername.getParent());
            //Create FIle
            Path file = Path.of(fitxategia);
            try {
                String aol = finded(foldername);
                Files.walk(Path.of(aol));
                Files.createFile(file);
                Files.writeString(file, edukia);
            } catch (FileAlreadyExistsException x) {
                System.err.format("file named %s" + " already exists%n", file);
            } catch (IOException x) {
                // Some other sort of failure, such as permissions.
                System.err.format("createFile error: %s%n", x);
            }
        }
    }

}