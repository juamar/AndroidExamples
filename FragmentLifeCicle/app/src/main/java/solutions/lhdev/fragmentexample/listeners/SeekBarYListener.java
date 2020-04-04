package solutions.lhdev.fragmentexample.listeners;

import android.widget.SeekBar;

import solutions.lhdev.fragmentexample.PositionFragment;

/**
 * Created by JuanIgnacio on 11/03/2018.
 */

public class SeekBarYListener implements SeekBar.OnSeekBarChangeListener {

    private PositionFragment fragment;

    public SeekBarYListener(PositionFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        fragment.setSeekBarYProgress(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
