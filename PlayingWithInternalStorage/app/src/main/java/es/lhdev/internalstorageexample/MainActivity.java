package es.lhdev.internalstorageexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.support.design.widget.Snackbar;
import android.widget.Toast;
import org.apache.commons.io.FileUtils;

public class MainActivity extends AppCompatActivity {

    private File tmp;
    private final String cacheDirName = "cache1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCreateFileClick(View v)
    {
        String filename = "pepe";
        File file = new File(getFilesDir(), filename);
        String fileContents = "hola!";

        Toast.makeText(this, "File is at: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        Log.i(this.getClass().getSimpleName(), "File is at: " + file.getAbsolutePath());

        try {
            OutputStream o = openFileOutput(file.getName(), MODE_PRIVATE);
            o.write(fileContents.getBytes());
            o.close();
            Snackbar.make(v, "File written", Snackbar.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onReadingFile(View v)
    {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data;
        int nRead;
        try {
            InputStream i = openFileInput("pepe");
            data = new byte[i.available()];
            //data = new byte[0];
            //Log.i(getClass().getSimpleName(), String.valueOf(i.available()));

            while ((nRead = i.read(data, 0, data.length)) != -1)
            {
                buffer.write(data, 0, nRead);
            }
        } catch (IOException e) {
            data = new byte[0];
            e.printStackTrace();
        }
        Snackbar.make(v,"Su texto es " + new String(data), Snackbar.LENGTH_LONG).show();
    }

    public void onWriteCache(View v)
    {
        String fileName = "pepe";
        String fileContents = "La caché";
        try {
            tmp = File.createTempFile(fileName, null, getCacheDir());

            Toast.makeText(this, "File is at: " + tmp.getAbsolutePath(), Toast.LENGTH_LONG).show();
            Log.i(this.getClass().getSimpleName(), "File is at: " + tmp.getAbsolutePath());

            FileOutputStream o = new FileOutputStream(tmp);
            o.write(fileContents.getBytes());
            o.close();
            Snackbar.make(v, "File written", Snackbar.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onReadCache(View v)
    {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data;
        int nRead;

        try {
            FileInputStream i = new FileInputStream(tmp);
            data = new byte[i.available()];
            //data = new byte[0];
            //Log.i(getClass().getSimpleName(), String.valueOf(i.available()));

            while ((nRead = i.read(data, 0, data.length)) != -1)
            {
                buffer.write(data, 0, nRead);
            }

        } catch (Exception e)
        {
            data = new byte[0];
            e.printStackTrace();
        }

        Snackbar.make(v,"Su texto es " + new String(data), Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(getClass().getSimpleName(), "onStop");
        //tmp.delete();

        FileUtils.deleteQuietly(getCacheDir());
    }

}
