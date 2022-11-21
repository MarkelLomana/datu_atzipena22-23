package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvtikXmlra {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Mendiak gipuzkoakoak = new Mendiak();
        Csva csva = new Csva("data/Mendiak.csv");
        Xmla xmla = new Xmla("", "data/Gipuzkoakoak.xml");
        mendiak = csva.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Gipuzkoa")) {
                    gipuzkoakoak.add(m);
                }
            }

            System.out.println(xmla.idatzi(gipuzkoakoak) + " mendi idatzi dira xml fitxategian.");
        }


    }
}
