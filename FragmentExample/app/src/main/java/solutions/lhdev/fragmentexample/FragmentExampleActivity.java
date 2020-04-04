package solutions.lhdev.fragmentexample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FragmentExampleActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {

    private TextFragment textFragment;
    private final String TAG = "FragmentExampleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        textFragment = new TextFragment();
        //textFragment.setArguments(getIntent().getExtras());

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();

        transaction.add(R.id.constraintLayout1, textFragment);

        //transaction.remove(textFragment);

        //transaction.replace(R.id.constraintLayout1, secondFragment);
        //transaction.addToBackStack(null);

        transaction.commit();

    }

    public void onButtonClick(int fontSize, String text)
    {
        Log.i(TAG,text + "-" + fontSize);

        //If we had initialized it in out ActivityLayout, you will have to instantiate it with the following line...
        //TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.changeTextProperties(fontSize, text);
    }

}


