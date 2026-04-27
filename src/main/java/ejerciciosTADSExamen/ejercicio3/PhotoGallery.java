package ejerciciosTADSExamen.ejercicio3;

public class PhotoGallery {
    private DoubleNode<Photo> currentPhoto;
    private int numPhotos;

    public PhotoGallery() {
        this.currentPhoto = null;
        this.numPhotos = 0;
    }

    // Método a implementar en el Ejercicio 3
    public void deleteCurrentAndMove(boolean forward) throws EmptyGalleryException {
        // TODO: Implementar este método
        // Modifica: this
        // Produce: Elimina la fotografía actual. El nuevo currentPhoto pasará a ser el nodo 
        // siguiente si forward es true, o el anterior si forward es false.
    }

    // Otros métodos de la galería (agregar, etc.) irían aquí
}
