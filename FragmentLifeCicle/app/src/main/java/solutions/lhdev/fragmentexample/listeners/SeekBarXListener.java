package solutions.lhdev.fragmentexample.listeners;

import android.support.v4.app.Fragment;
import android.widget.SeekBar;

import solutions.lhdev.fragmentexample.PositionFragment;

/**
 * Created by JuanIgnacio on 11/03/2018.
 */

public class SeekBarXListener implements SeekBar.OnSeekBarChangeListener {

    private PositionFragment fragment;

    public SeekBarXListener(PositionFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        fragment.setSeekBarXProgress(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
