package es.lhdev.menus;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewPress1;
    private TextView textViewPress2;
    private TextView contextMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewPress1 = findViewById(R.id.textViewPress1);
        textViewPress2 = findViewById(R.id.textViewPress2);

        registerForContextMenu(textViewPress1);
        registerForContextMenu(textViewPress2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(this.getClass().getSimpleName(), "onCreateOptionsMenu");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        menu.findItem(R.id.item1).setChecked(sp.getBoolean("item1", false));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Snackbar.make(findViewById(R.id.root1),"Settings", Snackbar.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.item1)
        {
            SharedPreferences.Editor e = PreferenceManager.getDefaultSharedPreferences(this).edit();
            if (item.isChecked())
            {
                e.putBoolean("item1", false);
                item.setChecked(false);
            }
            else
            {
                e.putBoolean("item1", true);
                item.setChecked(true);
            }
            e.apply();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void randomMenuOption(MenuItem item)
    {
        Snackbar.make(findViewById(R.id.root1),"ToDo", Snackbar.LENGTH_SHORT).show();
    }

    public void invalidateOptions(View view)
    {
        //This method destroys the menu and recreates it by calling onCreateOptionsMenu
        if (Build.VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i(this.getClass().getSimpleName(), "onPrepareOptionsMenu");
        //menu.add("patata2");
        menu.findItem(R.id.action_patata).getSubMenu().add("patata2");

        return true;
    }

    public void showPopup(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return onOptionsItemSelected(item);
            }
        });
        popup.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        Log.i(this.getClass().getSimpleName(), "onCreateContextsMenu");
        getMenuInflater().inflate(R.menu.textview_menu, menu);
        contextMenuView = (TextView) v;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.blue)
        {
            contextMenuView.setTextColor(Color.BLUE);
            return true;
        }

        return super.onContextItemSelected(item);
    }
}
