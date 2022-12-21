package dambi.accessingmongoumeak.model;

import java.util.List;

import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.bson.types.ObjectId;

public class Eskatzaileak extends UpdateResult {

  private ObjectId id; // Berdin ei da id zein _id jarri (Eta eremu hau ez erabiltzea be aukera bat da)
  private String izena;
  private List<String> opariak;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getIzena() {
    return izena;
  }

  public void setIzena(String izena) {
    this.izena = izena;
  }

  public List<String> getOpariak() {
    return opariak;
  }

  public void setOpariak(List<String> opariak) {
    this.opariak = opariak;
  }

    @Override
    public boolean wasAcknowledged() {
        return false;
    }

    @Override
    public long getMatchedCount() {
        return 0;
    }

    @Override
    public long getModifiedCount() {
        return 0;
    }

    @Override
    public BsonValue getUpsertedId() {
        return null;
    }
}
