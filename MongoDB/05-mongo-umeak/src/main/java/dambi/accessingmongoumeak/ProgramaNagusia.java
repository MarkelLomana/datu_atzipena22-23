package dambi.accessingmongoumeak;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dambi.accessingmongoumeak.model.*;

@SpringBootApplication
public class ProgramaNagusia {

  static MongoDBEskatzaileakRepository eskatzaileakRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProgramaNagusia.class, args);
  }
}
