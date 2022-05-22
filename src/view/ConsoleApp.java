package view;

import domain.*;
import service.*;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleApp {
    static List<String> availableCommands = Arrays.asList("inregistreaza_un_pacient", "cauta_pacient_dupa_nume","help","modifica_cnp_pacient","sterge_pacient_dupa_cnp",
            "inregistreaza_un_doctor","cauta_doctor_dupa_nume","adauga_nr_operatii_la_medic_chirurg","pacienti_plecati_de_la_doctorul_nume","pacienti_plecati_de_la_doctorul_nume",
            "adauga_istoric_user","arata_istoric_user","exit");
    private static void printAllCommands(){
        for(int i=0;i<availableCommands.size();++i)
            System.out.println((i+1) + ". " + " (" + availableCommands.get(i) + ")");
    }

    public static Connection getConnection() {
        try{
            String url = "jdbc:mysql://localhost:3306/bdproiectpao";
            String user = "root";
            String password = "parola";

            return DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }




        //etapa2
        public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        AuditService auditService = new AuditService();





        PacientService pacientService = new PacientService();
        DoctorService doctorService = new DoctorService();
        IstoricService istoricService=new IstoricService();
        CardSanatateService cardSanatateService=new CardSanatateService();
        ProgramareService programareService=new ProgramareService();


        PacientSingleton.getSingle_instance().loadFromCSV();
        pacientService.setPacients(PacientSingleton.getSingle_instance().getPacients());


        DoctorSingleton.getSingle_instance().loadFromCSV();
        doctorService.setDoctors(DoctorSingleton.getSingle_instance().getDoctors());

        CardSanatateSingleton.getSingle_instance().loadFromCSV();
        cardSanatateService.setCards(CardSanatateSingleton.getSingle_instance().getCardSanatates());

        ProgramareSingleton.getSingle_instance().loadFromCSV();
        programareService.setProgramari(ProgramareSingleton.getSingle_instance().getProgramares());



        while (!flag){
            System.out.println("Insert command: (help)");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (command) {
                    case "inregistreaza_un_pacient" -> pacientService.registerNewPacient(in);
                    case "cauta_pacient_dupa_nume" ->pacientService.getPacientByName(in);
                    case "modifica_cnp_pacient" ->pacientService.updatePacientCNP(in);
                    case "sterge_pacient_dupa_cnp" ->pacientService.removePacientByCNP(in);
                    case "inregistreaza_un_doctor" ->doctorService.registerNewDoctor(in);
                    case "cauta_doctor_dupa_nume" ->doctorService.getDoctorByName(in);
                    case "adauga_nr_operatii_la_medic_chirurg" ->doctorService.updateDoctorSurgeries(in);
                    case "pacienti_plecati_de_la_doctorul_nume"->doctorService.removePacientsFromDoctor(in);
                    case "setare_concediu_pentru_doctor"->doctorService.SetDoctorVacation(in);
                    case "adauga_istoric_user"->istoricService.registerPacientAffHistory(in);
                    case "arata_istoric_user"->istoricService.getPacientAffHistory();
                    case "inregistreaza_card_nou_sanatate"->cardSanatateService.registerNewHealthCard(in);
                    case "arata_toate_cardurile_de_sanatate"->cardSanatateService.getListOfHealthCards();
                    case "creaza_o_noua_programare"->programareService.createNewAppointment(in);
                    case "arata_toate_programarile"->programareService.getAllAppointments();
                    case "help" -> ConsoleApp.printAllCommands();
                    case "exit" -> flag = true;
                }
                if(availableCommands.contains(command))
                    auditService.logAction(command);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println(pacientService.getPacients());
        PacientSingleton.getSingle_instance().setPacients(pacientService.getPacients());
        PacientSingleton.getSingle_instance().dumpToCSV();


        System.out.println(doctorService.getDoctors());
        DoctorSingleton.getSingle_instance().setDoctors(doctorService.getDoctors());
        DoctorSingleton.getSingle_instance().dumpToCSV();


        System.out.println(cardSanatateService.getCards());
        CardSanatateSingleton.getSingle_instance().setCardSanatates(cardSanatateService.getCards());
        CardSanatateSingleton.getSingle_instance().dumpToCSV();


        System.out.println(programareService.getProgramari());
        ProgramareSingleton.getSingle_instance().setProgramares(programareService.getProgramari());
        ProgramareSingleton.getSingle_instance().dumpToCSV();


    }
















/*
    //etapa 1
  public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        AuditService auditService = new AuditService();


        PacientService pacientService = new PacientService();
        DoctorService doctorService = new DoctorService();
        IstoricService istoricService=new IstoricService();
        CardSanatateService cardSanatateService=new CardSanatateService();
        ProgramareService programareService=new ProgramareService();
        while (!flag){
            System.out.println("Insert command: (help)");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (command) {
                    case "inregistreaza_un_pacient" -> pacientService.registerNewPacient(in);
                    case "cauta_pacient_dupa_nume" ->pacientService.getPacientByName(in);
                    case "modifica_cnp_pacient" ->pacientService.updatePacientCNP(in);
                    case "sterge_pacient_dupa_cnp" ->pacientService.removePacientByCNP(in);
                    case "inregistreaza_un_doctor" ->doctorService.registerNewDoctor(in);
                    case "cauta_doctor_dupa_nume" ->doctorService.getDoctorByName(in);
                    case "adauga_nr_operatii_la_medic_chirurg" ->doctorService.updateDoctorSurgeries(in);
                    case "pacienti_plecati_de_la_doctorul_nume"->doctorService.removePacientsFromDoctor(in);
                    case "setare_concediu_pentru_doctor"->doctorService.SetDoctorVacation(in);
                    case "adauga_istoric_user"->istoricService.registerPacientAffHistory(in);
                    case "arata_istoric_user"->istoricService.getPacientAffHistory();
                    case "inregistreaza_card_nou_sanatate"->cardSanatateService.registerNewHealthCard(in);
                    case "arata_toate_cardurile_de_sanatate"->cardSanatateService.getListOfHealthCards();
                    case "creaza_o_noua_programare"->programareService.createNewAppointment(in);
                    case "arata_toate_programarile"->programareService.getAllAppointments();
                    case "help" -> ConsoleApp.printAllCommands();
                    case "exit" -> flag = true;
                }
                if(availableCommands.contains(command))
                    auditService.logAction(command);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
*/

//    //etapa 3
//    // mai ramane de customizat metodele de create din databaseservice pentru programari si carduri !! + de testat daca functioneaza cu configuratia noua de interfete pe celalalte etape
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        boolean flag = false;
//
//        var connection=ConsoleApp.getConnection();
//
//        var pacientsDatabase=new PacientDatabase(connection);
//        var doctorDatabase=new DoctorDatabase(connection);
//        var programareDatabase=new ProgramareDatabase(connection);
//        var cardDatabase=new CardSanatateDatabase(connection);
//
//        DatabaseService databaseService=new DatabaseService(pacientsDatabase,doctorDatabase,programareDatabase,cardDatabase);
//
//        AuditService auditService = new AuditService();
//
//        while (!flag){
//            System.out.println("Insert command: (help)");
//            String command = in.nextLine().toLowerCase(Locale.ROOT);
//            try{
//                switch (command) {
//                    case "inregistreaza_un_pacient" -> databaseService.registerNewPacient(in);
//                    case "cauta_pacient_dupa_nume" ->databaseService.getPacientByName(in);
//                    case "modifica_cnp_pacient" ->databaseService.updatePacientCNP(in);
//                    case "sterge_pacient_dupa_cnp" ->databaseService.removePacientByCNP(in);
//                    case "inregistreaza_un_doctor" ->databaseService.registerNewDoctor(in);
//                    case "cauta_doctor_dupa_nume" ->databaseService.getDoctorByName(in);
//                    case "adauga_nr_operatii_la_medic_chirurg" ->databaseService.updateDoctorSurgeries(in);
//                    case "pacienti_plecati_de_la_doctorul_nume"->databaseService.removePacientsFromDoctor(in);
//                    case "setare_concediu_pentru_doctor"->databaseService.SetDoctorVacation(in);
////                    case "adauga_istoric_user"->istoricService.registerPacientAffHistory(in);
////                    case "arata_istoric_user"->istoricService.getPacientAffHistory();
//                    case "inregistreaza_card_nou_sanatate"->databaseService.registerNewHealthCard(in);
//                    case "arata_toate_cardurile_de_sanatate"->databaseService.getListOfHealthCards();
//                    case "creaza_o_noua_programare"->databaseService.createNewAppointment(in);
//                    case "arata_toate_programarile"->databaseService.getAllAppointments();
//                    case "help" -> ConsoleApp.printAllCommands();
//                    case "exit" -> flag = true;
//                }
//                if(availableCommands.contains(command))
//                    auditService.logAction(command);
//            }catch (Exception e){
//                System.out.println(e);
//            }
//        }
//        try{
//            assert connection != null;
//            connection.close();
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//    }
}