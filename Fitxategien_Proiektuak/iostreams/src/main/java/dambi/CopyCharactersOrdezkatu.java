package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia character bakoitza irakurtzen du, 
    * outagain.txt fitxategian idatziz.
    * Idaztean a / A karaktereak o karakterearekin ordezkatzen ditu.
    */

public class CopyCharactersOrdezkatu {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characterAO.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if (c == 'a' || c == 'A') {
                    c = 'o';
                }
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}