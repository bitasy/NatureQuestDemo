package duke.blueprint.scilife;

import android.graphics.Bitmap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Brian on 2/3/2018.
 */

public class Quest {

    private String name;
    private LatLng location;
    private Bitmap icon;

    public Quest(String name, double latitude, double longitude, Bitmap image){
        this.name = name;
        location = new LatLng(latitude, longitude);
        icon = Bitmap.createScaledBitmap(image, 150, 150, false);

    }

    public void addToMap(GoogleMap map){
        map.addMarker(new MarkerOptions().position(location).title(name).icon(BitmapDescriptorFactory.fromBitmap(icon)));
    }
}
