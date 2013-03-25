package com.ncms.ncms;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity_tab extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_tab);
		
		List<? extends Map<String, ?>> manifest_list = null;
		int groupLayout =0, childLayout = 0;
		int[] groupTo = new int[10];
		int[] childTo = new int[10];
		String[] groupFrom = new String[10];
		String[] childFrom = new String[10];
		List<? extends List<? extends Map<String, ?>>> childData = null;
		SimpleExpandableListAdapter expListAdapter =
            new SimpleExpandableListAdapter(this, manifest_list, groupLayout, groupFrom, groupTo, childData , childLayout, childFrom, childTo);
            setListAdapter( expListAdapter );       // setting the adapter in the list.
 
        }catch(Exception e){
            System.out.println("Errrr +++ " + e.getMessage());
        }
		
//		findViewById(R.id.sign_in_button).setOnClickListener(
//				new View.OnClickListener() {
//					@Override
//					public void onClick(View view) {
//						attemptLogin();
//					}
//				});
	}

	private void setListAdapter(SimpleExpandableListAdapter expListAdapter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_tab, menu);
		return true;
	}

}
