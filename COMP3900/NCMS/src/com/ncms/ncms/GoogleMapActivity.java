package com.ncms.ncms;

//import java.util.List;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.app.Activity;
import android.os.Bundle;

public class GoogleMapActivity extends Activity {

	static LatLng origin = new LatLng(18.002856,-76.795659);
	private GoogleMap map;

	//MyLocationOverlay compass;
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
			map.setMyLocationEnabled(true);
			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			//origin = getMyPos();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(origin, 15));
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