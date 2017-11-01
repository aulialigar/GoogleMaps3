package com.example.aulialigar.googlemaps3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition Cirebon = CameraPosition.builder()
            .target(new LatLng(-6.707039, 108.558655))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition Surabaya = CameraPosition.builder()
            .target(new LatLng(-7.248903, 112.738303))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition Malang = CameraPosition.builder()
            .target(new LatLng(-7.982776, 112.631056))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition Tulungagung = CameraPosition.builder()
            .target(new LatLng(-8.064648, 111.900639))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSeattle = (Button) findViewById(R.id.btnCirebon);
        btnSeattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(Cirebon);
            }
        });

        Button btnDublin = (Button) findViewById(R.id.btnTulungagung);
        btnDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(Tulungagung);
            }
        });

        Button btnTokyo = (Button) findViewById(R.id.btnMalang);
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(Malang);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(Surabaya);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
