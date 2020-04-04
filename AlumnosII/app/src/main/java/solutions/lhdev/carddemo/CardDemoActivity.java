package solutions.lhdev.carddemo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import solutions.lhdev.carddemo.db.schemas.SchoolContract;
import solutions.lhdev.carddemo.managers.AlumnosManager;
import solutions.lhdev.carddemo.observers.AlumnosObserver;
import solutions.lhdev.carddemo.pojos.Alumno;
import solutions.lhdev.carddemo.db.schemas.singletons.Conns;
import solutions.lhdev.carddemo.providers.AlumnosProvider;
import solutions.lhdev.carddemo.singletons.AppData;

public class CardDemoActivity extends AppCompatActivity implements
        AlumnosListFragment.AlumnosListListener,
        AlumnoDetailFragment.BackToListListener {

    private AlumnosListFragment listFragment;
    private AlumnoDetailFragment detailFragment;

    // The authority for the sync adapter's content provider
    private static final String AUTHORITY = "solutions.lhdev.carddemo.providers";
    // An account type, in the form of a domain name
    private static final String ACCOUNT_TYPE = "lhdev.solutions";
    // The account name
    private static final String ACCOUNT = "dummyaccount";
    // Instance fields
    private Account mAccount;
    private Intent intent;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(getClass().getSimpleName(), "onNewIntent");

        this.intent = intent;
        processInitIntent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the dummy account
        mAccount = CreateSyncAccount(this);

        AlumnosObserver observer = new AlumnosObserver(mAccount,AUTHORITY);

        getContentResolver().registerContentObserver(AlumnosProvider.CONTENT_URI,true,observer);

        ContentResolver.addPeriodicSync(
                mAccount,
                AUTHORITY,
                Bundle.EMPTY,
                900);

        listFragment = new AlumnosListFragment();
        detailFragment = new AlumnoDetailFragment();

        processInitIntent();
    }

    public Account CreateSyncAccount(Context context)
    {
        // Create the account type and default account
        Account newAccount = new Account(
                ACCOUNT, ACCOUNT_TYPE);
        // Get an instance of the Android account manager
        AccountManager accountManager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);

        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */
        if (!accountManager.addAccountExplicitly(newAccount, null, null))
        {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
            Log.i("createSyncAccount","Account not added");
        }

        ContentResolver.setSyncAutomatically(newAccount,AUTHORITY,true);

        return newAccount;
    }

    public void processInitIntent()
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // ATTENTION: This was auto-generated to handle app links.
        intent = getIntent();
        String appLinkAction = intent.getAction(); //android.intent.action.VIEW or null
        Uri appLinkData = intent.getData();

        int alumnoId = -1;

        if (appLinkAction != null &&
                appLinkAction.equals("android.intent.action.VIEW"))
        {
            try {
                alumnoId = Integer.parseInt(appLinkData.getLastPathSegment());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                Log.d(getClass().getSimpleName(), "Intentamos...");
                alumnoId = intent.getExtras().getInt(AppData.getInstance(this).getNewAlumnoKeyForIntent(), -1);
                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).cancel(AppData.getInstance(this).getAlumnoNotificationId());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        Log.d(getClass().getSimpleName(), "Alumno: " + alumnoId);

        if (alumnoId >= 0)
        {
            try {
                Log.i(this.getClass().getSimpleName(), "alumnoId = " + alumnoId);

                Cursor c = getContentResolver().query(Uri.parse(AlumnosProvider.CONTENT_URI.toString()+"/"+alumnoId),null,null,null,null);

                //How can we refactor this in order to get Alumno in a much cleaner and cool way?
                c.moveToNext();

                int idColumn = c.getColumnIndex(SchoolContract.Alumno._ID);
                int nombresColumn = c.getColumnIndex(SchoolContract.Alumno.COLUMN_NAME_NOMBRES);
                int apellidosColumn = c.getColumnIndex(SchoolContract.Alumno.COLUMN_NAME_APELLIDOS);
                int correoColumn = c.getColumnIndex(SchoolContract.Alumno.COLUMN_NAME_CORREO);
                int imageIdColumn = c.getColumnIndex(SchoolContract.Alumno.COLUMN_NAME_IMAGEID);

                Alumno alumno = new Alumno(c.getInt(idColumn), c.getString(nombresColumn), c.getString(apellidosColumn), c.getString(correoColumn), c.getInt(imageIdColumn));

                c.close();

                detailFragment.setAlumno(alumno);
                fragmentTransaction.add(R.id.container1, detailFragment);
            }
            catch (NullPointerException e)
            {
                Log.e(getClass().getSimpleName(), "Alumno not found...");
            }
        }
        else
        {
            fragmentTransaction.add(R.id.container1, listFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onCardClick(Alumno alumno) {
        changeFragment(alumno);
    }


    public void changeFragment(Alumno alumno)
    {
        detailFragment.setAlumno(alumno);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container1, detailFragment);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void changeFragment()
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container1, listFragment);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onVolverPressed() {
        changeFragment();
    }

    public void onNewClick(View view) {
        Intent i = new Intent(this, NewAlumnoActivity.class);
        startActivityForResult(i,1);
    }

    @Override
    public void finish() {
        Conns.getInstance().getSchoolConn(this).close();
        super.finish();
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1)
        {
            // Pass the settings flags by inserting them in a bundle
            Bundle settingsBundle = new Bundle();
            settingsBundle.putBoolean(
                    ContentResolver.SYNC_EXTRAS_MANUAL, true);
            settingsBundle.putBoolean(
                    ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
            /*
             * Request the sync for the default account, authority, and
             * manual sync settings
             */
            /*ContentResolver.requestSync(mAccount, AUTHORITY, settingsBundle);
            Log.i(this.getClass().getSimpleName(), "Done");
        }
    }*/
}
