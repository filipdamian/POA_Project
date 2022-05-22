package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorSpecialist extends  DoctorDeFamilie{

    protected String Specializare;

    public DoctorSpecialist(int id, String nume, String prenume, int salariu, boolean concediu, int nrPacienti, String specializare) {
        super(id, nume, prenume, salariu, concediu, nrPacienti);
        this.Specializare = specializare;
    }

    public DoctorSpecialist() {
    }
    public DoctorSpecialist(int IdUnic, Scanner in) throws Exception {
        this.Id = IdUnic;
        this.citireMedSpecialist(in);
    }
    public DoctorSpecialist(int IdUnic, ResultSet in) throws SQLException {
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

    }

    public void citireMedSpecialist(Scanner in) {
        super.citireMedFam(in);
        System.out.println("Specializare : ");
        this.Specializare = in.nextLine();
    }

    public String toString() {
        return "{" +
                "  DOCTORID=" + Id  +
                ", NUME='" + Nume + '\'' +
                ", PRENUME='" + Prenume + '\'' +
                ", SALARIU='" + Salariu + '\'' +
                ", CONCEDIU='" + Concediu + '\'' +
                ", NRPACIENTI=" + NrPacienti +
                ", SPECIALIZARE='" + Specializare + '\'' +

                '}';
    }

    public String getSpecializare() {
        return Specializare;
    }

    public void setSpecializare(String specializare) {
        Specializare = specializare;
    }
}
