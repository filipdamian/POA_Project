package persistence;

import domain.Doctor;
import domain.Pacient;
import domain.PacientFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacientRepository implements GenericRepository<Pacient> {

    private List<Pacient> pacientList= new ArrayList<>();
    private final PacientFactory pacientFactory = new PacientFactory();

    @Override
    public void add(Scanner in) throws ParseException {
        Pacient newpacient=pacientFactory.createPacient(in);
        this.pacientList.add(newpacient);
    }

    @Override
    public Pacient get(Scanner in) throws Exception {
        System.out.println(pacientList);
        var pacient = this.getPacientFromInput(in);
        System.out.println(pacient);
        return pacient;
    }

    public Pacient getPacientByCNP(Scanner in) throws Exception {
        if(this.pacientList.size()==0)
            throw new Exception("Nu exista pacienti momentan!");

        return pacientList.stream().filter(p->in.nextLine().equals(p.getCNP())).findAny().orElse(null);
    }

    private Pacient getPacientFromInput(Scanner in) throws Exception {
        if (this.pacientList.size() == 0)
            throw new Exception("Nu exista pacienti momentan!");

        //return pacientList.stream().filter(p->in.nextLine().equals(p.getNume())).findAny().orElse(null);
        String nume = in.nextLine();
        for (Pacient pacient : pacientList) {
            if (pacient.getNume().equals(nume))
                return pacient;
        }
        return null;
    }

    @Override
    public void update(Pacient entity) {

    }

    @Override
    public void delete(Pacient pacient) {
        this.pacientList.remove(pacient);
    }


    public List<Pacient> getPacientList() {
        return pacientList;
    }

    public void setPacientList(List<Pacient> pacientList) {
        this.pacientList = pacientList;
    }
}
