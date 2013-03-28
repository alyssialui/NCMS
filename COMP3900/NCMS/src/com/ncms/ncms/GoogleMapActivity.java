package com.ncms.ncms;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.maps.MyLocationOverlay;
//import com.google.android.maps.Overlay;

import android.app.Activity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MotionEvent;

public class GoogleMapActivity extends Activity {

	GoogleMap map;
	GoogleMapOptions option = new GoogleMapOptions();
	Marker hamburg, kiel;
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		if(map==null){
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		option.zoomControlsEnabled(true);
		
		}
		
		
		if (map!=null){
		      hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
		          .title("Hamburg"));
		      kiel = map.addMarker(new MarkerOptions()
		          .position(KIEL)
		          .title("Kiel")
		          .snippet("Kiel is cool")
		          .icon(BitmapDescriptorFactory
		              .fromResource(R.drawable.ic_launcher)));
		    }
		
		map.setOnMarkerClickListener(new OnMarkerClickListener(){

			@Override
			public boolean onMarkerClick(Marker arg0) {
				// TODO Auto-generated method stub
				//go to details page
				return false;
			}
			
		});
	}}