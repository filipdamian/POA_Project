package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Doctor {
    protected  int Id;
    protected String Nume;
    protected String Prenume;
    protected int Salariu;
    protected boolean Concediu;

    public Doctor(int id, String nume, String prenume, int salariu, boolean concediu) {
        this.Id = id;
        this.Nume = nume;
        this.Prenume = prenume;
        this.Salariu = salariu;
        this.Concediu = concediu;
    }

    public Doctor() {
    }

    public void citire(Scanner in) {
        System.out.println("NUME : ");
        this.Nume = in.nextLine();
        System.out.println("PRENUME : ");
        this.Prenume = in.nextLine();
        System.out.println("SALARIU : ");
        this.Salariu = Integer.parseInt(in.nextLine());
        System.out.println("CONCEDIU : ");
        this.Concediu = Boolean.parseBoolean(in.nextLine());
    }

    public String toString() {
        return "{" +
                "DOCTORID=" + Id +
                ", NUME='" + Nume + '\'' +
                ", PRENUME='" + Prenume + '\'' +
                ", SALARIU='" + Salariu + '\'' +
                ", CONCEDIU='" + Concediu + '\'' +
                '}';
    }
    public int getId() {
        return Id;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public int getSalariu() {
        return Salariu;
    }

    public void setSalariu(int salariu) {
        Salariu = salariu;
    }

    public boolean isConcediu() {
        return Concediu;
    }

    public void setConcediu(boolean concediu) {
        Concediu = concediu;
    }
    public String toCSV() {
        return Id+","+Nume+","+Prenume+","+Salariu+","+Concediu;
    }
}
