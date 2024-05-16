package model;

public class Odontologo {

    private Integer id;
    private Integer matricula;
    private String nombre;
    private String apellido;

    public Odontologo(int Matricula, String nombre, String apellido) {
        this.matricula = Matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(int anInt) {
    }

    public Odontologo(Integer id, Integer matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
