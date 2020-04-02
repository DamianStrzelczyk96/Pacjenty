import wyjatki.BankAccount;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static Scanner scanner;
    private static PatientService patientService;
    private static List<Patient> patientList;

    //TODO Dopisać możliwość usunięcia z rejestru pacjenta oraz dodać pole do Pacjenta z ceną wizyty
    public static void main(String[] args) {
        ApachePOIExcelRead apachePOIExcelRead = new ApachePOIExcelRead();
        patientList = apachePOIExcelRead.getPatientList();
        patientService = new PatientService(patientList);
        scanner = new Scanner(System.in);

        int zmienna = 1;
        while (zmienna != 0) {

            System.out.println("Wybierz akcje: \n0 - Zakończ działanie \n1 - Sprawdź czy pacjent jest zarejestrowany \n2 - Zarejestruj pacjenta \n3 - Pokaz liste pacjentow \n4 - Usun pacjenta");
            Integer action = scanner.nextInt();
            zmienna = action;
            chooseTypeSearching(action);


        }
    }

    private static void chooseTypeSearching(Integer typeNumber) {
        switch (typeNumber) {
            case 0:
                break;
            case 1:
                isRegistered();
                break;
            case 2:
                registerPatient();
                System.out.println("Udało się zarejestrować nowego pacjenta");
                System.out.println(patientList);
                break;
            case 3:
                System.out.println(patientList);
            case 4:
                removePatient();
            default:
                break;
        }
    }

    private static void registerPatient() {
        System.out.println("Podaj Imie nowego Pacjenta");
        String name = scanner.next();
        System.out.println("Podaj Nazwisko nowego Pacjenta");
        String surname = scanner.next();
        System.out.println("Podaj pesel nowego Pacjenta");
        BigInteger pesel = scanner.nextBigInteger();
        Patient patient = new Patient(name, surname, new BigInteger(String.valueOf(pesel)));
        patientList.add(patient);
        //TODO dopisać rejestracje pacjenta
    }

    private static void isRegistered() {
        System.out.println("Sprawdź czy pacjent jest zarejestrowany po: \n0 - Zakończ działanie \n1 - imieniu i nazwisku \n2 - numerze PESEL");
        Integer action = scanner.nextInt();
        switch (action) {
            case 0:
                break;
            case 1:
                System.out.println("Podaj imię: ");
                String name = scanner.next();
                System.out.println("Podaj nazwisko: ");
                String surname = scanner.next();
                System.out.println(patientService.isRegistered(name, surname));
                break;
            //TODO W przypadku dopasowań więcej niż 1 rzucić użytkownikowi błąd
            case 2:
                System.out.println("Podaj pesel: ");
                String pesel = scanner.next();
                System.out.println(patientService.isRegistered(new BigInteger(pesel)));
                break;
            default:
                break;
        }
    }


    private static void removePatient() {
        System.out.println("Podaj Imie  Pacjenta");
        String name = scanner.next();
        System.out.println("Podaj Nazwisko  Pacjenta");
        String surname = scanner.next();
        System.out.println("Podaj pesel Pacjenta");
        BigInteger pesel = scanner.nextBigInteger();
        Patient patient = new Patient(name, surname, new BigInteger(String.valueOf(pesel)));
        if (patientList.contains(patient)) {
            patientList.remove(patient);
            System.out.println(patientList);
        } else {
            System.out.println("Brak takiego Pacjenta w bazie");
            System.out.println(patientList);
        }
    }
}