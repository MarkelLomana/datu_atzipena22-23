package dambi.accessingmongoumeak;

import java.util.ArrayList;
import java.util.List;

import dambi.accessingmongoumeak.model.Eskatzaileak;
import dambi.accessingmongoumeak.model.EskatzaileakRepository;

public class CRUDEska {

  private static EskatzaileakRepository eskatzaileakRepository;

  public static void main(String[] args) {
    System.out.println("CRUD eskatzaileak");
    Eskatzaileak eskatzailea = new Eskatzaileak();

    List<String> oparienLista = new ArrayList<String>();
    oparienLista.add("Opari1");
    oparienLista.add("Opari2");
    oparienLista.add("Opari3");
    eskatzailea.setIzena("Iñaki");
    eskatzailea.setOpariak(oparienLista);

    // eskatzaileakRepository.save(eskatzailea);
    List<Eskatzaileak> eskatzaileak = eskatzaileakRepository.findAll();
    for (Eskatzaileak eskatzailea2 : eskatzaileak) {
      System.out.println(eskatzailea2);
    }
  }
}
