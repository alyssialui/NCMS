package com.ncms.ncms;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = {"ScannerActivity","GoogleMapActivity","MainActivity_tab","LoginActivity","ListMapCombo"};
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String userChoice = classes[position];
		try{
		Class menuOption = Class.forName("com.ncms.ncms." + userChoice);
		Intent chosenLayout = new Intent(Menu.this,menuOption);
		startActivity(chosenLayout);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
}
