package solutions.lhdev.playingwithlistviews.listeners;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import solutions.lhdev.playingwithlistviews.models.Alumno;

/**
 * Created by JuanIgnacio on 13/03/2018.
 */

public class OnClickGoAlumnoDetails implements OnClickListener {

    private Alumno alumno;

    public OnClickGoAlumnoDetails(Alumno item) {
        alumno = item;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), alumno.getName(),Toast.LENGTH_LONG).show();
    }
}
