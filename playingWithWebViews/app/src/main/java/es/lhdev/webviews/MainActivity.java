package es.lhdev.webviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView webViewSimple;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNext = findViewById(R.id.buttonNext);

        webViewSimple = findViewById(R.id.webViewSimple);
        webViewSimple.loadUrl("http://ludustic.es");
    }

    public void onButtonNextClicked(View v)
    {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
