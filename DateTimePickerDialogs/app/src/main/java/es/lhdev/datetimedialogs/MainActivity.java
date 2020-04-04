package es.lhdev.datetimedialogs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(), hourOfDay+":"+ minute, Toast.LENGTH_LONG).show();
                showDatePickerDialog();
            }
        }, 13, 20, true);

        timePickerDialog.show();
    }

    public void showDatePickerDialog()
    {
        DatePickerDialog datePickerDialog =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), dayOfMonth+"/"+ (month+1) + "/" + year, Toast.LENGTH_LONG).show();
            }
            //months go from 0 to 11 (like an array, where 0 is january)
        }, 1994, 0, 14);

        datePickerDialog.show();
    }
}
