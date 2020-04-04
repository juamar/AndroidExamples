package es.ludus.curso.registrousuario;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import es.ludus.curso.registrousuario.dao.Usuario;

/**
 * Author: Christopher Lincoln Texidor Dantin
 */

public class MainActivity extends AppCompatActivity {


    private EditText etNombre;
    private EditText etApellidos;
    private EditText etCorreo;
    private EditText etUsuario;
    private EditText etContrasena;
    private Button btEnviar;

    private static final String TAG = "RegistroUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        btEnviar = (Button) findViewById(R.id.btEnviar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario(
                        etNombre.getText().toString(),
                        etApellidos.getText().toString(),
                        etCorreo.getText().toString(),
                        etUsuario.getText().toString(),
                        etContrasena.getText().toString()
                );

                mostrarDatos(usuario);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String apellido = etApellidos.getText().toString();
        Log.i(TAG, apellido);
        outState.putString("apellidos", apellido);

        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        etApellidos.setText( (CharSequence) inState.get("apellidos") );

        Log.i(TAG, "onRestoreInstanceState");
    }

    public void mostrarDatos(Usuario usuario) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.t_datos));
        builder.setMessage(usuario.toString());
        builder.setPositiveButton(getString(R.string.t_aceptar), null);
        builder.create();
        builder.show();
    }


}
