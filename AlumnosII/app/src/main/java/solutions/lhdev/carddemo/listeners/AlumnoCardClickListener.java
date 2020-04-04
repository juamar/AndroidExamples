package solutions.lhdev.carddemo.listeners;

import android.view.View;

import solutions.lhdev.carddemo.AlumnoHolder;
import solutions.lhdev.carddemo.AlumnosListFragment;
import solutions.lhdev.carddemo.pojos.Alumno;

/**
 * Created by JuanIgnacio on 20/03/2018.
 */

public class AlumnoCardClickListener implements View.OnClickListener {

    private AlumnoHolder alumnoHolder;

    public AlumnoCardClickListener(AlumnoHolder alumnoHolder) {
        this.alumnoHolder = alumnoHolder;
    }

    @Override
    public void onClick(View v) {
        Alumno alumno = alumnoHolder.getAlumno();
        alumnoHolder.getActivityCallback().onCardClick(alumno);
    }
}
