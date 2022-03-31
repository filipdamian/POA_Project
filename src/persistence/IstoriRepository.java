package persistence;


import domain.Istoric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IstoriRepository implements GenericRepository<Istoric>{
    private List<Istoric> IstoricList= new ArrayList<>();

    @Override
    public void add(Scanner in) throws Exception {
        Istoric istoric= new Istoric(in);
        IstoricList.add(istoric);
    }

    public List<Istoric> getList(){
        System.out.println(IstoricList);
        return IstoricList;
    }

    @Override
    public Istoric get(Scanner in) throws Exception {
        return null;
    }

    @Override
    public void update(Istoric entity) {

    }

    @Override
    public void delete(Istoric entity) {

    }
}
