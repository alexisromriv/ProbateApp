package app2you.probateapp.entidades;

public class Respuesta {
    private String titulo;
    private String palabraClave;
    private boolean correcta;

    public Respuesta(String titulo, String palabraClave, boolean correcta) {
        this.titulo = titulo;
        this.palabraClave = palabraClave;
        this.correcta = correcta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
}
