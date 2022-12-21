package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBEskatzaileakRepository implements EskatzaileakRepository {

  private static final TransactionOptions txnOptions = TransactionOptions.builder()
      .readPreference(ReadPreference.primary())
      .readConcern(ReadConcern.MAJORITY)
      .writeConcern(WriteConcern.MAJORITY)
      .build();

  @Autowired
  private MongoClient client;
  private MongoCollection<Eskatzaileak> eskatzaileakCollection;

  @PostConstruct
  void init() {
    eskatzaileakCollection = client.getDatabase("gabonak").getCollection("eskatzaileak", Eskatzaileak.class);
  }

  @Override
  public List<Eskatzaileak> findAll() {
    return eskatzaileakCollection.find().into(new ArrayList<>());
  }

  @Override
  public Eskatzaileak findById(String id) {
    return eskatzaileakCollection.find(eq("_id", new ObjectId(id))).first();
  }

  @Override
  public Eskatzaileak save(Eskatzaileak eskatzailea) {
    eskatzailea.setId(new ObjectId());
    eskatzaileakCollection.insertOne(eskatzailea);
    return eskatzailea;
  }

  @Override
  public long delete(String izena) {
    return eskatzaileakCollection.deleteMany(eq("izena", izena)).getDeletedCount();
  }

  @Override
  public void update(Eskatzaileak person) {
    Object id = person.getId();
    String izena = person.getIzena();
    List<String> opariak = person.getOpariak();
    eskatzaileakCollection.updateOne(eq("_id", id),
        new Document("$set", new Document("izena", izena).append("opariak", opariak)));
  }

}
