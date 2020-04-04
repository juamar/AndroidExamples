package es.lhdev.trainingapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import es.lhdev.trainingapp.R;

public class DurationTextView extends AppCompatTextView {

    private String template = "Duration: %s";

    public DurationTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //Get Attributes Array from our DurationTextView (mainly one at the moment)
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.DurationTextView);
        //Now we get the text for our template.
        String templateAux = attributes.getString(R.styleable.DurationTextView_template);

        /**
         * Template shall have %s in order to complete correctly with String.format
         */
        try
        {
            if(templateAux.contains("%s"))
            {
                template = templateAux;
            }
            else
            {
                Log.i(this.getClass().getSimpleName(),"No %s set. Add it in template");
            }
        }
        catch (NullPointerException e)
        {
            Log.i(this.getClass().getSimpleName(),"No template set. Using default.");
        }
        /**
         *  We let go our resources involved in this variable.
         *  Please, do not call attributes variable again!
         */
        attributes.recycle();
    }

    /**
     * Updates the text of the view with the new duration, properly
     * formatted
     *
     * @param duration: The duration in seconds
     */
    public void setDuration(float duration) {
        int durationInMinutes = Math.round(duration / 60);
        int hours = durationInMinutes / 60;
        int minutes = durationInMinutes % 60;

        String hourText = "";
        String minuteText = "";

        if (hours > 0) {
            hourText = hours + (hours == 1 ? " hour " : " hours ");
        }
        if (minutes > 0) {
            minuteText = minutes + (minutes == 1 ? " minute" : " minutes");
        }
        if (hours == 0 && minutes == 0) {
            minuteText = "less than 1 minute";
        }

        String durationText = String.format(template, hourText + minuteText);
        setText(durationText);
    }
}
