package domain;

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
