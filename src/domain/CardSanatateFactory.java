package domain;

import java.text.ParseException;
import java.util.Scanner;

public class CardSanatateFactory {
    private static int IdUnic=0;
    public  static void incrementIdUnic(int nr){
        CardSanatateFactory.IdUnic+=nr;
    }
    public CardSanatate createCardSanatate(Scanner in) throws ParseException {
        this.IdUnic+=1;
        return new CardSanatate(IdUnic,in);
    }
}
