package testejerciciosTADSExamen.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import ejerciciosTADSExamen.ejercicio1.EmergencyRoom;
import ejerciciosTADSExamen.ejercicio1.EmergencyRoomImp;
import ejerciciosTADSExamen.ejercicio1.Patient;

class EmergencyRoomTest {
    private EmergencyRoom emergencyRoom;

    @BeforeEach
    void setUp() {
        emergencyRoom = new EmergencyRoomImp();
    }

    @Test
    void testAddAndCountPatients() {
        assertEquals(0, emergencyRoom.numPatientsWaiting());
        emergencyRoom.addPatient(new Patient("Juan", 3));
        emergencyRoom.addPatient(new Patient("Maria", 1));
        assertEquals(2, emergencyRoom.numPatientsWaiting());
    }

    @Test
    void testAssignPatientToBox() {
        emergencyRoom.addPatient(new Patient("Juan", 3));
        emergencyRoom.addPatient(new Patient("Maria", 1));
        
        boolean assigned = emergencyRoom.assignPatientToBox(1);
        assertTrue(assigned);
        assertEquals(1, emergencyRoom.numPatientsWaiting());
        
        // María should have been assigned because of higher severity (1 < 3).
        // Let's verify Juan is still waiting
        List<Patient> remaining = emergencyRoom.getPatientsBySeverity(3);
        assertEquals(1, remaining.size());
        assertEquals("Juan", remaining.get(0).getName());
    }
}
