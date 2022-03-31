package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programare {
    private Date DataProgramare;
    private String NumeDoctor;

    public Programare(Date dataProgramare, String numeDoctor ) {
        this.DataProgramare = dataProgramare;
        this.NumeDoctor = numeDoctor;

    }
    public Programare(Scanner in) throws ParseException {
        citire(in);
    }

    public void citire(Scanner in) throws ParseException {
        System.out.println("DATA_PROGRAMARE : ");
        this.DataProgramare=new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine());
        System.out.println("NUME_DOCTOR : ");
        this.NumeDoctor=in.nextLine();
    }
    public String toString() {
        return "{" +
                "DATA_PROGRAMARE=" + DataProgramare +
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


}
