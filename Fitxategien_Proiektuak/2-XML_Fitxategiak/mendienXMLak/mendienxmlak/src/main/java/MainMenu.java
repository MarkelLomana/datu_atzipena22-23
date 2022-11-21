import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class MainMenu {

    static ArrayList<Mendia> mendiak = new ArrayList<>();
    

    public static void main(String[] args) throws Exception {

        

        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien Zerrenda Ikusi");
            System.out.println("2.- Mendirik Altuena Bistarazi");
            System.out.println("3.- Mendiak Esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Mendi Bat XML");
            System.out.println("5.- Hiru Mendi XML");
            System.out.println("6.- Pasatu XML beste XML oinetara");
            System.out.println("7.- Probintzia bakoitzeko mendiak XML-tik irakurrita, XML fitxategi batean gorde");
            System.out.println("10.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");

            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    cvsIrakurri();
                    mendienZerrenda();
                    break;
                case 2:
                    cvsIrakurri();
                    mendiAltuena();
                    break;
                case 3:
                    cvsIrakurri();
                    mendiakCSV();
                    break;
                case 4:
                    mendiaXML();
                    break;
                case 5:
                    hiruMendiXML();
                    break;
                case 6:
                    oinatanXML();
                    break;
                case 7:
                    probintziakXML();
                    break;
                case 10:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        }
        while (aukera != 10);

    }

    public static void probintziakXML(){
        try
        {
            ArrayList<Mendia> mendiakGipuzkoa = new ArrayList<>();
            /* UNMARSHALL */
            File file = new File( "list_3_mendia.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak mendiIrakurriak = (Mendiak)jaxbUnmarshaller.unmarshal( file );

            for(int i=0; i < mendiIrakurriak.getMendiak().size(); i++){
                String probintzia = mendiIrakurriak.getMendiak().get(i).getProbintzia();
                if(probintzia.equals("Gipuzkoa")){
                    mendiakGipuzkoa.add(mendiIrakurriak.getMendiak().get(i));
                } 
                
            }
            
            /* Gorde fitxategian
             * create a new file
             * MARSHALL the object to the file
             */
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( mendiakGipuzkoa, new File( "gipuzkoakoMendiak.xml" ) );
            //jaxbMarshaller.marshal( mendiak, System.out );
            System.out.println("Ondo sortu da gipuzkoakoMendiak.xml fitxategia.");

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }
    public static void oinatanXML(){
    
        try
        {
            /* UNMARSHALL */
            File file = new File( "list_3_mendia.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak mendiIrakurriak = (Mendiak)jaxbUnmarshaller.unmarshal( file );

            for(int i=0; i < mendiIrakurriak.getMendiak().size(); i++){
                double altuera = mendiIrakurriak.getMendiak().get(i).getAltuera();
                double oinak = altuera * 3.28084;
                mendiIrakurriak.getMendiak().get(i).setAltuera(oinak);
            }
            System.out.println( mendiIrakurriak );
            
            /* Gorde fitxategian
             * create a new file
             * MARSHALL the object to the file
             */
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( mendiIrakurriak, new File( "mendiakAltueraOinatan.xml" ) );
            //jaxbMarshaller.marshal( mendiak, System.out );
            System.out.println("Ondo sortu da mendiakAltueraOinatan.xml fitxategia.");

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
        
    }
    
    public static void mendiaXML(){
        try
        {

            /* init very simple data to marshal */
            Mendia urko = new Mendia();
            urko.setIzena( "Urko" );
            urko.setAltuera( 786 );
            urko.setProbintzia( "Gipuzkoa" );

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendia.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( urko, new File( "Mendia.xml" ) );
            //jaxbMarshaller.marshal( urko, System.out );
            System.out.println("Ondo sortu da Mendia.xml fitxategia.");
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
    
    public static void hiruMendiXML(){
        try
        {
            /* init a list with a couple of mendiak to marshal */
            Mendiak mendiak = new Mendiak();
            mendiak.add( new Mendia( "Urko", 786, "Gipuzkoa" ) );
            mendiak.add( new Mendia( "Aratz", 1055, "Araba" ) );
            mendiak.add( new Mendia( "Artxanda", 1025, "Bizkaia" ) );
        

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( mendiak, new File( "list_3_mendia.xml" ) );
            //jaxbMarshaller.marshal( mendiak, System.out );
            System.out.println("Ondo sortu da list_3_mendia.xml fitxategia.");

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }

    public static void mendiakCSV() {
        Scanner sc = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println("MENDIEN ESPORTAZIO MENUA");
            System.out.println("====================================");
            System.out.println("Zein lurraldetako mendiak esportatu nahi dituzu (1,2,3,4) ? ");
            System.out.println("1 - Araba");
            System.out.println("2 - Bizkaia");
            System.out.println("3 - Gipuzkoa");
            System.out.println("4 - Nafarroa");
            System.out.print("Aukeratu zenbaki bat: ");

            aukera = sc.nextInt();

            switch (aukera) {
                case 1:
                    createCSV("MendiakAraba.csv", "Araba");
                    break;
                case 2:
                    createCSV("MendiakBizkaia.csv", "Bizkaia");
                    break;
                case 3:
                    createCSV("MendiakGipuzkoa.csv", "Gipuzkoa");
                    break;
                case 4:
                    createCSV("MendiakNafarroa.csv", "Nafarroa");
                    break;
                default:
                    System.out.println("Ez duzu balore egokia sartu");
            }
        }
        while (aukera != 5);
    }

    /**
     * CSV-a irakurtzen da eta ilaraka
     * ArrayList batean gordetzen joaten dira datuak
     */
    public static void cvsIrakurri() {

        try {
            File myObj = new File("Mendiak.csv");
            Scanner myReader = new Scanner(myObj);
            int iteration = 0;
            while (myReader.hasNextLine()  ) {
                while(iteration == 0) {
                    iteration++;
                    String dataHeader = myReader.nextLine();
                    break;
                }
                String data = myReader.nextLine();
                String[] cols = data.split(";");
                String izena = cols[0];
                String altuera = cols[1];

                String probintzia = cols[2];

                mendiak.add(new Mendia(izena, Integer.parseInt(altuera), probintzia));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading file.");
            e.printStackTrace();
        }
    }

    /**
     * Mendien zerrenda bistaratzen du mendiak ArrayList-etik
     */
    public static void mendienZerrenda() {
        try {
            for (int i = 0; i < mendiak.size(); i++) {
                System.out.println(i + ": " + mendiak.get(i).toString());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred reading mendiak ArrayList.");
            e.printStackTrace();
        }
    }

    /**
     * Mendirik altuera kalkulatzen du mendiak ArrayList-etik.
     */
    public static void mendiAltuena() {
        try {
            double altueraHandiena = 0;
            int posizioa = 0;

            for (int i = 0; i < mendiak.size(); i++) {
                if (mendiak.get(i).getAltuera() > altueraHandiena) {
                    altueraHandiena = mendiak.get(i).getAltuera();
                    posizioa = i;
                }
            }
            System.out.println("Mendirik Altuena: " + mendiak.get(posizioa).toString());

        } catch (Exception e) {
            System.out.println("An error occurred calculating highest mountain.");
        }

    }

    /**
     * Mendien esportazio menua bistaratzen du, eta
     * createCSV-ri deitzen dio fitxategia sortzeko
     */


    /**
     * Parametroak erabiliz aukeraketa egiten da
     * zein probintziaren datuak nahi diren gorde jakiteko.
     * @param fileName
     * @param probintzia
     */
    public static void createCSV(String fileName, String probintzia){
        FileWriter writer = null;

        try {
            writer = new FileWriter(fileName);
            writer.append("Izena, Altuera , Probintzia \n");
            writer.append("--------------------------- \n");
            int e = 1; //zenbatgarren mendia den agertzeko csv-an

            for (int i = 0; i < mendiak.size(); i++) {
                if (mendiak.get(i).getProbintzia().equals(probintzia)) {
                    writer.append( e + "- " +  mendiak.get(i).getIzena() + ", " + mendiak.get(i).getAltuera() + ", " + mendiak.get(i).getProbintzia() + "\n");
                    e++;
                }
            }
            System.out.println("CSV file is created: " + fileName);
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred creating new CSV.");
        }

    }

}