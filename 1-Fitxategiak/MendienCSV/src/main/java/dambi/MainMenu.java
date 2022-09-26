package dambi;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList; // import the ArrayList class



public class MainMenu {

    static ArrayList<Mendia> mendiak = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        //cvsIrakurri();

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
        in.next();
    }

    public static void mendienZerrenda() {
        cvsIrakurri(); //main-ean egin beharreko metodoa
        try {
            for (int i = 0; i < mendiak.size(); i++) {
                System.out.println(i + ": " + mendiak.get(i).toString());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred reading mendiak ArrayList.");
            e.printStackTrace();
        }
    }

    public static void mendiAltuena() {
        cvsIrakurri();
        try {
            int altueraHandiena = 0;
            int posizioa;

            for (int i = 0; i < mendiak.size(); i++) {
                if (mendiak.get(i).getAltuera() > altueraHandiena) {
                    altueraHandiena = mendiak.get(i).getAltuera();
                    posizioa = i;
                }
            }
            System.out.println("Mendirik Altuena: " + altueraHandiena);
            System.out.println();
        } catch (Exception e) {
            System.out.println("An error occurred calculating highest mountain.");
        }

    }

    public static void mendiakCSV() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Zein lurraldetako mendiak esportatu nahi dituzu (1,2,3) ? ");
            System.out.println("1 - Araba");
            System.out.println("2 - Bizkaia");
            System.out.println("3 - Gipuzkoa");
            int aukera = sc.nextInt();

            switch (aukera) {
                case 1:
                    System.out.println();
                    break;
                case 2:
            }

        }catch(Exception ex){
            System.out.println("sdf");
        }

    }


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


}
