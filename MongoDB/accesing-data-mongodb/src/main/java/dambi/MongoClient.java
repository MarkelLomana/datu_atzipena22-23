import com.mongodb.client.*;

public class MongoClient {
  public static void main(String[] args) {
    // Replace the placeholder with your MongoDB deployment's connection string
    String uri = "mongodb+srv://user1:user1@cluster0.wcdu5.mongodb.net/?retryWrites=true&w=majority";
    try (MongoClient mongoClient = MongoClients.create(uri)) {
      MongoDatabase database = mongoClient.getDatabase("sample_mflix");
      MongoCollection<Document> collection = database.getCollection("movies");
      Document doc = collection.find(eq("title", "Back to the Future")).first();
      if (doc != null) {
        System.out.println(doc.toJson());
      } else {
        System.out.println("No matching documents found.");
      }
    }
  }
}
