package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvtikCsvra {
 
    /**
     * Mendiak.csv fitxategia irakurtzen joango gara eta Gipuzkoakoak direnak, beste fitxategi baten idatziko ditugu.
     * @param args
     */
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Mendiak gipuzkoakoak = new Mendiak();
        Csva csva = new Csva("data/Mendiak.csv", "data/Gipuzkoakoak.csv");
        mendiak = csva.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Gipuzkoa")) {
                    gipuzkoakoak.add(m);
                }
            }
            System.out.println(csva.idatzi(gipuzkoakoak)+" mendi idatzi dira csv fitxategian.");
        }

    }
}
