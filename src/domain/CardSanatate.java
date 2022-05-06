package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CardSanatate {
    private final int Id;
    private Date DataCreare;
    private Date DataExpirare;
    private String TipCardSanatate;
    private Boolean Valid;


    public CardSanatate(int id,Date dataCreare, Date dataExpirare, String tipCardSanatate, Boolean valid) {
        this.Id=id;
        this.DataCreare = dataCreare;
        this.DataExpirare = dataExpirare;
        this.TipCardSanatate = tipCardSanatate;
        this.Valid = valid;
    }

    public CardSanatate(int IdUnic,Scanner in) throws ParseException {
        this.Id=IdUnic;
        this.citire(in);
    }


    public void citire(Scanner in) throws ParseException {
        System.out.println("DATA_CREARE : ");
        this.DataCreare=new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine());
        System.out.println("DATA_EXPIRARE : ");
        this.DataExpirare=new SimpleDateFormat("dd-MM-yyyy").parse(in.nextLine());
        System.out.println("TIP_CARD_SANATATE : ");
        this.TipCardSanatate=in.nextLine();
        System.out.println("VALID : ");
        this.Valid= Boolean.valueOf(in.nextLine());
    }


    public String toString() {
        return "{" +
                "CardSanatateID="+ Id+
                ", DATA_CREARE=" + DataCreare +
                ", DATA_EXPIRARE='" + DataExpirare + '\'' +
                ", TIP_CARD_SANATATE='" + TipCardSanatate + '\'' +
                ", VALID='" + Valid + '\'' +
                '}';
    }

    public Date getDataCreare() {
        return DataCreare;
    }

    public void setDataCreare(Date dataCreare) {
        DataCreare = dataCreare;
    }

    public Date getDataExpirare() {
        return DataExpirare;
    }

    public void setDataExpirare(Date dataExpirare) {
        DataExpirare = dataExpirare;
    }

    public String getTipCardSanatate() {
        return TipCardSanatate;
    }

    public void setTipCardSanatate(String tipCardSanatate) {
        TipCardSanatate = tipCardSanatate;
    }

    public Boolean getValid() {
        return Valid;
    }

    public void setValid(Boolean valid) {
        Valid = valid;
    }
    public String toCSV() {
        return Id+","+DataCreare+","+DataExpirare+","+TipCardSanatate+","+Valid;
    }
}
