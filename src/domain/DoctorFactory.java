package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class DoctorFactory {
    private static int IdUnic=0;
    public static void incrementIdUnic(int nr){
        DoctorFactory.IdUnic+=nr;
    }
    public Doctor createDoctor(Scanner in) throws Exception {
        this.IdUnic+=1;
        System.out.println("1 -- Medic de familie");
        System.out.println("2 -- Medic Specialist");
        System.out.println("3 -- Medic Chirurg");
        int tipDoctor=Integer.parseInt(in.nextLine());
        if(tipDoctor==1)
            return new DoctorDeFamilie(this.IdUnic,in);
        if(tipDoctor==2)
            return new DoctorSpecialist(this.IdUnic,in);
        if(tipDoctor==3)
            return new MedicChirurg(this.IdUnic,in);
        else
            throw new Exception("nu a fost introdus tipul corect de doctor");
    }
    public Doctor createDoctor(ResultSet in) throws SQLException {
        this.IdUnic+=1;
        System.out.println("1 -- Medic de familie");
        System.out.println("2 -- Medic Specialist");
        System.out.println("3 -- Medic Chirurg");
        Scanner inn = new Scanner(System.in);
        int tipDoctor=Integer.parseInt(inn.nextLine());
        if(tipDoctor==1)
            return new DoctorDeFamilie(this.IdUnic,in);
        if(tipDoctor==2)
            return new DoctorSpecialist(this.IdUnic,in);
        if(tipDoctor==3)
            return new MedicChirurg(this.IdUnic,in);
        return null;
    }
}
