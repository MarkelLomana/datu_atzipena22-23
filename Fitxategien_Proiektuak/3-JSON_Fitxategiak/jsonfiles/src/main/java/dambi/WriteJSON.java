package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import java.io.StringWriter;

public class WriteJSON {

public static void main(String[] args) throws FileNotFoundException {

        /* WRITE JSON OBJECT AND SAVE IN A FILE */
        JsonObject model = Json.createObjectBuilder()
                .add("firstName", "Duke")
                .add("lastName", "Java")
                .add("age", 18)
                .add("streetAddress", "100 Internet Dr")
                .add("city", "JavaTown")
                .add("state", "JA")
                .add("postalCode", "12345")
                .add("phoneNumbers", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "mobile")
                                .add("number", "111-111-1111"))
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "222-222-2222")))
                .build();

        System.out.println(model);

        JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("../data/Irteera.json"));
        jsonWriter.writeObject(model);
        jsonWriter.close();

        /*ANOTHER METHOD TO WRITE A JSON FILE */
        StringWriter stWriter = new StringWriter();
        JsonWriter jsonWriter2 = Json.createWriter(stWriter);
        jsonWriter2.writeObject(model);
        jsonWriter2.close();
        String jsonData = stWriter.toString();
        System.out.println(jsonData);
}
}
