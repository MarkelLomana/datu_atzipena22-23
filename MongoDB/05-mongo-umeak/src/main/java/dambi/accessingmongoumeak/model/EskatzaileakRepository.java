package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface EskatzaileakRepository {

  List<Eskatzaileak> findAll();

  Eskatzaileak findById(String id);

  Eskatzaileak save(Eskatzaileak person);

  void update(Eskatzaileak person);

  long delete(String izena);
}
