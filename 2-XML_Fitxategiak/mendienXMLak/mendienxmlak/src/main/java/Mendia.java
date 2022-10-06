import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"izena", "altuera", "probintzia"})
@XmlRootElement(name = "Mendia")
public class Mendia {

    private double altuera;
    private double oinak;
    private String izena;
    private String probintzia;

    public Mendia(){
    }
    public Mendia(String izena, int altuera, String probintzia){

        this.izena = izena;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    public double getAltuera() {
        return altuera;
    }

    public void setAltuera(double altuera) {
        this.altuera = altuera;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    @Override
    public String toString() {
        return "izena='" + izena + '\'' + 
                "altuera=" + altuera + ' ' +
                ", probintzia='" + probintzia + '\n';
    }
}
