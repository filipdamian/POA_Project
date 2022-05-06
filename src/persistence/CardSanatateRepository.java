package persistence;

import domain.CardSanatate;
import domain.CardSanatateFactory;
import domain.Doctor;
import domain.PacientFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardSanatateRepository implements GenericRepository<CardSanatate> {
    private List<CardSanatate> cardSanatateList=new ArrayList<>();
    private final CardSanatateFactory cardSanatateFactory = new CardSanatateFactory();

    public List<CardSanatate> getList(){
        System.out.println(cardSanatateList);
        return cardSanatateList;
    }

    public List<CardSanatate> getCardsList() {
        return cardSanatateList;
    }

    public void setCardsList(List<CardSanatate> cardSanatates) {
        this.cardSanatateList = cardSanatates;
    }
    @Override
    public void add(Scanner in) throws Exception {
        CardSanatate cardSanatate=cardSanatateFactory.createCardSanatate(in);
        this.cardSanatateList.add(cardSanatate);
    }

    @Override
    public CardSanatate get(Scanner in) throws Exception {
        return null;
    }

    @Override
    public void update(CardSanatate entity) {

    }

    @Override
    public void delete(CardSanatate entity) {

    }
}
