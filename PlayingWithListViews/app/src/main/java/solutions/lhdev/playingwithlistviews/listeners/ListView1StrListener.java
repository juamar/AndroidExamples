package solutions.lhdev.playingwithlistviews.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import solutions.lhdev.playingwithlistviews.MainActivity;

/**
 * Created by JuanIgnacio on 13/03/2018.
 */

public class ListView1StrListener implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;

    public ListView1StrListener(MainActivity mainActivity )
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(view.getContext(),mainActivity.getAlumnosStr().get(position),Toast.LENGTH_LONG).show();
    }
}
