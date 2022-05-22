package service;

import domain.Pacient;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public interface IPacientService {
    public void setPacients(List<Pacient> pacients);

    public void registerNewPacient(Scanner in) throws ParseException;

    public void getPacientByName(Scanner in) throws Exception;
    public List<Pacient> getPacients();
    public void removePacientByCNP(Scanner in) throws Exception;
    public void updatePacientCNP(Scanner in) throws Exception;
}
