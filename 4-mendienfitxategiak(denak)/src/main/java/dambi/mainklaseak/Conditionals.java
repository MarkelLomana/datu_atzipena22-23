package dambi.mainklaseak;
import java.util.Scanner;

import dambi.pojoak.Mendiak;
import dambi.atzipenekoak.*;

public class Conditionals {

    public static void main(String[] args) throws Exception {
        String inFile = "Mendiak.csv";
        Csva csva = new Csva(inFile, "Mendiak_Gipuzkoa.csv");
        XMLa xmla = new XMLa(inFile, "Mendiak_Bizkaia.xml");
        Jsona json = new Jsona(inFile, "Mendiak_Araba.json");

        Mendiak mendiak = new Mendiak();
        Mendiak gipuzkoa = new Mendiak();
        Mendiak bizkaia = new Mendiak();
        Mendiak araba = new Mendiak();

        mendiak = csva.irakurri();

        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("IRAKURKETA MENUA");
            System.out.println("====================================");
            System.out.println("1.- CSV idatzi Gipuzkoa");
            System.out.println("2.- XML idatzi Bizkaia");
            System.out.println("3.- JSON idatzi Araba");
            System.out.println("10.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");

            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                        if (mendiak.getMendiak().get(i).getProbintzia().equals("Gipuzkoa")) {
                            gipuzkoa.add(mendiak.getMendiak().get(i));
                        }
                    }
                    csva.idatzi(gipuzkoa);
                    break;
                case 2:
                    for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                        if (mendiak.getMendiak().get(i).getProbintzia().equals("Bizkaia")) {
                            bizkaia.add(mendiak.getMendiak().get(i));
                        }
                    }
                    xmla.idatzi(bizkaia);
                    break;
                case 3:
                    for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                        if (mendiak.getMendiak().get(i).getProbintzia().equals("Bizkaia")) {
                            araba.add(mendiak.getMendiak().get(i));
                        }
                    }
                    json.idatzi(araba);
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
