package dambi.accessingmongoumeak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dambi.accessingmongoumeak.model.Eskatzaileak;
import dambi.accessingmongoumeak.model.EskatzaileakRepository;

@RestController
@RequestMapping(path = "/gabonak/eskatzileak")
public class EskatzaileakController {
  @Autowired
  private EskatzaileakRepository eskatzaileakRepository;

  public EskatzaileakController(EskatzaileakRepository eskatzaileakRepository) {
    this.eskatzaileakRepository = eskatzaileakRepository;
  }

  @GetMapping(path = "/getAllEskatzaileak")
  public List<Eskatzaileak> getAllEskatzileak() {
    return eskatzaileakRepository.findAll();
  }

  @GetMapping(path = "/getAllEskatzaileak/{id}")
  public Eskatzaileak getEskatzaileaById(String id) {
    return eskatzaileakRepository.findById(id);
  }

  @PostMapping(path = "/saveEskatzaileak/{eskatzailea}")
  public Eskatzaileak createEskatzaileak(Eskatzaileak eskatzailea) {
    return eskatzaileakRepository.save(eskatzailea);
  }

  @PutMapping(path = "/updateEskatzaileak/{eskatzailea}")
  public void updateEskatzaileak(Eskatzaileak eskatzailea) {
    eskatzaileakRepository.update(eskatzailea);
  }

  @PostMapping(path = "/deleteEskatzaileak/{id}")
  public void deleteEskatzaileak(String id) {
    eskatzaileakRepository.delete(id);
  }

}
