package solutions.lhdev.carddemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import solutions.lhdev.carddemo.listeners.AlumnoCardClickListener;
import solutions.lhdev.carddemo.pojos.Alumno;

/**
 * Created by JuanIgnacio on 19/03/2018.
 */

public class AlumnoHolder extends RecyclerView.ViewHolder
{
    private ImageView itemImage;
    private TextView itemTitle;
    private TextView itemDetail;
    private Alumno alumno;
    private AlumnosListFragment.AlumnosListListener activityCallback;

    public AlumnoHolder(View itemView, AlumnosListFragment.AlumnosListListener alumnosListListener)
    {
        super(itemView);

        itemImage = (ImageView) itemView.findViewById(R.id.item_image);
        itemTitle = (TextView) itemView.findViewById(R.id.item_title);
        itemDetail = (TextView) itemView.findViewById(R.id.item_detail);
        this.activityCallback = alumnosListListener;
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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
        itemView.setOnClickListener(new AlumnoCardClickListener(this));
    }

    public AlumnosListFragment.AlumnosListListener getActivityCallback() {
        return activityCallback;
    }

    public void setActivityCallback(AlumnosListFragment.AlumnosListListener activityCallback) {
        this.activityCallback = activityCallback;
    }
}
