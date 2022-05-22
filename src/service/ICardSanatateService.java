package service;

import domain.CardSanatate;

import java.util.List;
import java.util.Scanner;

public interface ICardSanatateService {
    public void registerNewHealthCard(Scanner in) throws Exception;
    public void getListOfHealthCards();
    public void setCards(List<CardSanatate> cardSanatates);
    public List<CardSanatate> getCards();

}
