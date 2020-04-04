package solutions.lhdev.carddemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import solutions.lhdev.carddemo.R;
import solutions.lhdev.carddemo.listeners.CardClickListener;

/**
 * Created by JuanIgnacio on 19/03/2018.
 */

public class CardsHolder extends RecyclerView.ViewHolder
{
    private ImageView itemImage;
    private TextView itemTitle;
    private TextView itemDetail;


    public CardsHolder(View itemView)
    {
        super(itemView);

        itemImage = (ImageView) itemView.findViewById(R.id.item_image);
        itemTitle = (TextView) itemView.findViewById(R.id.item_title);
        itemDetail = (TextView) itemView.findViewById(R.id.item_detail);
        itemView.setOnClickListener(new CardClickListener(this));
    }

    public ImageView getItemImage() {
        return itemImage;
    }

    public void setItemImage(ImageView itemImage) {
        this.itemImage = itemImage;
    }

    public TextView getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(TextView itemTitle) {
        this.itemTitle = itemTitle;
    }

    public TextView getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(TextView itemDetail) {
        this.itemDetail = itemDetail;
    }
}
