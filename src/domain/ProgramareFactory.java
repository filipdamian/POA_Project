package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class ProgramareFactory {
    private static int IdUnic=0;
    public  static void incrementIdUnic(int nr){
        ProgramareFactory.IdUnic+=nr;
    }
    public Programare createProgramare(Scanner in) throws ParseException {
        this.IdUnic+=1;
        return new Programare(IdUnic,in);
    }
    public Programare createProgramare(ResultSet in) throws SQLException {
        return new Programare(IdUnic++, in);
    }
}
