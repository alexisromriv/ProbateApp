package app2you.probateapp.entidades;

public class Materias {    private String textMateria;
    private String textGrado;

    public String getTextMateria() {
        return textMateria;
    }

    public void setTextMateria(String textMateria) {
        this.textMateria = textMateria;
    }

    public String getTextGrado() {
        return textGrado;
    }

    public void setTextGrado(String textGrado) {
        this.textGrado = textGrado;
    }

    public Materias(String textMateria, String textGrado) {
        this.textMateria = textMateria;
        this.textGrado = textGrado;
    }
}
