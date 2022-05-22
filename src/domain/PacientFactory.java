package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class PacientFactory {
    private static int IdUnic=0;
    public  static void incrementIdUnic(int nr){
        PacientFactory.IdUnic+=nr;
    }
    public Pacient createPacient(Scanner in) throws ParseException {
        this.IdUnic+=1;
        return new Pacient(IdUnic,in);
    }
    public Pacient createPacient(ResultSet in) throws SQLException{
        return new Pacient(IdUnic++, in);
    }
}
