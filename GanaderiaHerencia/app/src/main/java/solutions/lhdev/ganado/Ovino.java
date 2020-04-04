package solutions.lhdev.ganado;

import solutions.lhdev.webServer.WebServer;

/**
 * Created by JuanIgnacio on 14/02/2018.
 */

public class Ovino extends Ganado
{
    private float lanaje;

    public Ovino(int id, float peso, String raza) {
        super(id, peso, raza);
    }

    public Ovino(int id, float peso, String raza, float lanaje) {
        super(id, peso, raza);
        this.lanaje = lanaje;
    }

    @Override
    public float calcularPrecio() {
        WebServer w = new WebServer();
        return lanaje*w.getPrecioLana();
    }

    @Override
    public String toString()
    {
        return "id: " + id + " peso: "+ peso + " raza: " + raza + " lanaje: " + lanaje + " precio: " + calcularPrecio();
    }
}
