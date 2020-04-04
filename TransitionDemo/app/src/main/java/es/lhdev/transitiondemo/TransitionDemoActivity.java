package es.lhdev.transitiondemo;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

public class TransitionDemoActivity extends AppCompatActivity {

    private ConstraintLayout myLayout;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_demo);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        myButton = (Button) findViewById(R.id.myButton);

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleTouch();
                return true;
            }
        });
    }

    public void handleTouch()
    {
        Transition changeBounds = new ChangeBounds();
        changeBounds.setDuration(3000);
        changeBounds.setInterpolator(new BounceInterpolator());
        TransitionManager.beginDelayedTransition(myLayout, changeBounds);

        myButton.setMinimumHeight(500);
        myButton.setMinimumWidth(350);

        ConstraintSet set = new ConstraintSet();

        set.connect(R.id.myButton, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        set.connect(R.id.myButton, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        set.constrainWidth(R.id.myButton, ConstraintSet.WRAP_CONTENT);

        set.applyTo(myLayout);
    }
}
