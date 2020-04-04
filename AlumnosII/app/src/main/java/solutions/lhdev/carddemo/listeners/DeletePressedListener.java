package solutions.lhdev.carddemo.listeners;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import solutions.lhdev.carddemo.AlumnoDetailFragment;
import solutions.lhdev.carddemo.db.schemas.SchoolContract;
import solutions.lhdev.carddemo.db.schemas.singletons.Conns;
import solutions.lhdev.carddemo.pojos.Alumno;

/**
 * Created by JuanIgnacio on 21/03/2018.
 */

public class DeletePressedListener implements View.OnClickListener {

    private AlumnoDetailFragment.BackToListListener activityCallback;
    private Alumno alumno;

    public DeletePressedListener(AlumnoDetailFragment.BackToListListener backToListListener, Alumno alumno) {
        this.activityCallback = backToListListener;
        this.alumno = alumno;
    }

    @Override
    public void onClick(View v)
    {
        SQLiteDatabase db = Conns.getInstance().getSchoolConn(v.getContext()).getWritableDatabase();

        String selection = SchoolContract.Alumno._ID + " = ?";
        String[] selectionArgs = {String.valueOf(alumno.getId())};

        if (db.delete(SchoolContract.Alumno.TABLE_NAME, selection, selectionArgs) != 1)
        {
            Log.e(getClass().getSimpleName(), "CRITICAL problem deleting ALUMNO");
        }

        activityCallback.onVolverPressed();
    }
}
