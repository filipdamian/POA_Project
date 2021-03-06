package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programare {
    public int getId() {
        return Id;
    }

    private final int Id;
    private Date DataProgramare;
    private String NumeDoctor;

    public Programare(int id,Date dataProgramare, String numeDoctor ) {
        this.Id=id;
        this.DataProgramare = dataProgramare;
        this.NumeDoctor = numeDoctor;

    }
    public Programare(int IdUnic,Scanner in) throws ParseException {
        this.Id=IdUnic;
        citire(in);
    }
    public Programare(int IdUnic, ResultSet in) throws SQLException {
        this.Id = IdUnic;
        this.read(in);
    }

    public void citire(Scanner in) throws ParseException {
        System.out.println("DATA_PROGRAMARE : ");
        this.DataProgramare=new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine());
        System.out.println("NUME_DOCTOR : ");
        this.NumeDoctor=in.nextLine();
    }
    public void read(ResultSet in) throws SQLException {
        this.DataProgramare = in.getDate("dataprogramare");
        this.NumeDoctor = in.getString("numedoctor");

    }
    public String toString() {
        return "{" +
                "ProgramareID=" + Id +
                ", DATA_PROGRAMARE=" + DataProgramare +
                ", NUME_DOCTOR='" + NumeDoctor + '\'' +
                '}';
    }
    public Date getDataProgramare() {
        return DataProgramare;
    }

    public void setDataProgramare(Date dataProgramare) {
        DataProgramare = dataProgramare;
    }

    public String getNumeDoctor() {
        return NumeDoctor;
    }

    public void setNumeDoctor(String numeDoctor) {
        NumeDoctor = numeDoctor;
    }

    public String toCSV() {
        return Id+","+DataProgramare+","+NumeDoctor;
    }
}
