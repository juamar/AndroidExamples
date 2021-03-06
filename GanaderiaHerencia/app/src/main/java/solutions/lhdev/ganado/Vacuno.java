package solutions.lhdev.ganado;

import solutions.lhdev.webServer.WebServer;

/**
 * Created by JuanIgnacio on 14/02/2018.
 */

public class Vacuno extends Ganado
{

    public Vacuno(int id, float peso, String raza) {
        super(id, peso, raza);
    }

    @Override
    public float calcularPrecio() {
        WebServer w = new WebServer();
        return super.peso*w.getPrecioKiloVacuno();
    }
}
