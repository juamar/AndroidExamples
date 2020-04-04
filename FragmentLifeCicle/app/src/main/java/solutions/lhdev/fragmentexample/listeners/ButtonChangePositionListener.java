package solutions.lhdev.fragmentexample.listeners;

import android.app.Activity;
import android.view.View;
import android.widget.SeekBar;

import solutions.lhdev.fragmentexample.PositionFragment;

/**
 * Created by JuanIgnacio on 11/03/2018.
 */

public class ButtonChangePositionListener implements View.OnClickListener {

    private PositionFragment fragment;

    public ButtonChangePositionListener(PositionFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onClick(View v) {
        int x = fragment.getSeekBarXProgress();
        int y = fragment.getSeekBarYProgress();
        fragment.getActivityCallback().onChangePositionClick(x, y);
    }
}
