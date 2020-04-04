package solutions.lhdev.playingwithlistviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import solutions.lhdev.playingwithlistviews.listeners.ListView1StrListener;
import solutions.lhdev.playingwithlistviews.adapters.AlumnoAdapter;
import solutions.lhdev.playingwithlistviews.models.Alumno;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    private ArrayList<String> alumnosStr;
    private ArrayList<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapter<String> adapter = arrayAdapterExample();
        AlumnoAdapter adapter = alumnoAdapterExample();

        listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        //listView1.setOnItemClickListener(new ListView1StrListener(this));
    }

    public ArrayAdapter<String> arrayAdapterExample()
    {
        alumnosStr = new ArrayList<String>();

        alumnosStr.add("Cristofer");
        alumnosStr.add("Andres" );
        alumnosStr.add("Begoña");

        return new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alumnosStr);
    }

    public AlumnoAdapter alumnoAdapterExample()
    {
        alumnos = new ArrayList<>();

        alumnos.add(new Alumno("Cristofer", "Lincoln", "1"));
        alumnos.add(new Alumno("Andres","Palacio","2" ));
        alumnos.add(new Alumno("Begoña","Fernández","3"));
        alumnos.add(new Alumno("Cristofer", "Lincoln", "1"));
        alumnos.add(new Alumno("Andres","Palacio","2" ));
        alumnos.add(new Alumno("Begoña","Fernández","3"));
        alumnos.add(new Alumno("Cristofer", "Lincoln", "1"));
        alumnos.add(new Alumno("Andres","Palacio","2" ));
        alumnos.add(new Alumno("Begoña","Fernández","3"));
        alumnos.add(new Alumno("Cristofer", "Lincoln", "1"));
        alumnos.add(new Alumno("Andres","Palacio","2" ));
        alumnos.add(new Alumno("Begoña","Fernández","3"));
        alumnos.add(new Alumno("Cristofer", "Lincoln", "1"));
        alumnos.add(new Alumno("Andres","Palacio","2" ));
        alumnos.add(new Alumno("Begoña","Fernández","3"));

        return new AlumnoAdapter(alumnos,this);
    }

    public ArrayList<String> getAlumnosStr() {
        return alumnosStr;
    }

    public void setAlumnosStr(ArrayList<String> alumnosStr) {
        this.alumnosStr = alumnosStr;
    }
}
