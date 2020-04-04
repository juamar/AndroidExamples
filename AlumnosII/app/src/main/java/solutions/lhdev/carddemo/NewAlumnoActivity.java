package solutions.lhdev.carddemo;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import solutions.lhdev.carddemo.db.schemas.SchoolContract;
import solutions.lhdev.carddemo.db.schemas.singletons.Conns;
import solutions.lhdev.carddemo.providers.AlumnosProvider;
import solutions.lhdev.carddemo.singletons.AppData;

public class NewAlumnoActivity extends AppCompatActivity {

    private EditText eTNombres;
    private EditText eTApellidos;
    private EditText eTCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alumno);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eTNombres = findViewById(R.id.eTNombres);
        eTApellidos = findViewById(R.id.eTApellidos);
        eTCorreo = findViewById(R.id.eTCorreo);
    }

    public void onHandleOk(View v)
    {
        SQLiteDatabase db = Conns.getInstance().getSchoolConn(v.getContext()).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SchoolContract.Alumno.COLUMN_NAME_NOMBRES, eTNombres.getText().toString());
        values.put(SchoolContract.Alumno.COLUMN_NAME_APELLIDOS, eTApellidos.getText().toString());
        values.put(SchoolContract.Alumno.COLUMN_NAME_CORREO, eTCorreo.getText().toString());
        values.put(SchoolContract.Alumno.COLUMN_NAME_IMAGEID, R.drawable.android_image_8);

        /**if (db.insert(SchoolContract.Alumno.TABLE_NAME, null, values) < 1)
        {
            Log.e(getClass().getSimpleName(),"Something went wrong when saving Alumno");
        }**/

        Uri uri = getContentResolver().insert(AlumnosProvider.CONTENT_URI,values);

        int id = Integer.parseInt(uri.getLastPathSegment());
        //Log.d(getClass().getSimpleName(),"Alumno: " + id);
        showNotificationWithTapAction(id);
        //showNotificationWithActionButton(id);

        finish();
    }

    private void showNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, AppData.getInstance(this).getAlumnoChannelId())
                .setSmallIcon(R.drawable.ic_add_white_24dp)
                .setContentTitle(getString(R.string.nuevoAlumnoTitle))
                .setContentText(getString(R.string.newAlumnoAdded))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_REMINDER);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(AppData.getInstance(this).getAlumnoNotificationId(), mBuilder.build());
    }

    private void showNotificationWithTapAction(int id)
    {
        Intent intent = new Intent(this, CardDemoActivity.class);
        intent.putExtra(AppData.getInstance(this).getNewAlumnoKeyForIntent(),id);
        //flag parameter is for configuring this pending intent.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, AppData.getInstance(this).getAlumnoChannelId())
                .setSmallIcon(R.drawable.ic_add_white_24dp)
                .setContentTitle(getString(R.string.nuevoAlumnoTitle))
                .setContentText(getString(R.string.newAlumnoAdded))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(AppData.getInstance(this).getAlumnoNotificationId(), mBuilder.build());
    }

    private void showNotificationWithActionButton(int id)
    {
        Intent intent = new Intent(this, CardDemoActivity.class);
        intent.putExtra(AppData.getInstance(this).getNewAlumnoKeyForIntent(),id);
        //flag parameter is for configuring this pending intent.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, AppData.getInstance(this).getAlumnoChannelId())
                .setSmallIcon(R.drawable.ic_add_white_24dp)
                .setContentTitle(getString(R.string.nuevoAlumnoTitle))
                .setContentText(getString(R.string.newAlumnoAdded))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .addAction(R.drawable.ic_add_white_24dp,"Check",pendingIntent);
        //setAutoCancel(true) is useless here.

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(AppData.getInstance(this).getAlumnoNotificationId(), mBuilder.build());
    }

    @Override
    public void finish()
    {
        setResult(RESULT_OK);
        super.finish();
    }
}
