package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"izena", "altuera", "probintzia"})
@XmlRootElement(name = "Mendia")
public class Mendia {

    //private int id;
    private String izena;
    private double altuera;
    private String probintzia;

    public Mendia(){
    }
    public Mendia( String izena, int altuera, String probintzia){
        //this.id = id;
        this.izena = izena;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    /*
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    */
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public double getAltuera() {
        return altuera;
    }
    public void setAltuera(double altuera) {
        this.altuera = altuera;
    }
    public String getProbintzia() {
        return probintzia;
    }
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    @Override
    public String toString() {
        return "Izena= " + izena + "; Altuera= " + altuera + "; Probintzia= " + probintzia + '\n';
    }
}
