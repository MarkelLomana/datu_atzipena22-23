package dambi.mainklaseak;

import java.util.Scanner;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendiak;

public class JSONetik {
  public static void main(String[] args) throws Exception {
    String inFile = "Mendiak.json";
    Jsona json = new Jsona(inFile, "Mendiak_JsonOut.json");
    XMLa xmla = new XMLa(inFile, "Mendiak_JSONOut.xml");
    Csva csva = new Csva(inFile, "Mendiak_JSONOut.csv");
    
    Mendiak mendiak = new Mendiak();
    mendiak = json.irakurri();

    Scanner in = new Scanner(System.in);
    int aukera = 0;
    do {
      System.out.println();
      System.out.println("IRAKURKETA MENUA");
      System.out.println("====================================");
      System.out.println("1.- JSON-tik CSV-ra");
      System.out.println("2.- JSON-tik XML-ra");
      System.out.println("3.- JSON-tik JSON-era");
      System.out.println("10.- Irten");
      System.out.println("");
      System.out.print("Aukeratu zenbaki bat: ");

      aukera = in.nextInt();

      switch (aukera) {
        case 1:
          csva.idatzi(mendiak);
          break;
        case 2:
          xmla.idatzi(mendiak);
          break;
        case 3:
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
