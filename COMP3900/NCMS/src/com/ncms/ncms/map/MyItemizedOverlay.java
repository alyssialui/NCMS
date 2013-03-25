package com.ncms.ncms.map;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {

    private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
    long start;
    long stop;

    public MyItemizedOverlay(Drawable defaultMarker, Context ctx) {
        super(boundCenterBottom(defaultMarker));

    }

    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }

    public void clear() {

        mOverlays.clear();
        populate();
    }

    @Override
    protected OverlayItem createItem(int i) {
        return mOverlays.get(i);
    }

    @Override
    public int size() {
        return mOverlays.size();
    }

    @Override
    protected boolean onTap(int index) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView){
    	if(event.getAction()==MotionEvent.ACTION_DOWN){
    		start = event.getEventTime();
    	}
    	if(event.getAction()==MotionEvent.ACTION_UP){
    		stop = event.getEventTime();
    	}
    	if (stop-start > 1500)
    	{
    		//action for long click
    		AlertDialog alert = new AlertDialog.Builder(null).create();
    		alert.setTitle("pick an option");
    		alert.setMessage("psst");
    		alert.setButton(0, "Place pinpoint", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
    		alert.show();
    	}
        return false;
    }

}
