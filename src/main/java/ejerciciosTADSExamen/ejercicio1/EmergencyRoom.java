package ejerciciosTADSExamen.ejercicio1;

import java.util.List;

public interface EmergencyRoom {
    public int numPatientsWaiting();
    // Produce: devuelve el número de pacientes actualmente esperando en urgencias.
    
    public void addPatient(Patient p);
    // Modifica: this
    // Produce: añade un nuevo paciente a la sala de espera.

    public boolean assignPatientToBox(int boxNumber);
    // Modifica: this
    // Produce: si no hay pacientes esperando, devuelve falso. Si hay pacientes, toma al paciente con mayor gravedad 
    // (el que tenga menor valor numérico en su nivel de gravedad, y a igualdad de gravedad el que llegó antes) 
    // y lo asigna al box indicado, eliminándolo de la sala de espera y devolviendo true.

    public List<Patient> getPatientsBySeverity(int severityLevel);
    // Produce: devuelve una lista con todos los pacientes en la sala de espera que tengan el nivel de gravedad indicado, manteniendo el orden de llegada.
}
