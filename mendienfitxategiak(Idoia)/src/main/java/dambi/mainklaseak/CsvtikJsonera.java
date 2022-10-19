package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvtikJsonera {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Mendiak gipuzkoakoak = new Mendiak();
        Csva csva = new Csva("data/Mendiak.csv");
        Jsona jsona = new Jsona("","data/Gipuzkoakoak.json");
        mendiak = csva.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Gipuzkoa")) {
                    gipuzkoakoak.add(m);
                }
            }
            
            System.out.println(jsona.idatzi(gipuzkoakoak)+" mendi idatzi dira json fitxategian.");
        }

    }
}
