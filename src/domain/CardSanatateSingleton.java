package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CardSanatateSingleton {
    private static CardSanatateSingleton single_instance=null;
    final private CardSanatateFactory cardSanatateFactory=new CardSanatateFactory();
    private List<CardSanatate> cardSanatates=new ArrayList<CardSanatate>();

    public static CardSanatateSingleton getSingle_instance() {
        if(single_instance==null)
            single_instance=new CardSanatateSingleton();
        return single_instance;
    }

    public void setCardSanatates(List<CardSanatate> cardSanatates) {
        this.cardSanatates = cardSanatates;
    }
    public List<CardSanatate> getCardSanatates() {
        return cardSanatates;
    }
    private static List<String[]> getCSVColumns(String fileName){
        List<String[]> columns = new ArrayList<>();

        try(var in = new BufferedReader(new FileReader(fileName))) {

            String line;

            while((line = in.readLine()) != null ) {
                String[] fields = line.split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("No saved health insurance cards!");
        }

        return columns;
    }
    public void loadFromCSV() {
        try{
            var columns = CardSanatateSingleton.getCSVColumns("data/healthinsurancecard.csv");
            for(var fields : columns){

                var newCardSanatate = new CardSanatate(
                        Integer.parseInt(fields[0]),
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[1]),
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]),
                        fields[3],
                        Boolean.parseBoolean(fields[4])
                );
                cardSanatates.add(newCardSanatate);
            }
            CardSanatateFactory.incrementIdUnic(columns.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/healthinsurancecard.csv");
            for(var card : this.cardSanatates){
                writer.write(card.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
