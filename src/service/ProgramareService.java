package service;


import domain.Programare;
import persistence.ProgramareRepository;

import java.util.List;
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
    public void setProgramari(List<Programare> programares){
        this.programareRepository.setProgramariList(programares);
    }
    public List<Programare> getProgramari(){
        return programareRepository.getProgramariList();
    }
}
