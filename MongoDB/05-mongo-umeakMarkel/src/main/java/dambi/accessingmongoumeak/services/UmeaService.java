package dambi.accessingmongoumeak.services;

import java.util.List;

import dambi.accessingmongoumeak.model.Umea;
import dambi.accessingmongoumeak.services.repository.UmeaRepository;

public class UmeaService {
  private UmeaRepository umeaRepository;

  public List<Umea> getAllUmeak() {
    return umeaRepository.findAll();
  }

  public Umea getUmeaByid(String id) {
    return umeaRepository.findById(id);
  }

  public Umea createUmea(Umea person) {
    return umeaRepository.save(person);
  }

  public long deleteUmea(String izena) {
    return umeaRepository.delete(izena);
  }

  public List<String> getAllOpariakById(String id) {
    return umeaRepository.findByOpariak(id);
  }
}
