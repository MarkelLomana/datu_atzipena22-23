package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia character bakoitza irakurtzen du, 
    * outagain.txt fitxategian idatziz.
    * Idaztean karaktereak maiuskulaz idazten dira.
    */

public class CopyCharactersMaiuskulaz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characterMAIUS.txt");

            int c;

            while ((c = inputStream.read()) != -1) {
                //Char-a idatzi maiuskulaz
                outputStream.write(Character.toString((char) c).toUpperCase());
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