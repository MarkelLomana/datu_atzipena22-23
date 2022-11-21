package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "mendia", "altuera", "probintzia" })
@XmlRootElement(name = "Mendia")

public class Mendia {

    int id = 0;
    String mendia;
    int altuera;
    String probintzia;

    public int getId(){
       return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getMendia() {
        return mendia;
    }

    @XmlElement(name = "Mendia")
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    public int getAltuera() {
        return altuera;
    }

    @XmlElement(name = "Altuera")
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    public String getProbintzia() {
        return probintzia;
    }

    @XmlElement(name = "Probintzia")
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    @Override
    public String toString() {
        return "Mendia["+ id+", "+mendia+", "+altuera+", "+probintzia+"]";
    }

}
