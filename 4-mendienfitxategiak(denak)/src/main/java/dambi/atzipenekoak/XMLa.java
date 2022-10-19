package dambi.atzipenekoak;

import java.io.File;

import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XMLa {
  String strFileIn, strFileOut;

  public XMLa(String strFileIn, String strFileOut) {
    this.strFileIn = strFileIn;
    this.strFileOut = strFileOut;
  }

  public XMLa(String strFileIn) {
    this.strFileIn = strFileIn;
    this.strFileOut = strFileIn + ".csv";
  }

  public Mendiak irakurri() {
    Mendiak mendiIrakurriak = null;
    try {
      File file = new File("src\\data\\" + strFileIn);
      JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      mendiIrakurriak = (Mendiak) jaxbUnmarshaller.unmarshal(file);

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Ondo irakurri da XMLa.");
    return mendiIrakurriak;
  }

  public Mendiak irakurri(Mendiak mendiak) {
    try {
      File file = new File("src\\data\\" + strFileIn);
      JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      mendiak = (Mendiak) jaxbUnmarshaller.unmarshal(file);

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(mendiak);
    return mendiak;
  }

  public int idatzi(Mendiak mendiak) {
    int mendiKopurua = 0;
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(mendiak, new File("src\\data\\" + strFileOut));
      mendiKopurua = mendiak.getMendiak().size();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(strFileOut + " fitxategia ondo idatzi da.");
    return mendiKopurua;
  }
}
