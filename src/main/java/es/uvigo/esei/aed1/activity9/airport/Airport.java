package es.uvigo.esei.aed1.activity9.airport;

public class Airport {

    private Runway[] runways;

    public Airport(int numRunways) {
        runways = new Runway[numRunways];
        for (int i = 0; i < numRunways; i++) {
            runways[i] = new Runway(i);
        }
    }

    public void assignDestinationRunway(int numRunway, String destination) {
        runways[numRunway].assignDestination(destination);
    }

    public void assignFlightRunway(Flight v) {
        int menorVuelos = Integer.MAX_VALUE;
        Runway runwayMinor = null;
        for (Runway i : runways) {
            if (i.isDestination(v.getDestination()) && i.numberFlight() < menorVuelos) {
                runwayMinor = i;
                menorVuelos = i.numberFlight();
            }
        }
        runwayMinor.assignFlight(v);
    }

    public Flight takeoffFlight(int numRunway) {
        return runways[numRunway].removeFlight();
    }

    public int getNumRunways() {
        return runways.length;
    }

    public int getNumAssignedFlights() {
        int numVuelos = 0;
        for (Runway i : runways) {
            numVuelos += i.numberFlight();
        }
        return numVuelos;
    }
}
