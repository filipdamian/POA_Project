package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PacientDatabase {
    Connection connection;
    PacientFactory pacientFactory=new PacientFactory();

    public PacientDatabase(Connection connection){
        this.connection=connection;
    }
    public List<Pacient> read(){
        List<Pacient> pacientList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery("Select * from pacients");
            while(result.next()){
                Pacient current=pacientFactory.createPacient(result);
                pacientList.add(current);
            }
            statement.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return pacientList;
    }
    public void update(Pacient newPacient){
        try{
            String query = "UPDATE pacients SET nume = ?, prenume = ?,  telefon = ?, adresa = ?, datanasterii = ?, email = ?, CNP = ? WHERE idPacients = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, newPacient.getNume());
            preparedStmt.setString(2, newPacient.getPrenume());
            preparedStmt.setString(3, newPacient.getCNP());
            preparedStmt.setString(4, newPacient.getTelefon());
            preparedStmt.setString(5, newPacient.getAdresa());
            preparedStmt.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(newPacient.getDataNasterii()));
            preparedStmt.setString(7, newPacient.getEmail());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void create(Pacient newPacient){
        try{
            String query = "INSERT INTO pacients (idPacients, nume, prenume, telefon, adresa, datanasterii, email, CNP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, newPacient.getId());
            preparedStmt.setString(2, newPacient.getNume());
            preparedStmt.setString(3, newPacient.getPrenume());
            preparedStmt.setString(4, newPacient.getAdresa());
            preparedStmt.setString(5, newPacient.getCNP());
            preparedStmt.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(newPacient.getDataNasterii()));
            preparedStmt.setString(7, newPacient.getTelefon());
            preparedStmt.setString(8, newPacient.getEmail());

            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete(Pacient pacient){
        try{
            String query = "DELETE FROM pacients WHERE idPacients = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, pacient.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
