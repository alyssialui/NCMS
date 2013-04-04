package com.ncms.ncms;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

import android.widget.Toast;

public class MainActivity_tab extends Activity {

	ExpandableListView exv;
	int numDeliveries;
	int numStops; // areas to deliver papers in delivery
	int numAgents; // agents within area to delivery papers to
	GoogleMap map;
	GoogleMapOptions option = new GoogleMapOptions();
	static LatLng origin = new LatLng(18.002856, -76.795659);

	// HorizontalScrollView hv = (HorizontalScrollView)
	// findViewById(R.id.SlideMap);
	// int maxScrollX =
	// hv.getChildAt(0).getMeasuredWidth()-hv.getMeasuredWidth();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_tab);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.setMyLocationEnabled(true);
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(origin, 15));

		exv = (ExpandableListView) findViewById(R.id.tabListView);
		exv.setAdapter(new MyAdapter(this));
		exv.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView arg0, View arg1,
					int groupPosition, long arg3) {
				// TODO Auto-generated method stub
				// change mapview
				// show route from current location to destination
				String itemClicked = MyAdapter.parentList[groupPosition];
				Toast.makeText(MainActivity_tab.this,
						itemClicked + " is clicked", Toast.LENGTH_SHORT).show();
				String deliveryList = "";
				for (int i = 0; i < MyAdapter.childList[groupPosition].length; i++) {
					deliveryList += MyAdapter.childList[groupPosition][i]
							+ ", ";
					deliveryList.substring(0, deliveryList.length());
				}
				if (map == null) {
					map = ((MapFragment) getFragmentManager().findFragmentById(
							R.id.map)).getMap();
					map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
					option.zoomControlsEnabled(true);
				}
				if (map != null) {
					// Marker zone;
					map.moveCamera(CameraUpdateFactory
							.newLatLngZoom(origin, 15));
					map.addMarker(new MarkerOptions()
							.position(origin)
							.title(itemClicked)
							.snippet(deliveryList)
							.icon(BitmapDescriptorFactory
									.fromResource(R.drawable.parcel)));
				}
				return false;
			}
		});

		exv.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				// go to delivery page
				String itemClicked = MyAdapter.parentList[groupPosition];
				Bundle deliveryInfo = new Bundle();
				if (itemClicked.equals("Delivery 1")) {
					try {
						deliveryInfo
								.putString(
										"delivery info",
										MyAdapter.childList[groupPosition][childPosition]);
						Intent chosenLayout = new Intent(MainActivity_tab.this,
								ScannerActivity.class).putExtras(deliveryInfo);
						startActivity(chosenLayout);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				}
				return false;
			}

		});

		numDeliveries = exv.getCount();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_tab, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

}
