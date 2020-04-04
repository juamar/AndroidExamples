package es.lhdev.contentresolvers;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        Cursor alumnoCursor = getContentResolver().query(Uri.parse("content://solutions.lhdev.carddemo.providers/alumno/1"), null, null, null, null);

        System.out.println(new ArrayList<String>(Arrays.asList(alumnoCursor.getColumnNames())).toString());

        if (alumnoCursor.getColumnCount() > 0)
        {
            alumnoCursor.moveToNext();
            text.setText(alumnoCursor.getString(alumnoCursor.getColumnIndex("nombres")));
        }
        alumnoCursor.close();
    }

    public void getContact(View v)
    {
        String[] projection =
        {
            ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.LOOKUP_KEY,
                    Build.VERSION.SDK_INT
                            >= Build.VERSION_CODES.HONEYCOMB ?
                            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY :
                            ContactsContract.Contacts.DISPLAY_NAME
        };

        if (arePermitionsOk()) {
            Cursor contactCursor = this.getContentResolver().query(
                    ContactsContract.Contacts.CONTENT_URI,
                    projection,
                    null,
                    null,
                    null
            );

            if (contactCursor.getColumnCount() > 0)
            {
                contactCursor.moveToNext();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                {
                    text.setText(contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)));
                }
                else
                {
                    text.setText(contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                }
                contactCursor.close();
            }
        }
    }

    public boolean arePermitionsOk()
    {
        if (Build.VERSION.SDK_INT >= 23 &&
                checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED)
        {

            Log.d("permission", "permission denied to Read Contacts - requesting it");
            String[] permissions = {Manifest.permission.READ_CONTACTS};

            requestPermissions(permissions, 1);

            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Snackbar.make(findViewById(R.id.rootContainer), R.string.try_again, Snackbar.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, R.string.readContactsDenied, Toast.LENGTH_LONG).show();
                    finish();
                }
                return;
            }
            default:
            {

            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
