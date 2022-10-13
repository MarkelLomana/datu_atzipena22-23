package dambi.atzipenekoak;

import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.*;


public class Jsona {
    String strFileIn, strFileOut;

    public Jsona(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }
    public Jsona(String strFileIn) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileIn + ".csv";
    }

    public Mendiak irakurri(){
        /*READ JSON FILE */
        Mendiak mendiak = null;
        try{
            JsonReader reader = Json.createReader(new FileReader("data/" + strFileIn));
            JsonStructure jsonst = reader.read();  //json structure estruktura sortzen da
            
            JsonArray jsonstArray = jsonst.asJsonArray(); //json structure arrayra bihurtzen da
            mendiak = new Mendiak();
            for (int i=0; i<jsonstArray.size(); i++) {
                Mendia mendia = new Mendia();
                mendia.setId(jsonstArray.getJsonObject(i).getInt("id"));
                mendia.setIzena(jsonstArray.getJsonObject(i).getString("izena"));
                mendia.setAltuera(jsonstArray.getJsonObject(i).getInt("altuera"));
                mendia.setProbintzia(jsonstArray.getJsonObject(i).getString("probintzia"));
                mendiak.add(mendia);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak) {
        int mendiKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        
        for (Mendia mendia : mendiak.getMendiak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", mendia.getId())
                    .add("izena", mendia.getIzena())
                    .add("altuera", mendia.getAltuera())
                    .add("probintzia", mendia.getProbintzia())
                    .build());
            mendiKopurua++;
        }
        model = jab.build();
        try(JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("../data/" + strFileOut))){
            jsonWriter.writeArray(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mendiKopurua;
    }
}
