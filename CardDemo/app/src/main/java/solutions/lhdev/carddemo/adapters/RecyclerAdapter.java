package solutions.lhdev.carddemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import solutions.lhdev.carddemo.CardsHolder;
import solutions.lhdev.carddemo.R;
import solutions.lhdev.carddemo.pojos.Card;

/**
 * Created by JuanIgnacio on 19/03/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private List<Card> cards;

    public RecyclerAdapter(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        CardsHolder viewHolder = new CardsHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Card card = cards.get(position);

        ((CardsHolder) holder).getItemImage().setImageResource(card.getImageId());
        ((CardsHolder) holder).getItemTitle().setText(card.getTitle());
        ((CardsHolder) holder).getItemDetail().setText(card.getDetails());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
