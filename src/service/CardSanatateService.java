package service;

import persistence.CardSanatateRepository;

import java.util.Scanner;

public class CardSanatateService {
    private CardSanatateRepository cardSanatateRepository=new CardSanatateRepository();
    public void registerNewHealthCard(Scanner in) throws Exception {
        this.cardSanatateRepository.add(in);
    }
    public void getListOfHealthCards(){
        this.cardSanatateRepository.getList();

    }
}
