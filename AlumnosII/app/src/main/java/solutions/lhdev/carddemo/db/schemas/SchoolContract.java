package solutions.lhdev.carddemo.db.schemas;

import android.provider.BaseColumns;

public final class SchoolContract {
    
    public static final String SCHEMA = "school.db";

    private SchoolContract() {
    }
    
    public static class Alumno implements BaseColumns
    {
        public static final String TABLE_NAME = "alumno";
        public static final String COLUMN_NAME_NOMBRES = "nombres";
        public static final String COLUMN_NAME_APELLIDOS = "apellidos";
        public static final String COLUMN_NAME_CORREO = "correo";
        public static final String COLUMN_NAME_IMAGEID = "imageId";
        
        static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_NOMBRES + " TEXT," +
                        COLUMN_NAME_APELLIDOS + " TEXT," +
                        COLUMN_NAME_CORREO + " TEXT," +
                        COLUMN_NAME_IMAGEID + " INTEGER)";

        static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
