package dambi.mainklaseak;

import java.util.Scanner;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendiak;

public class XMLtik {
  public static void main(String[] args) throws Exception {

    XMLa xmla = new XMLa("Mendiak.xml");
    Csva csva = new Csva("Mendiak.xml", "Mendiak_XMLOut.csv");
    Jsona json = new Jsona("Mendiak.xml", "Mendiak_XMLOut.json");
    Mendiak mendiak = xmla.irakurri();

    Scanner in = new Scanner(System.in);
    int aukera = 0;
    do {
      System.out.println();
      System.out.println("IRAKURKETA MENUA");
      System.out.println("====================================");
      System.out.println("1.- XML-tik CSV-ra");
      System.out.println("2.- XML-tik JSON-era");
      System.out.println("10.- Irten");
      System.out.println("");
      System.out.print("Aukeratu zenbaki bat: ");

      aukera = in.nextInt();

      switch (aukera) {
        case 1:
          //xmla.irakurri(mendiak);
          System.out.println(mendiak);
          csva.idatzi(mendiak);
          break;
        case 2:
          //xmla.irakurri(mendiak);
          json.idatzi(mendiak);
          break;
        case 10:
          System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
          break;
        default:
          System.out.println("Aukera okerra. Saiatu berriz.");
      }
    } while (aukera != 10);
    in.close();
  }
}
