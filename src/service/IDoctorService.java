package service;

import domain.Doctor;

import java.util.List;
import java.util.Scanner;

public interface IDoctorService {
    public void setDoctors(List<Doctor> doctors);
    public List<Doctor> getDoctors();
    public void registerNewDoctor(Scanner in) throws Exception;
    public void getDoctorByName(Scanner in) throws Exception;
    public void updateDoctorSurgeries(Scanner in) throws Exception;
    public void removePacientsFromDoctor(Scanner in) throws Exception;
    public void SetDoctorVacation(Scanner in) throws Exception;
}
