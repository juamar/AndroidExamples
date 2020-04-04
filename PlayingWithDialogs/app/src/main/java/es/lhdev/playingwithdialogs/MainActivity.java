package es.lhdev.playingwithdialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showSimplestDialog();
    }

    public void showSimplestDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Hola").setPositiveButton("Si?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showOneOptionDialog();
            }
        });

        builder.create().show();
    }

    public void showOneOptionDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Elija un color").setItems(R.array.colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), String.valueOf(which), Toast.LENGTH_LONG).show();
                showOnePersistentOption();
            }
        });

        builder.create().show();
    }

    public void showOnePersistentOption()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the dialog title
        builder.setTitle("Elija un color")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(R.array.colors, option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        option = which;
                    }
                })
                // Set the action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        Toast.makeText(getApplicationContext(), String.valueOf(option), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivityForResult(i,1);
                    }
                })
                .setNeutralButton("Volver", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO: Mirarse que es el parametro which
                        //Aquí no nos sirve para nada (vendrá -1 siempre), pero fijate que es el
                        // mismo Listener aquí que setSingleChoiceItems.
                    }
                });


        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        DialogFragment newFragment = new FireMissilesDialogFragment();
        newFragment.show(getSupportFragmentManager(), "missiles");
    }
}
