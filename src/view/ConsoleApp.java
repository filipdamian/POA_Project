package view;

import service.*;

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

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean flag = false;
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
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
