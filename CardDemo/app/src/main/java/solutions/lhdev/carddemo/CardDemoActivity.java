package solutions.lhdev.carddemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import solutions.lhdev.carddemo.adapters.RecyclerAdapter;
import solutions.lhdev.carddemo.pojos.Card;

public class CardDemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerLayoutManager = new LinearLayoutManager(this); //Check that we can use another layout Manager.
        recyclerView.setLayoutManager(recyclerLayoutManager);

        adapter = new RecyclerAdapter(makeExample());
        recyclerView.setAdapter(adapter);
    }

    public List<Card> makeExample()
    {
        ArrayList<Card> l = new ArrayList<>();
        l.add(new Card(1,"hola","Soy una card",R.mipmap.ic_launcher));
        l.add(new Card(2,"Tema 1","Soy otra card",R.drawable.android_image_1));
        l.add(new Card(3,"Cola cola","¿Sabes que tengo mucha azucar?",R.drawable.android_image_2));
        l.add(new Card(4,"Pepsi","yo no... jeje",R.drawable.android_image_4));
        l.add(new Card(5,"pp","Soy una card demasiado aburrida",R.drawable.android_image_5));
        return l;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
