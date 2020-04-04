package solutions.lhdev.fragmentexample;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import solutions.lhdev.fragmentexample.builders.ConstraintSetBuilder;
import solutions.lhdev.fragmentexample.builders.ParamBuilder;

public class FragmentExampleActivity
        extends FragmentActivity
        implements
            ToolbarFragment.ToolbarListener,
            PositionFragment.PositionFragmentListener
{

    private ConstraintLayout constraintLayout;
    private ToolbarFragment toolbarFragment;
    private PositionFragment positionFragment;
    private final String TAG = "FragmentExampleActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        //textFragment.setArguments(getIntent().getExtras());

        toolbarFragment = new ToolbarFragment();
        positionFragment = new PositionFragment();
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout1);

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();

        transaction.add(constraintLayout.getId(), toolbarFragment);

        //transaction.remove(textFragment);

        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();

        ConstraintSet constraintSet = new ConstraintSet();
        setToolbar(constraintSet, toolbarFragment.getView());

    }

    public void setToolbar(ConstraintSet constraintSet, View view)
    {
        constraintSet = ConstraintSetBuilder.buildConstraintSet(this, constraintLayout, constraintSet, view);

        constraintSet.applyTo(constraintLayout);

        ConstraintLayout.LayoutParams params = ParamBuilder.buildParams(this);
        view.setLayoutParams(params);
    }

    public void changeToolbar(View view)
    {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();

        if (fragManager.getFragments().get(0).getClass().getSimpleName().equals("PositionFragment"))
            transaction.replace(R.id.constraintLayout1, toolbarFragment);
        else
            transaction.replace(R.id.constraintLayout1, positionFragment);

        transaction.addToBackStack(null);

        transaction.commit();

        for (Fragment frag: fragManager.getFragments())
        {
            Log.i(TAG, frag.getClass().getSimpleName());
        }
    }

    @Override
    public void onChangePositionClick(int x, int y)
    {
        try
        {
            TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);
            textFragment.setTextPosition(x, y);
        }
        catch (Exception e)
        {
            Log.e(TAG, e.getMessage());
            Log.e(TAG, e.getStackTrace().toString());
        }
    }

    public void onButtonClick(int fontSize, String text)
    {
        Log.i(TAG,text + "-" + fontSize);

        //If we had initialized it in out ActivityLayout, you will have to instantiate it with the following line...
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.changeTextProperties(fontSize, text);
    }

}
