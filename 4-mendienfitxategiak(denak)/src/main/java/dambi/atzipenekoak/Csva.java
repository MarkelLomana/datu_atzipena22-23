package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dambi.pojoak.*;

public class Csva {
  String strFileIn, strFileOut;

  public Csva(String strFileIn, String strFileOut) {
    this.strFileIn = strFileIn;
    this.strFileOut = strFileOut;
  }

  public Csva(String strFileIn) {
    this.strFileIn = strFileIn;
    this.strFileOut = strFileIn + "out.csv";
  }

  public Mendiak irakurri() {

    Mendiak mendiak = new Mendiak();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("src\\data\\" + strFileIn));
      String line = br.readLine();
      int iterator = 0;
      while (line != null) {

        String[] zatiak = line.split(";");
        if (iterator != 0) {
          Mendia mendi = new Mendia(zatiak[0], Integer.parseInt(zatiak[1]), zatiak[2]);
          mendiak.add(mendi);
          line = br.readLine();
        } else {
          line = br.readLine();
          iterator++;
        }
      }
      br.close();
      System.out.println(mendiak);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return mendiak;
  }

  public Mendiak irakurri(Mendiak mendiak) {

    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("src\\data\\" + strFileIn));
      String line = br.readLine();
      int iterator = 0;
      while (line != null) {

        String[] zatiak = line.split(";");
        if (iterator != 0) {
          Mendia mendi = new Mendia(zatiak[0], Integer.parseInt(zatiak[1]), zatiak[2]);
          mendiak.add(mendi);
          line = br.readLine();
        } else {
          line = br.readLine();
          iterator++;
        }
      }
      br.close();
      System.out.println("Ondo irakurri da CSV-a");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return mendiak;
  }

  public int idatzi(Mendiak mendiak) {
    int mendiKopurua = 0;
    PrintWriter outputStream = null;
    try {
      outputStream = new PrintWriter(new FileWriter("src\\data\\" + strFileOut));
      if (mendiKopurua == 0) {
        outputStream.println("MENDIA;ALTUERA;PROBINTZIA");
      }
      for (int i = 0; i < mendiak.getMendiak().size(); i++) {
        outputStream.println(mendiak.getMendiak().get(i).toString());
        mendiKopurua++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mendiKopurua;
  }
}
