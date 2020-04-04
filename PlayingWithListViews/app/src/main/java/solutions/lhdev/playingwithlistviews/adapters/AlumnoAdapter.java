package solutions.lhdev.playingwithlistviews.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Button;

import java.util.List;

import solutions.lhdev.playingwithlistviews.R;
import solutions.lhdev.playingwithlistviews.listeners.OnClickGoAlumnoDetails;
import solutions.lhdev.playingwithlistviews.models.Alumno;

/**
 * Created by JuanIgnacio on 13/03/2018.
 */

public class AlumnoAdapter extends BaseAdapter {

    private List<Alumno> alumnos;
    private Activity activityCallback;

    public AlumnoAdapter(List<Alumno> alumnos, Activity activityCallback) {
        this.alumnos = alumnos;
        this.activityCallback = activityCallback;
    }

    @Override
    public int getCount() {
        return alumnos.size();
    }

    @Override
    public Object getItem(int position) {
        return alumnos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

       //If for making code faster.
       if (convertView == null) {
            convertView = activityCallback.getLayoutInflater().inflate(R.layout.alumno, container, false);
       }

        String text = ((Alumno) getItem(position)).getName() + " " + ((Alumno) getItem(position)).getLastName();
        ((TextView) convertView.findViewById(R.id.nameAndLastName)).setText(text);

        Button buttonGoAlumnoDetails = (Button) convertView.findViewById(R.id.buttonGoAlumnoDetails);
        buttonGoAlumnoDetails.setOnClickListener(new OnClickGoAlumnoDetails((Alumno) getItem(position)));

        return convertView;
    }
}
