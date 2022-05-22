package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CardSanatateDatabase {
    Connection connection;
    CardSanatateFactory cardSanatateFactory=new CardSanatateFactory();
    public CardSanatateDatabase(Connection connection){
        this.connection=connection;
    }
    public List<CardSanatate> read(){
        List<CardSanatate> cardSanatateList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery("Select * from healthinsurancecard");
            while(result.next()){
                CardSanatate current=cardSanatateFactory.createCardSanatate(result);
                cardSanatateList.add(current);
            }
            statement.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return cardSanatateList;
    }
    public void update(CardSanatate newCardSanatate){
        try{
            String query = "UPDATE cards SET datacreare = ?, dataexpirare = ?,  tipcard = ?, valid = ? WHERE idCards = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, (new SimpleDateFormat("yyyy-MM-dd")).format(newCardSanatate.getDataCreare()));
            preparedStmt.setString(2,(new SimpleDateFormat("yyyy-MM-dd")).format(newCardSanatate.getDataExpirare()));
            preparedStmt.setString(3, newCardSanatate.getTipCardSanatate());
            preparedStmt.setBoolean(4, newCardSanatate.getValid());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void create(CardSanatate newCardSanatate){
        try{
            String query = "INSERT INTO cards (idCards, datacreare, dataexpirare, tipcard, valid) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, newCardSanatate.getId());
            preparedStmt.setString(2, (new SimpleDateFormat("yyyy-MM-dd")).format(newCardSanatate.getDataCreare()));
            preparedStmt.setString(3, (new SimpleDateFormat("yyyy-MM-dd")).format(newCardSanatate.getDataExpirare()));
            preparedStmt.setString(4, newCardSanatate.getTipCardSanatate());
            preparedStmt.setBoolean(5, newCardSanatate.getValid());


            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void delete(CardSanatate cardSanatate){
        try{
            String query = "DELETE FROM cards WHERE idCards = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, cardSanatate.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
