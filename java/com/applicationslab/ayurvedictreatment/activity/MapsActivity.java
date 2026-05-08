package com.applicationslab.ayurvedictreatment.activity;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.applicationslab.ayurvedictreatment.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapsActivity extends AppCompatActivity {

    private MapView map = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Initialize osmdroid configuration
        // This is crucial for the map to load tiles correctly
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        // 2. Set the layout
        setContentView(R.layout.activity_maps);

        // 3. Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(""); // Title is handled by the TextView in XML
        }

        // 4. Initialize the Map
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK); // Use standard map style
        map.setMultiTouchControls(true); // Enable pinch-to-zoom

        // 5. Set the Starting Point (Example: Bengaluru)
        // Change these coordinates to your desired location
        double latitude = 12.9716;
        double longitude = 77.5946;
        GeoPoint startPoint = new GeoPoint(latitude, longitude);

        // 6. Move Camera
        map.getController().setZoom(15.0);
        map.getController().setCenter(startPoint);

        // 7. Add a Marker (Pin)
        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("Ayurvedic Hospital");
        startMarker.setSnippet("Main Branch, Bengaluru");
        map.getOverlays().add(startMarker);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the back arrow button
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map != null) {
            map.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (map != null) {
            map.onPause();
        }
    }
}