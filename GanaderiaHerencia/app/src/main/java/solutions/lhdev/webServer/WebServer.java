package solutions.lhdev.webServer;

/**
 * Created by JuanIgnacio on 14/02/2018.
 */

public class WebServer {
    private float precioLana = 0.1f;
    private float precioKiloVacuno = 0.6f;
    private float precioKiloPorcino = 0.4f;

    public float getPrecioLana() {
        return precioLana;
    }

    public void setPrecioLana(float precioLana) {
        this.precioLana = precioLana;
    }

    public float getPrecioKiloVacuno() {
        return precioKiloVacuno;
    }

    public void setPrecioKiloVacuno(float precioKiloVacuno) {
        this.precioKiloVacuno = precioKiloVacuno;
    }

    public float getPrecioKiloPorcino() {
        return precioKiloPorcino;
    }

    public void setPrecioKiloPorcino(float precioKiloPorcino) {
        this.precioKiloPorcino = precioKiloPorcino;
    }
}
