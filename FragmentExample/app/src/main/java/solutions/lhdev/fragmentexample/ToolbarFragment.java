package solutions.lhdev.fragmentexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment; //we need this in order to make this fragment compatible with Android 1-3
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Created by JuanIgnacio on 05/03/2018.
 */

public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener {

    private static int seekValue = 10;
    private static EditText editText;
    private final String TAG = "ToolbarFragment";
    private ToolbarListener activityCallback;

    public interface ToolbarListener
    {
        public void onButtonClick(int position, String text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.toolbar_fragment, /*Vista padre*/container, /*Como le pasamos el container, esto debe ir a false*/false);

        editText = (EditText) view.findViewById(R.id.editText1);

        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);

        final Button button = (Button) view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekValue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void buttonClicked (View view) {
        Log.i(TAG, "buttonClicked");
        activityCallback.onButtonClick(seekValue,editText.getText().toString());
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try {
            activityCallback = (ToolbarListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + " must implement ToolbarListener");
        }
    }


}
