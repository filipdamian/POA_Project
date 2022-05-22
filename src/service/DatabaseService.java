package service;

import domain.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseService implements IPacientService,IDoctorService,IProgramareService,ICardSanatateService{
    PacientService pacientService;
    DoctorService doctorService;
    CardSanatateService cardSanatateService;
    ProgramareService programareService;

    private final DoctorFactory doctorFactory=new DoctorFactory();
    private final PacientFactory pacientFactory=new PacientFactory();
    private final CardSanatateFactory cardSanatateFactory=new CardSanatateFactory();
    private final ProgramareFactory programareFactory=new ProgramareFactory();

    private List<Pacient> pacientList= new ArrayList<>();
    private List<Doctor> doctorList=new ArrayList<>();
    private List<Programare> programareList=new ArrayList<>();
    private List<CardSanatate> cardSanatateList= new ArrayList<>();

    private PacientDatabase pacientDatabase=null;
    private DoctorDatabase doctorDatabase=null;
    private CardSanatateDatabase cardSanatateDatabase=null;
    private ProgramareDatabase programareDatabase=null;


    public DatabaseService(PacientDatabase pacientDatabase, DoctorDatabase doctorDatabase, ProgramareDatabase programareDatabase,CardSanatateDatabase cardSanatateDatabase)
    {
        this.pacientDatabase=pacientDatabase;
        this.doctorDatabase=doctorDatabase;
        this.programareDatabase=programareDatabase;
        this.cardSanatateDatabase=cardSanatateDatabase;

        //this.pacientList=pacientDatabase.read();
        //this.doctorList=doctorDatabase.read();


    }

    @Override
    public void setPacients(List<Pacient> pacients) {
        pacientService.setPacients(pacients);
    }

    @Override
    public void registerNewPacient(Scanner in) throws ParseException {
        Pacient newPacient=pacientFactory.createPacient(in);
        this.pacientList.add(newPacient);
        if( this.pacientDatabase!=null)
            this.pacientDatabase.create(newPacient);
        System.out.println("Pacient created");
    }

    @Override
    public void getPacientByName(Scanner in) throws Exception {
        pacientService.getPacientByName(in);
    }

    @Override
    public List<Pacient> getPacients() {
       return pacientService.getPacients();
    }

    @Override
    public void removePacientByCNP(Scanner in) throws Exception {
        pacientService.removePacientByCNP(in);
    }

    @Override
    public void updatePacientCNP(Scanner in) throws Exception {
        pacientService.updatePacientCNP(in);
    }

    @Override
    public void setDoctors(List<Doctor> doctors) {
        doctorService.setDoctors(doctors);
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @Override
    public void registerNewDoctor(Scanner in) throws Exception {
        Doctor newDoctor=doctorFactory.createDoctor(in);
        this.doctorList.add(newDoctor);
        if( this.doctorDatabase!=null)
            this.doctorDatabase.create(newDoctor);
        System.out.println("Doctor created");
    }

    @Override
    public void getDoctorByName(Scanner in) throws Exception {
        doctorService.getDoctorByName(in);
    }

    @Override
    public void updateDoctorSurgeries(Scanner in) throws Exception {
        doctorService.updateDoctorSurgeries(in);
    }

    @Override
    public void removePacientsFromDoctor(Scanner in) throws Exception {
        doctorService.removePacientsFromDoctor(in);
    }

    @Override
    public void SetDoctorVacation(Scanner in) throws Exception {
        doctorService.SetDoctorVacation(in);
    }

    @Override
    public void registerNewHealthCard(Scanner in) throws Exception {
        CardSanatate newCardSanatate=cardSanatateFactory.createCardSanatate(in);
        this.cardSanatateList.add(newCardSanatate);
        if( this.cardSanatateDatabase!=null)
            this.cardSanatateDatabase.create(newCardSanatate);
        System.out.println("Card created");
    }

    @Override
    public void getListOfHealthCards() {
        cardSanatateService.getListOfHealthCards();
    }

    @Override
    public void setCards(List<CardSanatate> cardSanatates) {
        cardSanatateService.setCards(cardSanatates);
    }

    @Override
    public List<CardSanatate> getCards() {
        return cardSanatateService.getCards();
    }

    @Override
    public void createNewAppointment(Scanner in) throws Exception {
        Programare newProgramare=programareFactory.createProgramare(in);
        this.programareList.add(newProgramare);
        if( this.programareDatabase!=null)
            this.programareDatabase.create(newProgramare);
        System.out.println("Appointment created");
    }

    @Override
    public void getAllAppointments() {
        programareService.getAllAppointments();
    }

    @Override
    public void setProgramari(List<Programare> programares) {
        programareService.setProgramari(programares);
    }

    @Override
    public List<Programare> getProgramari() {
        return programareService.getProgramari();
    }
    //public DatabaseService(){}

}
