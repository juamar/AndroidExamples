package solutions.lhdev.carddemo.db.schemas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import solutions.lhdev.carddemo.R;

public class SchoolDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public SchoolDbHelper(Context context) {
        super(context, SchoolContract.SCHEMA, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SchoolContract.Alumno.SQL_CREATE_ENTRIES);
        insertAlumno("Juan Ignacio","Avendaño Huergo","juanihu94@gmail.com", R.mipmap.ic_launcher, db);
        insertAlumno("Dani","Alumno de prueba","dani@ludustic.es",R.drawable.android_image_1, db);
        insertAlumno("Begoña","Fernández Fernández","bgo@ludustic.es",R.drawable.android_image_2, db);
        insertAlumno("Andres","Palacio Torrecilla","andpato@ludustic.es",R.drawable.android_image_4, db);
        insertAlumno("Christopher Lincoln","Texidor Dantin","Christopher@ludustic.es",R.drawable.android_image_5, db);

    }

    //ToDo: throw exception
    private void insertAlumno(String nombres, String apellidos, String correo, int imageId, SQLiteDatabase db)
    {
        ContentValues values = new ContentValues();
        values.put(SchoolContract.Alumno.COLUMN_NAME_NOMBRES, nombres);
        values.put(SchoolContract.Alumno.COLUMN_NAME_APELLIDOS, apellidos);
        values.put(SchoolContract.Alumno.COLUMN_NAME_CORREO, correo);
        values.put(SchoolContract.Alumno.COLUMN_NAME_IMAGEID, imageId);

        // Insert the new row, returning the primary key value of the new row
        if (db.insert(SchoolContract.Alumno.TABLE_NAME, null, values) < 1)
        {
            Log.e(this.getClass().getSimpleName(), "Watch out! Alumno with email " + correo + " not inserted while creating DB");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SchoolContract.Alumno.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
