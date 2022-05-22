package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.List;

public class PacientSingleton {

    private static PacientSingleton single_instance=null;
    final private PacientFactory pacientFactory= new PacientFactory();
    private List<Pacient> pacients=new ArrayList<Pacient>();

    public static PacientSingleton getSingle_instance() {
        if(single_instance==null)
            single_instance=new PacientSingleton();
        return single_instance;
    }

    public void setPacients(List<Pacient> pacients) {
        this.pacients = pacients;
    }

    public List<Pacient> getPacients() {
        return pacients;
    }

    private static List<String[]> getCSVColumns(String fileName){
        List<String[]> columns = new ArrayList<>();

        try(var in = new BufferedReader(new FileReader(fileName))) {

            String line;

            while((line = in.readLine()) != null ) {
                String[] fields = line.split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("No saved pacients!");
        }

        return columns;
    }
    public void loadFromCSV() {
        try{
            var columns = PacientSingleton.getCSVColumns("data/pacients.csv");
            for(var fields : columns){

                var newPacients = new Pacient(
                        Integer.parseInt(fields[0]), //id
                        fields[1], //nume
                        fields[2], //prenume
                        fields[3], //cnp
                        fields[4], //telefon
                        fields[5], //adresa(str)
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[6]),
                        fields[7] //email
                         // istoric (Istoric)

                );
                pacients.add(newPacients);
            }
            PacientFactory.incrementIdUnic(columns.size());
        }catch (ParseException e){
            System.out.println(e.toString());
        }

    }

    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/pacients.csv");
            for(var pacient : this.pacients){
                writer.write(pacient.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
