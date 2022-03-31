package persistence;

import domain.CardSanatate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardSanatateRepository implements GenericRepository<CardSanatate> {
    private List<CardSanatate> cardSanatateList=new ArrayList<>();

    public List<CardSanatate> getList(){
        System.out.println(cardSanatateList);
        return cardSanatateList;
    }

    @Override
    public void add(Scanner in) throws Exception {
        CardSanatate cardSanatate=new CardSanatate(in);
        cardSanatateList.add(cardSanatate);
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
