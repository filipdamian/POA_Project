package service;

import domain.Programare;

import java.util.List;
import java.util.Scanner;

public interface IProgramareService {
    public void createNewAppointment(Scanner in) throws Exception;
    public void getAllAppointments();
    public void setProgramari(List<Programare> programares);
    public List<Programare> getProgramari();
}
