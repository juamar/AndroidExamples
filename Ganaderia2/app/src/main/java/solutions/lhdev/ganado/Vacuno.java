package solutions.lhdev.ganado;

import solutions.lhdev.webServer.WebServer;

/**
 * Created by JuanIgnacio on 14/02/2018.
 */

public class Vacuno implements Ganado
{

    private int id;
    private float peso;
    private String raza;

    public Vacuno(int id, float peso, String raza) {
        this.id = id;
        this.peso = peso;
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String toString()
    {
        return "id: " + id + " peso: "+ peso + " raza: " + raza + " precio: " + calcularPrecio();
    }

    @Override
    public float calcularPrecio() {
        WebServer w = new WebServer();
        return peso*w.getPrecioKiloVacuno();
    }
}
