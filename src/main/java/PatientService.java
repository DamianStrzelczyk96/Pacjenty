import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigInteger;
import java.util.List;
@Data
@AllArgsConstructor
public class PatientService {
    private List<Patient> patientList;
    public boolean isRegistered(BigInteger pesel) {
        boolean        isRegistered = false;
        for (Patient patient : patientList) {
            if (patient.getPesel().equals(pesel)) {
                isRegistered = Boolean.TRUE;
            }
        }
        return isRegistered;
    }
    public boolean isRegistered(String name, String surname) {
        boolean isRegistered = false;
        int licznik = 0;
        for (Patient patient : patientList) {
            if (patient.getName().equals(name) && patient.getSurname().equals(surname)) {
                isRegistered = Boolean.TRUE;
                licznik ++;
            }

        }
        if(licznik>1) {
           System.out.println(" W bazie jest wiecej niz jeden pacjent o takim imieniu i nazwisku");
        }
        return isRegistered;
    }
}