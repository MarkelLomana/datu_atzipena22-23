package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;


public class MenuWriteJSON {
public static void main(String[] args) throws FileNotFoundException {

        JsonObject model = Json.createObjectBuilder()
                .add("menu", Json.createObjectBuilder()
                        .add("id", "file")
                        .add("value", "File")
                        .add("popup", Json.createObjectBuilder()
                                .add("menuitem", Json.createArrayBuilder()
                                        .add(Json.createObjectBuilder()
                                                .add("value", "New")
                                                .add("onclick", "CreateNewDoc()"))
                                        .add(Json.createObjectBuilder()
                                                .add("value", "Open")
                                                .add("onclick", "OpenDoc()"))
                                        .add(Json.createObjectBuilder()
                                                .add("value", "Close")
                                                .add("onclick", "CloseDoc()")))))
                .build();
        System.out.println(model);

        /*.close() automatically */
        //KONTUZ artxiboaren lekuarekin beste fitxategian "../data/Menu2.json" funtzionatzen du
        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("data/MenuJSONIrteera.json"))) { 
                jsonWriter.writeObject(model);
        }
}
        
}
