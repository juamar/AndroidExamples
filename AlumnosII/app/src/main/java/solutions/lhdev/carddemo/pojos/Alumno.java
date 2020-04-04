package solutions.lhdev.carddemo.pojos;

/**
 * Created by JuanIgnacio on 19/03/2018.
 */

public class Alumno {

    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private int imagePerfilId;

    public Alumno(int id, String nombres, String apellidos, String correo, int imageId) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        imagePerfilId = imageId;
    }

    public Alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagePerfilId() {
        return imagePerfilId;
    }

    public void setImagePerfilId(int imageId) {
        this.imagePerfilId = imageId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
