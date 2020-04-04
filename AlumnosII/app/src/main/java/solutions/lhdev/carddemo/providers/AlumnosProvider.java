package solutions.lhdev.carddemo.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import solutions.lhdev.carddemo.db.schemas.SchoolContract;
import solutions.lhdev.carddemo.db.schemas.SchoolDbHelper;

public class AlumnosProvider extends ContentProvider
{
    private static final String AUTHORITY = "solutions.lhdev.carddemo.providers";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + SchoolContract.Alumno.TABLE_NAME);
    private static final int ALL_ALUMNOS = 1;
    private static final int ALUMNO_BY_ID = 2;
    private UriMatcher uriMatcher;
    private SchoolDbHelper schoolDbHelper;

    public AlumnosProvider()
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,SchoolContract.Alumno.TABLE_NAME,ALL_ALUMNOS);
        uriMatcher.addURI(AUTHORITY, SchoolContract.Alumno.TABLE_NAME + "/#", ALUMNO_BY_ID);
    }

    @Override
    public boolean onCreate()
    {
        schoolDbHelper = new SchoolDbHelper(getContext());

        return false;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType =  uriMatcher.match(uri);
        SQLiteDatabase db = schoolDbHelper.getWritableDatabase();

        int rowsDeleted = 0;

        switch (uriType)
        {
            case ALL_ALUMNOS:
                rowsDeleted = db.delete(SchoolContract.Alumno.TABLE_NAME, selection, selectionArgs);
                break;
            case ALUMNO_BY_ID:
                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection))
                {
                    rowsDeleted = db.delete(SchoolContract.Alumno.TABLE_NAME,SchoolContract.Alumno._ID + "=" + id, null);
                }
                else
                {
                    rowsDeleted = db.delete(SchoolContract.Alumno.TABLE_NAME, SchoolContract.Alumno._ID + "=" + id + " AND " + selection, selectionArgs);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        int uriType =  uriMatcher.match(uri);

        SQLiteDatabase db = schoolDbHelper.getWritableDatabase();

        long id = 0;

        switch (uriType)
        {
            case ALL_ALUMNOS:
                id = db.insert(SchoolContract.Alumno.TABLE_NAME,null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(SchoolContract.Alumno.TABLE_NAME + "/" + id);
    }



    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder)
    {
        SQLiteQueryBuilder b = new SQLiteQueryBuilder();
        b.setTables(SchoolContract.Alumno.TABLE_NAME);

        int uriType = uriMatcher.match(uri);

        switch (uriType)
        {
            case (ALL_ALUMNOS):
                break;
            case (ALUMNO_BY_ID):
                b.appendWhere(SchoolContract.Alumno._ID + "=" + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown uri: " + uri);
        }

        Cursor cursor = b.query(schoolDbHelper.getReadableDatabase(),projection,selection,selectionArgs,null,null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs)
    {
        int uriType =  uriMatcher.match(uri);
        SQLiteDatabase db = schoolDbHelper.getWritableDatabase();

        int rowsUpdated = 0;

        switch (uriType)
        {
            case ALL_ALUMNOS:
                rowsUpdated = db.update(SchoolContract.Alumno.TABLE_NAME, values, selection, selectionArgs);
                break;
            case ALUMNO_BY_ID:
                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection))
                {
                    rowsUpdated = db.update(SchoolContract.Alumno.TABLE_NAME, values, SchoolContract.Alumno._ID + "=" + id, null);
                }
                else
                {
                    rowsUpdated = db.update(SchoolContract.Alumno.TABLE_NAME, values, SchoolContract.Alumno._ID + "=" + id + " AND " + selection, selectionArgs);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }
}
