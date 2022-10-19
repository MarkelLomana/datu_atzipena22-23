package dambi;

public class Mendia {

    private int altuera;
    private String izena;
    private String probintzia;

    public Mendia(String izena, int altuera, String probintzia){

        this.izena = izena;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    public int getAltuera() {
        return altuera;
    }

    public void setAltuera(int altuera) {
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
                "altuera=" + altuera +
                ", probintzia='" + probintzia + '\'';
    }
}
