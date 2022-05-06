package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProgramareSingleton {
    private static ProgramareSingleton single_instance=null;
    final private ProgramareFactory programareFactory=new ProgramareFactory();
    private List<Programare> programares=new ArrayList<Programare>();

    public static ProgramareSingleton getSingle_instance() {
        if(single_instance==null)
            single_instance=new ProgramareSingleton();
        return single_instance;
    }

    public void setProgramares(List<Programare> programares) {
        this.programares = programares;
    }
    public List<Programare> getProgramares() {
        return programares;
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
            System.out.println("No saved appointments!");
        }

        return columns;
    }
    public void loadFromCSV() {
        try{
            var columns = ProgramareSingleton.getCSVColumns("data/appointments.csv");
            for(var fields : columns){

                var newProgramare = new Programare(
                    Integer.parseInt(fields[0]),
                    new SimpleDateFormat("dd-MM-HH-mm-ss zzz yyyy").parse(fields[1]),
                    fields[2]

                );
                programares.add(newProgramare);
            }
            ProgramareFactory.incrementIdUnic(columns.size());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/appointments.csv");
            for(var programare : this.programares){
                writer.write(programare.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
