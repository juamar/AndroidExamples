package solutions.lhdev.fragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import solutions.lhdev.fragmentexample.listeners.ButtonChangePositionListener;
import solutions.lhdev.fragmentexample.listeners.SeekBarXListener;
import solutions.lhdev.fragmentexample.listeners.SeekBarYListener;

/**
 * Created by JuanIgnacio on 11/03/2018.
 */

public class PositionFragment extends Fragment {

    private final String TAG = "PositionFragment";
    private int seekBarXProgress = 0;
    private int seekBarYProgress = 0;
    private SeekBar seekBarX;
    private SeekBar seekBarY;
    private Button buttonChangePosition;
    private PositionFragment.PositionFragmentListener activityCallback;

    public interface PositionFragmentListener
    {
        public void onChangePositionClick(int x, int y);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try {
            activityCallback = (PositionFragment.PositionFragmentListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + " must implement PositionFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.position_fragment, container, false);

        seekBarX = (SeekBar) view.findViewById(R.id.seekBarX);
        seekBarY = (SeekBar) view.findViewById(R.id.seekBarY);
        buttonChangePosition = (Button) view.findViewById(R.id.buttonChangePostion);

        seekBarX.setOnSeekBarChangeListener(new SeekBarXListener(this));
        seekBarY.setOnSeekBarChangeListener(new SeekBarYListener(this));
        buttonChangePosition.setOnClickListener(new ButtonChangePositionListener(this));

        return view;
    }

    public int getSeekBarXProgress() {
        return seekBarXProgress;
    }

    public void setSeekBarXProgress(int seekBarXProgress) {
        this.seekBarXProgress = seekBarXProgress;
    }

    public int getSeekBarYProgress() {
        return seekBarYProgress;
    }

    public void setSeekBarYProgress(int seekBarYProgress) {
        this.seekBarYProgress = seekBarYProgress;
    }

    public PositionFragmentListener getActivityCallback() {
        return activityCallback;
    }
}
