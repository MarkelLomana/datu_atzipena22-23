package dambi.mainklaseak;

import java.util.Scanner;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendiak;

public class XMLtik {
  public static void main(String[] args) throws Exception {
    String inFile = "Mendiak.xml";
    XMLa xmla = new XMLa(inFile,"Mendiak2.xml");
    Csva csva = new Csva(inFile, "Mendiak_XMLOut.csv");
    Jsona json = new Jsona(inFile, "Mendiak_XMLOut.json");
    Mendiak mendiak = new Mendiak();
    mendiak = xmla.irakurri();

    Scanner in = new Scanner(System.in);
    int aukera = 0;
    do {
      System.out.println();
      System.out.println("IRAKURKETA MENUA");
      System.out.println("====================================");
      System.out.println("1.- XML-tik CSV-ra");
      System.out.println("2.- XML-tik JSON-era");
      System.out.println("3.- XML-tik XML-ra");
      System.out.println("10.- Irten");
      System.out.println("");
      System.out.print("Aukeratu zenbaki bat: ");

      aukera = in.nextInt();

      switch (aukera) {
        case 1:
          csva.idatzi(mendiak);
          break;
        case 2:
          json.idatzi(mendiak);
          break;
        case 3:
          xmla.idatzi(mendiak);
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
