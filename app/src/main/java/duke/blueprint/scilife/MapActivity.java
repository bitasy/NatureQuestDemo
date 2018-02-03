package duke.blueprint.scilife;

import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private final LatLng DEFAULT_LOCATION = new LatLng(35.9940, -78.8986);

    private GoogleMap mMap;

    private Quest[] locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locations  = new Quest[]{
                new Quest("Raleigh Quest", 35.7796, -78.6382,
                        BitmapFactory.decodeResource(getResources(), R.drawable.flowericon)),
                new Quest("Durham Quest", 35.9940, -78.8986,
                        BitmapFactory.decodeResource(getResources(), R.drawable.treeicon))
        };

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for(Quest quest : locations){
            quest.addToMap(mMap);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(DEFAULT_LOCATION));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 12.0f));
    }
}
