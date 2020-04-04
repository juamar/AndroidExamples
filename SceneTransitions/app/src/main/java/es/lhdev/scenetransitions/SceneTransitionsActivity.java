package es.lhdev.scenetransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class SceneTransitionsActivity extends AppCompatActivity {

    private ViewGroup rootContainer;
    private Scene scene1;
    private Scene scene2;
    private Transition transition1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transitions);

        rootContainer = (ViewGroup) findViewById(R.id.rootContainer);
        scene1 = Scene.getSceneForLayout(rootContainer, R.layout.scene1_layout, this);
        scene2 = Scene.getSceneForLayout(rootContainer, R.layout.scene2_layout, this);
        transition1 = TransitionInflater.from(this).inflateTransition(R.transition.transition); //We call the inflater and then we inflate the Transition instance.

        scene1.enter();
    }

    public void goToScene1(View view)
    {
        TransitionManager.go(scene1, transition1);
    }

    public void goToScene2(View view)
    {
        TransitionManager.go(scene2, transition1);
    }
}
