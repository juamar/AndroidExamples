package es.lhdev.trainingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import es.lhdev.trainingapp.views.DurationTextView;

public class MainActivity extends AppCompatActivity {

    private DurationTextView duration1;
    private DurationTextView duration2;
    private DurationTextView duration3;
    private DurationTextView duration4;
    private DurationTextView duration5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        duration1 = (DurationTextView) findViewById(R.id.duration1);
        duration1.setDuration(25);

        duration2 = (DurationTextView) findViewById(R.id.duration2);
        duration2.setDuration(78);

        duration3 = (DurationTextView) findViewById(R.id.duration3);
        duration3.setDuration(2378);

        duration4 = (DurationTextView) findViewById(R.id.duration4);
        duration4.setDuration(3670);

        duration5 = (DurationTextView) findViewById(R.id.duration5);
        duration5.setDuration(18550);
    }
}
