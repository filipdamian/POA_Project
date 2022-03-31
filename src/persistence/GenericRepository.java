package persistence;

import domain.Pacient;

import java.text.ParseException;
import java.util.Scanner;

public interface GenericRepository<T> {
    public void add(Scanner in) throws Exception;

    public T get(Scanner in) throws Exception;

    public void update(T entity);

    public void delete(T entity);

}
