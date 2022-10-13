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
        this.strFileOut = strFileIn + ".csv";
    }
    
    public Mendiak irakurri(){

        Mendiak mendiak = new Mendiak();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(strFileIn));
            String line = br.readLine();
            while (line != null) {
                String[] zatiak = line.split(";");
                if(!zatiak[0].equals("MENDIA")){
                    Mendia mendi = new Mendia( Integer.parseInt(zatiak[0]), zatiak[1], Integer.parseInt(zatiak[2]), zatiak[3]);
                    mendiak.add(mendi);
                    line = br.readLine();
                }
            }
            br.close();
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
            outputStream = new PrintWriter(new FileWriter("data/" + strFileOut));
            if(mendiKopurua == 0){
                outputStream.println("ID;MENDIA;ALTUERA;PROBINTZIA");
            }
            for (int i=0; i < mendiak.getMendiak().size(); i++) {
                outputStream.println(mendiak.getMendiak().get(i).toString());
                mendiKopurua++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mendiKopurua;
    }
}
