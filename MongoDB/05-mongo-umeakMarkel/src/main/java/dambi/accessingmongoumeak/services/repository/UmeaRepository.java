package dambi.accessingmongoumeak.services.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import dambi.accessingmongoumeak.model.Umea;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class UmeaRepository {

  private static final TransactionOptions txnOptions = TransactionOptions.builder()
      .readPreference(ReadPreference.primary())
      .readConcern(ReadConcern.MAJORITY)
      .writeConcern(WriteConcern.MAJORITY)
      .build();

  @Autowired
  private MongoClient client;
  private MongoCollection<Umea> umeaCollection;

  @PostConstruct
  void init() {
    umeaCollection = client.getDatabase("gabonak").getCollection("umeak", Umea.class);
  }

  public List<Umea> findAll() {
    return umeaCollection.find().into(new ArrayList<>());
  }

  public Umea findById(String id) {
    return umeaCollection.find(eq("_id", new ObjectId(id))).first();
  }

  public Umea save(Umea umea) {
    umea.setId(new ObjectId());
    umeaCollection.insertOne(umea);
    return umea;
  }

  public long delete(String izena) {
    return umeaCollection.deleteMany(eq("izena", izena)).getDeletedCount();
  }

  public List<String> findByOpariak(String id) {
    List<String> umearenOpariak = new ArrayList<>();
    umearenOpariak = umeaCollection.find(eq("_id",id)).first().getOpariak();
    return umearenOpariak;
}

}
