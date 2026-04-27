package ejerciciosTADSExamen.ejercicio1;

public class Patient {
    private String name;
    private int severity; // 1 (más grave) a 5 (menos grave)

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int getSeverity() {
        return this.severity;
    }

    public String getName() {
        return this.name;
    }
}
