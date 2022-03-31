package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Pacient {
    private final int Id;
    private String Nume;
    private String Prenume;
    private String CNP;
    private String Telefon;
    private String Adresa;
    private Date DataNasterii;
    private String Email;
    private Istoric Istoric;

    public Pacient(int IdUnic, Scanner in) throws ParseException {
        this.Id = IdUnic;
        this.citire(in);
    }

    public void citire(Scanner in) throws ParseException {
        System.out.println("NUME : ");
        this.Nume = in.nextLine();
        System.out.println("PRENUME : ");
        this.Prenume = in.nextLine();
        System.out.println("CNP : ");
        this.CNP = in.nextLine();
        System.out.println("TELEFON : ");
        this.Telefon = in.nextLine();
        System.out.println("ADRESA : ");
        this.Adresa = in.nextLine();
        System.out.println("DATA NASTERII : ");
        this.DataNasterii = new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine());
        System.out.println("EMAIL : ");
        this.Email = in.nextLine();
        this.Istoric=new Istoric(in);

    }

    public Pacient(int id, String nume, String prenume, String cnp, String telefon, String adresa, Date dataNasterii, String email, domain.Istoric istoric) {
        this.Id = id;
        this.Nume = nume;
        this.Prenume = prenume;
        this.CNP = cnp;
        this.Telefon = telefon;
        this.Adresa = adresa;
        this.DataNasterii = dataNasterii;
        this.Email = email;
        this.Istoric = istoric;
    }
    @Override
    public String toString() {
        return "{" +
                "PacientID=" + Id +
                ", NUME=" + Nume + '\'' +
                ", PRENUME='" + Prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", TELEFON='" + Telefon + '\'' +
                ", ADRESA='" + Adresa + '\'' +
                ", DATA_NASTERII=" + (new SimpleDateFormat("dd-MM-yyyy")).format(DataNasterii) +
                ", EMAIL='" + Email + '\'' +
                ", ISTORIC='" + Istoric.toString() + '\'' +
                '}';
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

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public Date getDataNasterii() {
        return DataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        DataNasterii = dataNasterii;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public domain.Istoric getIstoric() {
        return Istoric;
    }

    public void setIstoric(domain.Istoric istoric) {
        Istoric = istoric;
    }
}

