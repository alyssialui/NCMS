package com.ncms.ncms;

//import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;
import com.google.zxing.client.android.*;

public class ScannerActivity extends CaptureActivity {

	//@Override
	//protected void onCreate(Bundle savedInstanceState) {
	//	super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_scanner);
	//}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scanner, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
