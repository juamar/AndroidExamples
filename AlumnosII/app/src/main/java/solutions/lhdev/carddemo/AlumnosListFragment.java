package solutions.lhdev.carddemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import solutions.lhdev.carddemo.managers.AlumnosManager;
import solutions.lhdev.carddemo.adapters.AlumnoAdapter;
import solutions.lhdev.carddemo.db.schemas.SchoolContract;
import solutions.lhdev.carddemo.pojos.Alumno;
import solutions.lhdev.carddemo.db.schemas.singletons.Conns;

/**
 * Created by JuanIgnacio on 21/03/2018.
 */

public class AlumnosListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private AlumnoAdapter adapter;
    private AlumnosListListener activityCallback;
    private ViewGroup parent;
    private View loader;

    public interface AlumnosListListener
    {
        public void onCardClick(Alumno alumno);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try {
            activityCallback = (AlumnosListListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + " must implement " + AlumnosListListener.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_alumnos_list,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerLayoutManager = new LinearLayoutManager(view.getContext()); //Check that we can use another layout Manager.
        recyclerView.setLayoutManager(recyclerLayoutManager);

        parent = getActivity().findViewById(R.id.rootContainer);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new onLoadingDb().execute();
    }

    private List<Alumno> getAlumnos() {
        SQLiteDatabase db = Conns.getInstance().getSchoolConn(getActivity()).getReadableDatabase();

        Cursor cursor = db.query(
                SchoolContract.Alumno.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null              // The sort order
        );

        List<Alumno> alumnos = new ArrayList<Alumno>();
        while(cursor.moveToNext()) {
            alumnos.add(new Alumno(
                    cursor.getInt(cursor.getColumnIndexOrThrow(SchoolContract.Alumno._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolContract.Alumno.COLUMN_NAME_NOMBRES)),
                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolContract.Alumno.COLUMN_NAME_APELLIDOS)),
                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolContract.Alumno.COLUMN_NAME_CORREO)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(SchoolContract.Alumno.COLUMN_NAME_IMAGEID))
            ));
        }
        cursor.close();

        return alumnos;
    }

    public List<Alumno> makeExample()
    {
        return AlumnosManager.getInstance().getAlumnos();
    }

    public void changeFragment(Alumno alumno){
        activityCallback.onCardClick(alumno);
    }

    private class onLoadingDb extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void...voids) {

            adapter = new AlumnoAdapter(getAlumnos(), activityCallback);

            //You can comment this try catch. This is just to test our AsyncTask.
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recyclerView.setAdapter(adapter);
                }
            });

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loader = getLayoutInflater().inflate(R.layout.layout_loading,null);
            parent.addView(loader,new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            parent.removeView(loader);
        }
    }
}
