package es.lhdev.snackbarothers;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button movingToastButton;
    private Button toastViewButton;
    private ProgressBar progressBarH;
    private SeekBar seekBar;
    private SeekBar seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressBarH = findViewById(R.id.progressBarH);

        movingToastButton = findViewById(R.id.movingToastButton);
        movingToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(v.getContext(),"Toast movida!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.BOTTOM,0,500);
                t.show();
                progressBarH.incrementProgressBy(1);
            }
        });

        toastViewButton = findViewById(R.id.toastViewButton);
        toastViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                View layout = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("This is a custom toast");

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                progressBarH.incrementProgressBy(1);
            }
        });

        Snackbar.make(findViewById(R.id.container1), "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        progressBarH.incrementProgressBy(1);
                    }
                }).show();

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(getClass().getSimpleName() + "-OnProgressChanged",String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(getClass().getSimpleName() + "-OnStartTrackingTouch",String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i(getClass().getSimpleName() + "-OnStopTrackingTouch",String.valueOf(seekBar.getProgress()));
                progressBarH.incrementProgressBy(1);
            }
        });

        seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                progressBarH.incrementProgressBy(1);
            }
        });
    }
}
