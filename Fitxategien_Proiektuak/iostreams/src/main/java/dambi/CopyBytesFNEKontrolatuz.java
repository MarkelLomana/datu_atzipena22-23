package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte
 * irakurtzen du,
 * byte bakoitza outagain.txt fitxategian idatziz.
 * Erroreen kontrola egiten du.
 */

public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanaduEZ.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException a) {
            System.out.println("Errorea fitxategia irekitzerakoan");
        } catch (IOException b) {
            System.out.println("Errorea fitxategia irakurtzerakoan");
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}