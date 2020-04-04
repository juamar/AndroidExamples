package solutions.lhdev.ganaderia2;

import android.app.Activity;
import android.os.Bundle;

import java.util.Vector;

import solutions.lhdev.ganado.Ganado;
import solutions.lhdev.ganado.Oveja;
import solutions.lhdev.ganado.Porcino;
import solutions.lhdev.ganado.Vacuno;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vector<Ganado> listado = new Vector<Ganado>();

        Vacuno v1 = new Vacuno(1,200f,"Angus");
        Vacuno v2 = new Vacuno(2,250f,"Heresford");
        Oveja o1 = new Oveja(3,50f,"Oveja Guay",200f);
        Porcino p1 = new Porcino(4, 70f, "Jamón Serrano");

        listado.add(v1);
        listado.add(v2);
        listado.add(o1);
        listado.add(p1);

        listarGanado(listado);

    }

    public void listarGanado(Vector<Ganado> g)
    {
        for (Ganado bicho: g)
        {
            System.out.println(bicho.toString());
        }
    }
}
