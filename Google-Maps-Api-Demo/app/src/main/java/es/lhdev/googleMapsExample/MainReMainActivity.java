package es.lhdev.googleMapsExample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainReMainActivity extends AppCompatActivity
{

    static final int LOCATION_REQUEST_CODE = 101;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case (R.id.item_mapView):
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case (R.id.item_basic):
                startBasicMap();
                break;
            case (R.id.item_camera_and_map):
                startCameraMapActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void requestPermission(String permissionType, int requestCode)
    {
        requestPermissions(new String[]{permissionType}, requestCode);
    }

    public void startCameraMapActivity()
    {
        Intent i = new Intent(this, CameraMapActivity.class);
        startActivity(i);
    }

    public void startBasicMap()
    {
        Intent j = new Intent(this, MapsActivity.class);
        startActivity(j);
    }
}
