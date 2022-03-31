package service;

import persistence.IstoriRepository;

import java.util.Scanner;

public class IstoricService {
    private IstoriRepository istoriRepository=new IstoriRepository();

    public void registerPacientAffHistory(Scanner in) throws Exception {
        this.istoriRepository.add(in);
        System.out.println("Istoric creat");
    }
    public void getPacientAffHistory(){
        this.istoriRepository.getList();
    }
}
