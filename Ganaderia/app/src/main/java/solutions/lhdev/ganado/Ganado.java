package solutions.lhdev.ganado;

/**
 * Created by JuanIgnacio on 14/02/2018.
 */

public abstract class Ganado
{
    protected int id;
    protected float peso;
    protected String raza;

    public Ganado(int id, float peso, String raza) {
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

    public abstract float calcularPrecio();
    public String toString()
    {
        return "id: " + id + " peso: "+ peso + " raza: " + raza + " precio: " + calcularPrecio();
    }

}
