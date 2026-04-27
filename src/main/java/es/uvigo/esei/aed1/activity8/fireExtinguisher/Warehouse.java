package es.uvigo.esei.aed1.activity8.fireExtinguisher;

//Exercise 9
public class Warehouse {

    private FireExtinguisher[] warehouse;

    public Warehouse(int numFireExtinguisher) {
        int maxSize = (numFireExtinguisher * 100) / 90;
        warehouse = new FireExtinguisher[maxSize];

    }

    private int hashFunction(int referenceNumber) {
        return referenceNumber & warehouse.length;
    }

    public boolean insertFireExtinguisher(FireExtinguisher ext) {
        int dirHash = hashFunction(ext.getReferenceNumber());
        if (warehouse[dirHash] == null) {
            warehouse[dirHash] = ext;
        } else {
            int reHash = (dirHash + 1) % warehouse.length;
            while (warehouse[reHash] != null && reHash != dirHash) {
                reHash = (reHash + 1) % warehouse.length;
            }
            if (reHash != dirHash) {
                warehouse[reHash] = ext;
                return true;
            }
        }
        return false;
    }

    public FireExtinguisher searchFireExtinguisher(int referenceNumber) {
        int dirHash = hashFunction(referenceNumber);
        if (warehouse[dirHash] == null) {
            return null;
        } else if (warehouse[dirHash].getReferenceNumber() == referenceNumber) {
            return warehouse[dirHash];
        } else {
            int reHash = (dirHash + 1) % warehouse.length;
            while (warehouse[reHash] != null && warehouse[reHash].getReferenceNumber() != referenceNumber
                    && reHash != dirHash) {
                reHash = (reHash + 1) % warehouse.length;
            }
            if (warehouse[reHash] == null || reHash == dirHash) {
                return null;
            } else {
                return warehouse[reHash];
            }
        }
    }
}
