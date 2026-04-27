package ejerciciosTADSExamen.ejercicio3;

public class Photo {
    private String filename;
    private String date;

    public Photo(String filename, String date) {
        this.filename = filename;
        this.date = date;
    }

    public String getFilename() {
        return filename;
    }

    public String getDate() {
        return date;
    }
}
