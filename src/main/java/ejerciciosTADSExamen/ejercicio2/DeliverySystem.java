package ejerciciosTADSExamen.ejercicio2;

public interface DeliverySystem {
    public int totalVans();
    // Produce: devuelve el número de furgonetas en el sistema.

    public void addVan(Van van);
    // Modifica: this
    // Produce: añade una furgoneta a la lista de repartos.

    public boolean deliverPackage(String driverName);
    // Modifica: this
    // Produce: busca la furgoneta conducida por driverName. Si no existe o su pila de paquetes está vacía, devuelve falso. 
    // En caso contrario, saca un paquete de la pila (lo entrega) y devuelve verdadero.

    public void redistributePackages();
    // Modifica: this
    // Produce: busca si alguna furgoneta tiene su pila de paquetes vacía. Si es así, toma un paquete de la furgoneta que tenga 
    // la mayor cantidad de paquetes en su pila y se lo asigna a la furgoneta vacía. Este proceso se repite mientras haya furgonetas vacías 
    // y furgonetas con más de 1 paquete.
}
