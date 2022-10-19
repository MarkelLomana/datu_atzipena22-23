package dambi.mainklaseak;

import java.util.Scanner;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendiak;

public class JSONetik {
  public static void main(String[] args) throws Exception {
    Jsona json = new Jsona("Mendiak.json");
    XMLa xmla = new XMLa("Mendiak.json", "Mendiak_XMLOut2.xml");
    Csva csva = new Csva("Mendiak.json", "Mendiak_CSVOut.csv");
    Mendiak mendiak = json.irakurri();

    Scanner in = new Scanner(System.in);
    int aukera = 0;
    do {
      System.out.println();
      System.out.println("IRAKURKETA MENUA");
      System.out.println("====================================");
      System.out.println("1.- CSV-tik XML-ra");
      System.out.println("2.- CSV-tik JSON-era");
      System.out.println("10.- Irten");
      System.out.println("");
      System.out.print("Aukeratu zenbaki bat: ");

      aukera = in.nextInt();

      switch (aukera) {
        case 1:
          csva.irakurri(mendiak);
          xmla.idatzi(mendiak);
          break;
        case 2:
          csva.irakurri(mendiak);
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
