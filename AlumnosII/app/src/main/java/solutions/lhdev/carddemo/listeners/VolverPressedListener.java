package solutions.lhdev.carddemo.listeners;

import android.view.View;

import solutions.lhdev.carddemo.AlumnoDetailFragment;
import solutions.lhdev.carddemo.pojos.Alumno;

/**
 * Created by JuanIgnacio on 21/03/2018.
 */

public class VolverPressedListener implements View.OnClickListener {

    private AlumnoDetailFragment.BackToListListener activityCallback;

    public VolverPressedListener(AlumnoDetailFragment.BackToListListener backToListListener) {
        this.activityCallback = backToListListener;
    }

    @Override
    public void onClick(View v) {
        activityCallback.onVolverPressed();
    }
}
