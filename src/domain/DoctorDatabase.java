package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DoctorDatabase {
    Connection connection;
    DoctorFactory doctorFactory=new DoctorFactory();
    public DoctorDatabase(Connection connection){
        this.connection=connection;
    }

    public List<Doctor> read(){
        List<Doctor> doctorList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery("Select * from Doctors");
            while(result.next()){
                Doctor current=doctorFactory.createDoctor(result);
                doctorList.add(current);
            }
            statement.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return doctorList;
    }
    public void update(Doctor newDoctor){
        try{
            String query = "UPDATE doctors SET nume = ?, prenume = ?,  salariu = ?, concediu = ? WHERE idDoctor = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, newDoctor.getNume());
            preparedStmt.setString(2, newDoctor.getPrenume());
            preparedStmt.setInt(3, newDoctor.getSalariu());
            preparedStmt.setBoolean(4, newDoctor.isConcediu());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void create(Doctor newDoctor){
        try{
            String query = "INSERT INTO doctors (idDoctor, nume, prenume, salariu, concediu) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, newDoctor.getId());
            preparedStmt.setString(2, newDoctor.getNume());
            preparedStmt.setString(3, newDoctor.getPrenume());
            preparedStmt.setInt(4, newDoctor.getSalariu());
            preparedStmt.setBoolean(5, newDoctor.isConcediu());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete(Doctor doctor){
        try{
            String query = "DELETE FROM doctors WHERE idDoctor = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, doctor.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
