package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.atzipenekoak.Jsona;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvkoDanakXmletaJsonera {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Csva csva = new Csva("data/Mendiak.csv");
        Xmla xmla = new Xmla("", "data/Mendiak.xml");
        Jsona jsona = new Jsona("", "data/Mendiak.json");
        mendiak = csva.irakurri();
        xmla.idatzi(mendiak);
        jsona.idatzi(mendiak);
        
    }
}
