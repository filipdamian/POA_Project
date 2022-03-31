package service;

import persistence.PacientRepository;

import java.text.ParseException;
import java.util.Scanner;

public class PacientService {
    private PacientRepository pacientRepository=new PacientRepository();

    public void registerNewPacient(Scanner in) throws ParseException {
       this.pacientRepository.add(in);
        System.out.println("Pacient creat");
    }
    public void getPacientByName(Scanner in) throws Exception {
        this.pacientRepository.get(in);
        System.out.println("Pacient afisat");
    }
    public void updatePacientCNP(Scanner in) throws Exception {
         var pacient=this.pacientRepository.get(in);
         String newCNP = in.nextLine();
         pacient.setCNP(newCNP);

    }
    public void removePacientByCNP(Scanner in) throws Exception {
        var pacient=this.pacientRepository.getPacientByCNP(in);
        this.pacientRepository.delete(pacient);
    }
}
