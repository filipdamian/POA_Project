package service;

import domain.*;
import persistence.DoctorRepository;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    private DoctorRepository doctorRepository=new DoctorRepository();



    public void setDoctors(List<Doctor> doctors){
        this.doctorRepository.setPacientList(doctors);
    }
    public List<Doctor> getDoctors(){
        return doctorRepository.getDoctorList();
    }

    public void registerNewDoctor(Scanner in) throws Exception {
        this.doctorRepository.add(in);
        System.out.println("Doctor creat");
    }
    public void getDoctorByName(Scanner in) throws Exception {
        this.doctorRepository.get(in);
        System.out.println("Doctor afisat");
    }

    public void updateDoctorSurgeries(Scanner in) throws Exception {
        var doctor = this.doctorRepository.get(in);
        if(doctor instanceof MedicChirurg){
            int newSucceededSurgeries= Integer.parseInt(in.nextLine());
            int newFailedSurgeries= Integer.parseInt(in.nextLine());
            int nrMalpraxis= Integer.parseInt(in.nextLine());
            var currentSucceededSurgeries= ((MedicChirurg) doctor).getOperatiiReusite();
            var currentFailedSurgeries=((MedicChirurg) doctor).getOperatiiEsuate();
            var currentMalpraxis=((MedicChirurg) doctor).getMalpraxis();
            ((MedicChirurg) doctor).setOperatiiReusite(currentSucceededSurgeries+newSucceededSurgeries);
            ((MedicChirurg) doctor).setOperatiiEsuate(currentFailedSurgeries+newFailedSurgeries);
            ((MedicChirurg) doctor).setMalpraxis(currentMalpraxis+nrMalpraxis);

        }
        else{
            throw new Exception("medicul selectat nu este chirurg!");
        }
    }
    public void removePacientsFromDoctor(Scanner in) throws Exception {
        var doctor=this.doctorRepository.get(in);
        int nrPacients= Integer.parseInt(in.nextLine());
        if(doctor instanceof MedicChirurg){
            int currentNrPac=((MedicChirurg) doctor).getNrPacienti();
            if(currentNrPac>=nrPacients)
                ((MedicChirurg) doctor).setNrPacienti(currentNrPac-nrPacients);
            else{
                throw new Exception("numarul de pacienti introdus este incorect");
            }

        }
        else
        if(doctor instanceof DoctorSpecialist){
            int currentNrPac=((DoctorSpecialist) doctor).getNrPacienti();
            if(currentNrPac>=nrPacients)
                ((DoctorSpecialist) doctor).setNrPacienti(currentNrPac-nrPacients);
            else{
                throw new Exception("numarul de pacienti introdus este incorect");
            }
        }else
        if(doctor instanceof DoctorDeFamilie){
            int currentNrPac=((DoctorDeFamilie) doctor).getNrPacienti();
            if(currentNrPac>=nrPacients)
                ((DoctorDeFamilie) doctor).setNrPacienti(currentNrPac-nrPacients);
            else{
                throw new Exception("numarul de pacienti introdus este incorect");
            }
        }


    }
    public void SetDoctorVacation(Scanner in) throws Exception {
        var doctor=this.doctorRepository.get(in);
        doctor.setConcediu(Boolean.parseBoolean(in.nextLine()));


    }
}
