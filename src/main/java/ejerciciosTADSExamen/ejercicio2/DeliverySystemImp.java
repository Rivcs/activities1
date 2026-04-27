package ejerciciosTADSExamen.ejercicio2;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

public class DeliverySystemImp implements DeliverySystem {
    private List<Van> fleet;

    public DeliverySystemImp() {
        this.fleet = new LinkedList<>();
    }

    @Override
    public int totalVans() {
        return fleet.size();
    }

    @Override
    public void addVan(Van van) {
        fleet.addLast(van);
    }

    @Override
    public boolean deliverPackage(String driverName) {
        for (Van van : fleet) {
            if (van.getDriverName().equals(driverName)) {
                if (van.getPackages().isEmpty()) {
                    return false;
                } else {
                    van.getPackages().pop();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void redistributePackages() {
        if (fleet.isEmpty()) {
            return;
        }

        while (true) {
            Van emptyVan = null;
            Van filledVan = null;
            int highPackages = -1;

            for (Van van : fleet) {
                int currentPackages = van.getPackages().size();

                if (emptyVan == null && currentPackages == 0) {
                    emptyVan = van;
                }

                if (currentPackages > highPackages) {
                    highPackages = currentPackages;
                    filledVan = van;
                }
            }

            if (emptyVan == null || filledVan == null || highPackages <= 1) {
                return;
            }
            emptyVan.getPackages().push(filledVan.getPackages().pop());
        }
    }
}
