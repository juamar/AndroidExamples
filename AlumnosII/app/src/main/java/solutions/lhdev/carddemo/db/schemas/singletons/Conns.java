package solutions.lhdev.carddemo.db.schemas.singletons;

import android.content.Context;

import solutions.lhdev.carddemo.db.schemas.SchoolDbHelper;

public class Conns {
    private static final Conns ourInstance = new Conns();
    private SchoolDbHelper SchoolConn;

    public static Conns getInstance() {
        return ourInstance;
    }

    private Conns() {
    }

    public SchoolDbHelper getSchoolConn(Context c)
    {
        if (SchoolConn == null)
        {
            SchoolConn = new SchoolDbHelper(c);
        }
        return SchoolConn;
    }

    public void setSchoolConn(SchoolDbHelper schoolConn) {
        SchoolConn = schoolConn;
    }
}
