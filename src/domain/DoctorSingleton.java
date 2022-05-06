package domain;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DoctorSingleton {
    private static DoctorSingleton single_instance=null;
    final private DoctorFactory doctorFactory=new DoctorFactory();
    private List<Doctor> doctors=new ArrayList<Doctor>();

    public static DoctorSingleton getSingle_instance() {
        if(single_instance==null)
            single_instance=new DoctorSingleton();
        return single_instance;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
    public List<Doctor> getDoctors() {
        return doctors;
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
            System.out.println("No saved doctors!");
        }

        return columns;
    }
    public void loadFromCSV() {
        try{
            var columns = DoctorSingleton.getCSVColumns("data/doctors.csv");
            for(var fields : columns){

                var newDoctor = new Doctor(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        Integer.parseInt(fields[3]),
                        Boolean.parseBoolean(fields[4])

                );
                doctors.add(newDoctor);
            }
            DoctorFactory.incrementIdUnic(columns.size());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/doctors.csv");
            for(var doctor : this.doctors){
                writer.write(doctor.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
