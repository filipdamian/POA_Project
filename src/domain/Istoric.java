package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Istoric {
    private Set<String> Afectiuni;
    private HashMap<String, Boolean> Vindecat;
    private HashMap<String,Date> DataDiagonezi;
    private HashMap<String,String> Tratament;

    public Istoric(Set<String> afectiuni, HashMap<String, Boolean> vindecat, HashMap<String, Date> dataDiagonezi, HashMap<String, String> tratament) {
        this.Afectiuni = afectiuni;
        this.Vindecat = vindecat;
        this.DataDiagonezi = dataDiagonezi;
        this.Tratament = tratament;
    }
   public Istoric(Scanner in) throws ParseException {
        this.citire(in);
    }


    public void citire(Scanner in) throws ParseException {
        System.out.println("NR AFECTIUNI GASITE : ");

        int n= Integer.parseInt(in.nextLine());
        System.out.println("AFECTIUNI : ");
        Set<String> Afectiuni=new HashSet<String>();
        for(int i=0;i<n;i++)
        {
            Afectiuni.add(in.nextLine());
        }
        this.Afectiuni=Afectiuni;
        HashMap<String,Boolean> Vindecat=new HashMap<>();
        System.out.println("STAGIU AFECTIUNE :    [0-nevindecat/1-vindecat] ");
        for(String afectiune:Afectiuni)
        {
            System.out.println(afectiune);
           Vindecat.put(afectiune, Boolean.valueOf(in.nextLine()));
        }
        this.Vindecat=Vindecat;

        System.out.println("DATA_DIAGNOZA : ");
        HashMap<String,Date> DataDiagnozei=new HashMap<>();
        //this.DataDiagonezi = new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine());
        for(String afectiune:Afectiuni){
            System.out.println(afectiune);
            DataDiagnozei.put(afectiune,new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine()));
        }
        this.DataDiagonezi=DataDiagnozei;
        System.out.println("TRATAMENT : ");
        HashMap<String,String> Tratament=new HashMap<>();
        for(String afectiune:Afectiuni){
            System.out.println(afectiune);
            Tratament.put(afectiune,in.nextLine());
        }
        this.Tratament=Tratament;

    }

    public String toString() {
        return "{" +
                "AFECTIUNI=" + Afectiuni +
                ", VINDECAT='" + Vindecat + '\'' +
                ", DATA_DIAGNOZA='" + DataDiagonezi + '\'' +
                ", TRATAMENT='" + Tratament + '\'' +
                '}';
    }





    public HashMap<String, Boolean> getVindecat() {
        return Vindecat;
    }

    public void setVindecat(HashMap<String, Boolean> vindecat) {
        Vindecat = vindecat;
    }

    public Set<String> getAfectiuni() {
        return Afectiuni;
    }

    public void setAfectiuni(Set<String> afectiuni) {
        Afectiuni = afectiuni;
    }

    public HashMap<String, Date> getDataDiagonezi() {
        return DataDiagonezi;
    }

    public void setDataDiagonezi(HashMap<String, Date> dataDiagonezi) {
        DataDiagonezi = dataDiagonezi;
    }

    public HashMap<String, String> getTratament() {
        return Tratament;
    }

    public void setTratament(HashMap<String, String> tratament) {
        Tratament = tratament;
    }

    public String toCSV() {
        return Afectiuni+","+Vindecat+","+DataDiagonezi+","+Tratament;
    }
}
