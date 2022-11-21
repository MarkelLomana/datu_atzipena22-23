package dambi.mainklaseak;

import java.util.Scanner;
import dambi.atzipenekoak.*;

public class Irakurketa {
    public static void main(String[] args) throws Exception {
        Csva csva = new Csva("Mendiak.csv");
        XMLa xmla = new XMLa("Mendiak.xml");
        Jsona jsona = new Jsona("Mendiak.json");
        
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("IRAKURKETA MENUA");
            System.out.println("====================================");
            System.out.println("1.- CSV fitxategi bat irakurri");
            System.out.println("2.- XML fitxategi bat irakurri");
            System.out.println("3.- JSON fitxategi bat irakurri");
            System.out.println("10.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");

            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    csva.irakurri();
                    break;
                case 2:
                    xmla.irakurri();
                    break;
                case 3:
                    jsona.irakurri();
                    break;
                case 10:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        }
        while (aukera != 10);
        in.close();
    }
}
