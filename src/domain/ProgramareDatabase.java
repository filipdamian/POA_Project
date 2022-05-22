package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProgramareDatabase {
    Connection connection;
    ProgramareFactory programareFactory=new ProgramareFactory();
    public ProgramareDatabase(Connection connection){
        this.connection=connection;
    }
    public List<Programare> read(){
        List<Programare> programareList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery("Select * from Appointments");
            while(result.next()){
                Programare current=programareFactory.createProgramare(result);
                programareList.add(current);
            }
            statement.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return programareList;
    }

    public void update(Programare newProgramare){
        try{
            String query = "UPDATE programari SET dataprogramare = ?, numedoctor = ? WHERE idProgramari = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, (new SimpleDateFormat("yyyy-MM-dd")).format(newProgramare.getDataProgramare()));
            preparedStmt.setString(2, newProgramare.getNumeDoctor());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void create(Programare newProgramare){
        try{
            String query = "INSERT INTO programari (idProgramari, dataprogramare, numedoctor) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,newProgramare.getId());
            preparedStmt.setString(2, (new SimpleDateFormat("yyyy-MM-dd")).format(newProgramare.getDataProgramare()));
            preparedStmt.setString(3, newProgramare.getNumeDoctor());


            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void delete(Programare newProgramare){
        try{
            String query = "DELETE FROM programari WHERE idProgramari = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, newProgramare.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
