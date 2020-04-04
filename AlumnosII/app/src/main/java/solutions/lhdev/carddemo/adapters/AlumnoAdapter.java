package solutions.lhdev.carddemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import solutions.lhdev.carddemo.AlumnoHolder;
import solutions.lhdev.carddemo.AlumnosListFragment;
import solutions.lhdev.carddemo.R;
import solutions.lhdev.carddemo.pojos.Alumno;

/**
 * Created by JuanIgnacio on 19/03/2018.
 */

public class AlumnoAdapter extends RecyclerView.Adapter {

    private List<Alumno> alumnos;
    private AlumnosListFragment.AlumnosListListener activityCallback;

    public AlumnoAdapter(List<Alumno> alumnos, AlumnosListFragment.AlumnosListListener alumnosListListener) {
        this.alumnos = alumnos;
        this.activityCallback = alumnosListListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        AlumnoHolder viewHolder = new AlumnoHolder(v, activityCallback);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Alumno alumno = alumnos.get(position);

        ((AlumnoHolder) holder).setAlumno(alumno);

        ((AlumnoHolder) holder).getItemImage().setImageResource(alumno.getImagePerfilId());
        ((AlumnoHolder) holder).getItemTitle().setText(alumno.getNombres() + " " + alumno.getApellidos());
        ((AlumnoHolder) holder).getItemDetail().setText(alumno.getCorreo());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }
}
