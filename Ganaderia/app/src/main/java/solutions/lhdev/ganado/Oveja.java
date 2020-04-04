package solutions.lhdev.ganado;

import solutions.lhdev.webServer.WebServer;

/**
 * Created by JuanIgnacio on 14/02/2018.
 */

public class Oveja extends Ganado implements Ovino
{
    private float lanaje;

    public Oveja(int id, float peso, String raza) {
        super(id, peso, raza);
    }

    public Oveja(int id, float peso, String raza, float lanaje) {
        super(id, peso, raza);
        this.lanaje = lanaje;
    }

    @Override
    public float calcularPrecio()
    {
        WebServer w = new WebServer();
        return peso*w.getPrecioKiloOvino();
    }

    @Override
    public String toString()
    {
        return "id: " + id + " peso: "+ peso + " raza: " + raza + " lanaje: " + lanaje + " precio por carne: " + calcularPrecio() + " Precio por lana: " + calcularPrecioPorLana();
    }

    @Override
    public float calcularPrecioPorLana() {
        WebServer w = new WebServer();
        return lanaje*w.getPrecioLana();
    }
}
