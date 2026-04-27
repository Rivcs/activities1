package testejerciciosTADSExamen.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ejerciciosTADSExamen.ejercicio2.DeliverySystem;
import ejerciciosTADSExamen.ejercicio2.DeliverySystemImp;
import ejerciciosTADSExamen.ejercicio2.Package;
import ejerciciosTADSExamen.ejercicio2.Van;

class DeliverySystemTest {
    private DeliverySystem deliverySystem;

    @BeforeEach
    void setUp() {
        deliverySystem = new DeliverySystemImp();
    }

    @Test
    void testDeliverPackage() {
        Van van = new Van("Carlos");
        van.getPackages().push(new Package("P1", "Madrid"));
        van.getPackages().push(new Package("P2", "Vigo"));
        deliverySystem.addVan(van);
        
        assertEquals(1, deliverySystem.totalVans());
        assertTrue(deliverySystem.deliverPackage("Carlos")); // Delivers P2
        assertEquals(1, van.getPackages().size());
        assertEquals("P1", van.getPackages().top().getId());
    }

    @Test
    void testRedistributePackages() {
        Van van1 = new Van("Carlos");
        van1.getPackages().push(new Package("P1", "Madrid"));
        van1.getPackages().push(new Package("P2", "Vigo"));
        
        Van van2 = new Van("Ana");
        // van2 is empty
        
        deliverySystem.addVan(van1);
        deliverySystem.addVan(van2);
        
        deliverySystem.redistributePackages();
        
        assertEquals(1, van1.getPackages().size());
        assertEquals(1, van2.getPackages().size());
    }
}
