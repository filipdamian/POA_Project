package service;

import domain.CardSanatate;

import persistence.CardSanatateRepository;

import java.util.List;
import java.util.Scanner;

public class CardSanatateService {
    private CardSanatateRepository cardSanatateRepository=new CardSanatateRepository();
    public void registerNewHealthCard(Scanner in) throws Exception {
        this.cardSanatateRepository.add(in);
    }
    public void getListOfHealthCards(){
        this.cardSanatateRepository.getList();

    }

    public void setCards(List<CardSanatate> cardSanatates){
        this.cardSanatateRepository.setCardsList(cardSanatates);
    }
    public List<CardSanatate> getCards(){
        return cardSanatateRepository.getCardsList();
    }

}
