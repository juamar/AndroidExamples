package es.lhdev.receivingimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);

        Intent intent = getIntent();

        Uri data = intent.getData();

        URL url = null;
        try
        {
            url = new URL(data.getScheme(), data.getHost(), data.getPath());
            webView.loadUrl(url.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Error ocurred", Toast.LENGTH_SHORT).show();
        }
    }
}
