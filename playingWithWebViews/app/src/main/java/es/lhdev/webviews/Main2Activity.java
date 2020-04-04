package es.lhdev.webviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private WebView webViewComplex;
    private ImageButton imageButtonback;
    private ImageButton imageButtonFoward;
    private EditText editTextUrl;
    private ImageButton imageButtonGo;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageButtonGo = findViewById(R.id.imageButtonGo);
        imageButtonback = findViewById(R.id.imageButtonBack);
        imageButtonFoward = findViewById(R.id.imageButtonFoward);
        progressBar = findViewById(R.id.progressBar);
        editTextUrl = findViewById(R.id.editTextUrl);

        editTextUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId==2)
                {
                    onGo(v);
                }
                return true;
            }
        });

        webViewComplex = findViewById(R.id.webViewComplex);

        webViewComplex.getSettings().setJavaScriptEnabled(true);

        webViewComplex.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                if (progress >= 100)
                {
                    progressBar.setProgress(0);
                }
                else
                {
                    progressBar.setProgress(progress);
                }
            }
        });
        webViewComplex.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest r, WebResourceResponse e) {
                Toast.makeText(view.getContext(), "Oh no! " + e.getStatusCode(), Toast.LENGTH_LONG).show();
            }
        });

        webViewComplex.loadUrl("https://google.es");
    }

    public void onGo(View v)
    {
        webViewComplex.loadUrl(editTextUrl.getText().toString());
    }

    public void onBack(View V)
    {
        webViewComplex.goBack();
    }

    public void onFoward(View v)
    {
        webViewComplex.goForward();
    }

    public void onZoomIn(View v)
    {
        webViewComplex.zoomIn();
    }

    public void onZoomOut(View v)
    {
        webViewComplex.zoomOut();
    }
}
