package persistence;

import domain.Doctor;
import domain.DoctorFactory;
import domain.Pacient;
import domain.PacientFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorRepository implements GenericRepository<Doctor>{
    private List<Doctor> doctorList= new ArrayList<>();
    private final DoctorFactory doctorFactory = new DoctorFactory();


    private Doctor getByName(Scanner in) throws Exception {
        if(this.doctorList.size()==0)
            throw new Exception("Nu exista doctori momentan!");

        //return doctorList.stream().filter(p->in.nextLine().equals(p.getNume())).findAny().orElse(null);
        String nume=in.nextLine();
        for(Doctor doctor : doctorList){
            if(doctor.getNume().equals(nume))
                return doctor;
        }
        return null;
    }

    @Override
    public void add(Scanner in) throws Exception {
        Doctor newDoc=doctorFactory.createDoctor(in);
        this.doctorList.add(newDoc);
    }

    @Override
    public Doctor get(Scanner in) throws Exception {
        System.out.println(doctorList);
        var doctor = this.getByName(in);
        System.out.println(doctor);
        return doctor;
    }

    @Override
    public void update(Doctor entity) {

    }

    @Override
    public void delete(Doctor entity) {

    }
}
