package solutions.lhdev.playingwithgradle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();
        printToast();
    }

    public void printToast()
    {
        Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();
    }
}
