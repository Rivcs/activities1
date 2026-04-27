package testejerciciosTADSExamen.ejercicio3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ejerciciosTADSExamen.ejercicio3.EmptyGalleryException;
import ejerciciosTADSExamen.ejercicio3.PhotoGallery;

class PhotoGalleryTest {
    private PhotoGallery gallery;

    @BeforeEach
    void setUp() {
        gallery = new PhotoGallery();
    }

    @Test
    void testDeleteEmptyGalleryThrowsException() {
        assertThrows(EmptyGalleryException.class, () -> {
            gallery.deleteCurrentAndMove(true);
        });
    }

    @Test
    void testImplementationReminder() {
        assertTrue(true, "Para hacer pruebas exhaustivas de la galería circular, recuerda implementar en PhotoGallery métodos auxiliares para añadir fotos y poder evaluar el método deleteCurrentAndMove con una estructura con datos reales.");
    }
}
