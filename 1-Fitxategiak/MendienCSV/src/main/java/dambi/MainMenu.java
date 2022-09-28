package dambi;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class

import java.io.FileWriter;


public class MainMenu {

    static ArrayList<Mendia> mendiak = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        cvsIrakurri();

        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien Zerrenda Ikusi");
            System.out.println("2.- Mendirik Altuena Bistarazi");
            System.out.println("3.- Mendiak Esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- ...");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");

            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    mendienZerrenda();
                    break;
                case 2:
                    mendiAltuena();
                    break;
                case 3:
                    mendiakCSV();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        }
        while (aukera != 5);

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
            int altueraHandiena = 0;
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