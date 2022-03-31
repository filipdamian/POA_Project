package service;

import persistence.ProgramareRepository;

import java.util.Scanner;

public class ProgramareService {
    private ProgramareRepository programareRepository=new ProgramareRepository();
    public void createNewAppointment(Scanner in) throws Exception {
        this.programareRepository.add(in);
        System.out.println("Programare creata");
    }
    public void getAllAppointments(){
        this.programareRepository.getList();
    }
}
