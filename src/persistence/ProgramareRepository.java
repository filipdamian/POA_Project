package persistence;

import domain.Programare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramareRepository implements GenericRepository<Programare> {
    private List<Programare> programareList=new ArrayList<>();
    @Override
    public void add(Scanner in) throws Exception {
        Programare programare=new Programare(in);
        programareList.add(programare);
    }

    public List<Programare> getList(){
        System.out.println(programareList);
        return programareList;
    }
    @Override
    public Programare get(Scanner in) throws Exception {
        return null;
    }

    @Override
    public void update(Programare entity) {

    }

    @Override
    public void delete(Programare entity) {

    }
}
