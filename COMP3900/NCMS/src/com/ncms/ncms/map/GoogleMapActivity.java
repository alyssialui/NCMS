package com.ncms.ncms.map;

import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MapController;
import com.google.android.maps.GeoPoint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;
import com.google.android.maps.OverlayItem;
import com.ncms.ncms.R;
import com.ncms.ncms.R.drawable;
import com.ncms.ncms.R.id;
import com.ncms.ncms.R.layout;

public class GoogleMapActivity extends MapActivity implements LocationListener{

	private MapView mapView;
	private LocationManager locManager;
	private MyItemizedOverlay itemizedOverlay;
	private GeoPoint point;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_google_map_tab);
		
		//fetch the map view from the layout
        mapView = (MapView) findViewById(R.id.mapview);

        //make available zoom controls
        mapView.setBuiltInZoomControls(true);
        
        //get the MapController object
        MapController controller = mapView.getController();

        //set the map zoom to 13
        // zoom 1 is top world view
        controller.setZoom(13);


        // Use the location manager through GPS
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0, this);

        //get the current location (last known location) from the location manager
        Location location = locManager
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);


            //if location found display as a toast the current latitude and longitude
        if (location != null) {

            Toast.makeText(
                    this,
                    "Current location:\nLatitude: " + location.getLatitude()
                            + "\n" + "Longitude: " + location.getLongitude(),
                    Toast.LENGTH_LONG).show();
		            point = new GeoPoint((int)(location.getLatitude()*1E6),(int)(location.getLongitude() *1E6));
		
		            controller.animateTo(point);
        } else {

            Toast.makeText(this, "Cannot fetch current location!",
                    Toast.LENGTH_LONG).show();
        }

//      //invalidate the map in order to show changes
//        mapView.invalidate();
//        
        // fetch the drawable - the pin that will be displayed on the map
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);

        // create and add an OverlayItem to the MyItemizedOverlay list
        OverlayItem overlayItem = new OverlayItem(point, "", "");

        itemizedOverlay = new MyItemizedOverlay(drawable,this);
        itemizedOverlay.addOverlay(overlayItem);

        // add the overlays to the map
        mapView.getOverlays().add(itemizedOverlay);
        mapView.invalidate();
        
        
//when the current location is found � stop listening for updates (preserves battery)
        locManager.removeUpdates(this);
    }

   @Override
    protected boolean isRouteDisplayed() {

        return false;

    }
   
   /* When the activity starts up, request updates */
   @Override
   protected void onResume() {
       super.onResume();
       locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
               0, this);
   }

   @Override
   protected void onPause() {
       super.onPause();
       locManager.removeUpdates(this); //activity pauses => stop listening for updates
   }
       @Override
   public void onLocationChanged(Location location) {

   }


   @Override
   public void onProviderDisabled(String provider) {

   }

   @Override
   public void onProviderEnabled(String provider) {

   }

   @Override
   public void onStatusChanged(String provider, int status, Bundle extras) {

   }
}



