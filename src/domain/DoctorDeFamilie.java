package domain;

import java.util.Scanner;

public class DoctorDeFamilie extends  Doctor {
    protected int NrPacienti;

    public DoctorDeFamilie(int id, String nume, String prenume, int salariu, boolean concediu, int nrPacienti) {
        super(id, nume, prenume, salariu, concediu);
        this.NrPacienti = nrPacienti;
    }

    public DoctorDeFamilie() {
    }

    public DoctorDeFamilie(int IdUnic, Scanner in) throws Exception {
        this.Id = IdUnic;
        this.citireMedFam(in);

    }


    public void citireMedFam(Scanner in) {
        super.citire(in);
        System.out.println("NrPacienti : ");
        this.NrPacienti = Integer.parseInt(in.nextLine());
    }

    @Override
    public String toString() {
        return "{" +
                "DOCTORID=" + Id +
                ", NUME='" + Nume + '\'' +
                ", PRENUME='" + Prenume + '\'' +
                ", SALARIU='" + Salariu + '\'' +
                ", CONCEDIU='" + Concediu + '\'' +
                ", NRPACIENTI=" + NrPacienti +
                '}';

    }

    public int getNrPacienti() {
        return NrPacienti;
    }

    public void setNrPacienti(int nrPacienti) {
        NrPacienti = nrPacienti;
    }
}
