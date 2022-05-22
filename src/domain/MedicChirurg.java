package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MedicChirurg extends DoctorSpecialist{

    private int OperatiiReusite;
    private int OperatiiEsuate;
    private int Malpraxis;

    public MedicChirurg(int id, String nume, String prenume, int salariu, boolean concediu, int nrPacienti, String specializare, int operatiiReusite, int operatiiEsuate, int malpraxis) {
        super(id, nume, prenume, salariu, concediu, nrPacienti, specializare);
        this.OperatiiReusite = operatiiReusite;
        this.OperatiiEsuate = operatiiEsuate;
        this.Malpraxis = malpraxis;
    }
    public MedicChirurg(int IdUnic, Scanner in) throws Exception {
        this.Id = IdUnic;
        this.citireMedChirurg(in);

    }
    public MedicChirurg(int IdUnic, ResultSet in) throws SQLException {
        this.Id = IdUnic;
        this.read(in);
    }
    public void read(ResultSet in) throws SQLException {
        this.Nume = in.getString("nume");
        this.Prenume = in.getString("prenume");
        this.Salariu = in.getInt("salariu");
        this.Concediu = in.getBoolean("concediu");
        this.NrPacienti = in.getInt("nrpacienti");
        this.Specializare = in.getString("specializare");
        this.OperatiiEsuate=in.getInt("operatiiesuate");
        this.OperatiiReusite=in.getInt("operatiireusite");
        this.Malpraxis=in.getInt("malpraxis");

    }

    public String toString() {
        return "{" +
                " DOCTORID=" + Id  +
                ", NUME='" + Nume + '\'' +
                ", PRENUME='" + Prenume + '\'' +
                ", SALARIU='" + Salariu + '\'' +
                ", CONCEDIU='" + Concediu + '\'' +
                ", NRPACIENTI=" + NrPacienti +
                ", SPECIALIZARE='" + Specializare + '\'' +
                ", OP_SUCCES='" + OperatiiReusite + '\'' +
                ", OP_ESEC='" + OperatiiEsuate + '\'' +
                ", MALPRAXIS='" + Malpraxis + '\'' +

                '}';
    }

    public void citireMedChirurg(Scanner in) {
        super.citireMedSpecialist(in);
        System.out.println("Operatii reusite : ");
        this.OperatiiReusite = Integer.parseInt(in.nextLine());
        System.out.println("Operatii esuate : ");
        this.OperatiiEsuate = Integer.parseInt(in.nextLine());
        System.out.println("Malpraxis : ");
        this.Malpraxis = Integer.parseInt(in.nextLine());
    }

    public int getOperatiiReusite() {
        return OperatiiReusite;
    }

    public void setOperatiiReusite(int operatiiReusite) {
        OperatiiReusite = operatiiReusite;
    }

    public int getOperatiiEsuate() {
        return OperatiiEsuate;
    }

    public void setOperatiiEsuate(int operatiiEsuate) {
        OperatiiEsuate = operatiiEsuate;
    }

    public int getMalpraxis() {
        return Malpraxis;
    }

    public void setMalpraxis(int malpraxis) {
        Malpraxis = malpraxis;
    }
}
