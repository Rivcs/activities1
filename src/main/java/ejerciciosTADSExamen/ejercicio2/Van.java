package ejerciciosTADSExamen.ejercicio2;

import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;

public class Van {
    private String driverName;
    private Stack<Package> packages;

    public Van(String driverName) {
        this.driverName = driverName;
        this.packages = new LinkedStack<>();
    }

    public String getDriverName() {
        return driverName;
    }

    public Stack<Package> getPackages() {
        return packages;
    }
}
