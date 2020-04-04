package solutions.lhdev.carddemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import solutions.lhdev.carddemo.listeners.DeletePressedListener;
import solutions.lhdev.carddemo.listeners.VolverPressedListener;
import solutions.lhdev.carddemo.pojos.Alumno;

/**
 * Created by JuanIgnacio on 21/03/2018.
 */

public class AlumnoDetailFragment extends Fragment {

    private TextView textNombres;
    private TextView textApellidos;
    private TextView textCorreo;
    private TextView textId;
    private ImageView imagePerfil;
    private Button buttonVolver;
    private Button buttonDelete;
    private Alumno alumno;
    private BackToListListener activityCallback;

    public interface BackToListListener
    {
        public void onVolverPressed();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            activityCallback = (BackToListListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + " must implement " + BackToListListener.class.getSimpleName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_alumno_detail,container,false);

        textId = (TextView) view.findViewById(R.id.textId);
        textNombres = (TextView) view.findViewById(R.id.textNombres);
        textApellidos = (TextView) view.findViewById(R.id.textApellidos);
        textCorreo = (TextView) view.findViewById(R.id.textCorreo);
        imagePerfil = (ImageView) view.findViewById(R.id.imagePerfil);
        buttonVolver = (Button) view.findViewById(R.id.buttonVolver);
        buttonDelete = view.findViewById(R.id.buttonDelete);

        textId.setText(Integer.toString(alumno.getId()));
        textNombres.setText(alumno.getNombres());
        textApellidos.setText(alumno.getApellidos());
        textCorreo.setText(alumno.getCorreo());
        imagePerfil.setImageResource(alumno.getImagePerfilId());

        buttonVolver.setOnClickListener(new VolverPressedListener(activityCallback));
        buttonDelete.setOnClickListener(new DeletePressedListener(activityCallback, this.alumno));

        return view;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
