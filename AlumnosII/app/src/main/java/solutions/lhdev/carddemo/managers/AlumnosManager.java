package solutions.lhdev.carddemo.managers;

import java.util.ArrayList;

import solutions.lhdev.carddemo.R;
import solutions.lhdev.carddemo.pojos.Alumno;

public class AlumnosManager {
    private static AlumnosManager ourInstance;
    private ArrayList<Alumno> alumnos;

    public static AlumnosManager getInstance()
    {
        if (ourInstance == null)
        {
            ourInstance = new AlumnosManager();
        }
        return ourInstance;
    }

    private AlumnosManager()
    {
        ArrayList<Alumno> l = new ArrayList<>();
        l.add(new Alumno(1,"Juan Ignacio","Avendaño Huergo","juanihu94@gmail.com", R.mipmap.ic_launcher));
        l.add(new Alumno(2,"Dani","Alumno de prueba","dani@ludustic.es",R.drawable.android_image_1));
        l.add(new Alumno(3,"Begoña","Fernández Fernández","bgo@ludustic.es",R.drawable.android_image_2));
        l.add(new Alumno(4,"Andres","Palacio Torrecilla","andpato@ludustic.es",R.drawable.android_image_4));
        l.add(new Alumno(5,"Christopher Lincoln","Texidor Dantin","Christopher@ludustic.es",R.drawable.android_image_5));
        alumnos = l;
    }

    public ArrayList<Alumno> getAlumnos()
    {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    public Alumno getAlumno(int id) throws NullPointerException
    {
        for (Alumno alumno: this.alumnos)
        {
            if (alumno.getId() == id)
            {
                return alumno;
            }
        }
        throw new NullPointerException();
    }

    public void setAlumno(int id, Alumno alumno) throws Exception
    {
        try
        {
            alumnos.set(id - 1, alumno);
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }
}
