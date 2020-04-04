package solutions.lhdev.carddemo.listeners;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import solutions.lhdev.carddemo.CardsHolder;

/**
 * Created by JuanIgnacio on 20/03/2018.
 */

public class CardClickListener implements View.OnClickListener {

    private CardsHolder card;

    public CardClickListener(CardsHolder card) {
        this.card = card;
    }

    @Override
    public void onClick(View v) {
        String title = card.getItemTitle().getText().toString();
        Snackbar.make(v, title, Snackbar.LENGTH_LONG).show();
        /*Toast.makeText(v.getContext(), title, Toast.LENGTH_LONG).show();*/
    }
}
