package ejerciciosTADSExamen.ejercicio1;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.LinkedList;

public class EmergencyRoomImp implements EmergencyRoom {
    private PriorityQueue<Patient> waitingRoom;
    private Map<Integer, Patient> activeBoxes; // Relaciona número de box con el paciente actual

    public EmergencyRoomImp() {
        this.waitingRoom = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getSeverity(), p2.getSeverity()));
        this.activeBoxes = new HashMap<>();
    }

    @Override
    public int numPatientsWaiting() {
        return waitingRoom.size();
    }

    @Override
    public void addPatient(Patient p) {
        waitingRoom.offer(p);
    }

    @Override
    public boolean assignPatientToBox(int boxNumber) {
        if (activeBoxes.containsKey(boxNumber)) {
            return false; // El box ya está ocupado
        }
        Patient nextPatient = waitingRoom.poll();
        if (nextPatient != null) {
            activeBoxes.put(boxNumber, nextPatient);
            return true;
        }
        return false;
    }

    @Override
    public List<Patient> getPatientsBySeverity(int severityLevel) {
        // TODO: Implementar
        List<Patient> patients = new LinkedList<>();
        for (Patient p : waitingRoom) {
            if (p.getSeverity() == severityLevel) {
                patients.add(p);
            }
        }
        return patients;
    }
}
