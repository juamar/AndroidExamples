package es.ludus.curso.registrousuario.dao;

/**
 * Author: Christopher Lincoln Texidor Dantin
 */

public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String contrasena;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String correo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario:\n" +
                "\nnombre = '" + nombre + '\'' +
                "\napellido = '" + apellido + '\'' +
                "\ncorreo = '" + correo + '\'' +
                "\nusuario = '" + usuario + '\'' +
                "\ncontrasena = '" + contrasena + '\'';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
