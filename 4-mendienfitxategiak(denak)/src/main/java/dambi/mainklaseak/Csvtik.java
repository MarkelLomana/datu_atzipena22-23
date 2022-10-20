package dambi.mainklaseak;

import java.util.Scanner;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendiak;

public class Csvtik {
  public static void main(String[] args) throws Exception {
    String inFile = "Mendiak.csv";
    Csva csva = new Csva(inFile);
    XMLa xmla = new XMLa(inFile, "Mendiak_CSVOut.xml");
    Jsona json = new Jsona(inFile, "Mendiak_CSVOut.json");
    
    Mendiak mendiak = new Mendiak();
    mendiak = csva.irakurri();

    Scanner in = new Scanner(System.in);
    int aukera = 0;
    do {
      System.out.println();
      System.out.println("IRAKURKETA MENUA");
      System.out.println("====================================");
      System.out.println("1.- CSV-tik XML-ra");
      System.out.println("2.- CSV-tik JSON-era");
      System.out.println("3.- CSV-tik CSV-ra");
      System.out.println("10.- Irten");
      System.out.println("");
      System.out.print("Aukeratu zenbaki bat: ");

      aukera = in.nextInt();

      switch (aukera) {
        case 1:
          xmla.idatzi(mendiak);
          break;
        case 2:
          json.idatzi(mendiak);
          break;
        case 3:
          csva.idatzi(mendiak);
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
