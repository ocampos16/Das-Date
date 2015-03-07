package com.example.thebasics;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.view.View;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	//Fields
	Button btn;
	ImageView img;
	Intent i;
	final static int cons = 0;
	Bitmap bmp;
	
	String s = "hello";
	
	//Camera state enums
	enum cameraStates {VIDEO, PICTURE};
	//Current State
	cameraStates currentCameraState = cameraStates.VIDEO;
		
	//Database Handler
	//dbHandler dbhandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.init();
		
		//We create the dbHandler object
		//this.dbhandler = new dbHandler();		
		
	}//End protected void onCreate(Bundle savedInstanceState)

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}//End public boolean onCreateOptionsMenu(Menu menu)s

	public void init(){			
		
		//Button
		btn = (Button)findViewById(R.id.btnRecord);
		btn.setOnClickListener(this);	
		
		//Image
		img = (ImageView)findViewById(R.id.image);
		
	}//End public void init()
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		int id;
		id = v.getId();
		
		switch(id){
		
		case R.id.btnRecord:												
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cons);
			break;
			
		case R.id.btnOpenNewWindow:												
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cons);
			break;
						
			default:
				break;
			
		}//End switch()			
		
	}//End public void onClick(View v)
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK){
			
			Bundle ext = data.getExtras();
			bmp = (Bitmap)ext.get("data");
			img.setImageBitmap(bmp);
			
		}//End if (resultCode == Activity.RESULT_OK)		
		
	}//End protected void onActivityResult(int requestCode, int resultCode, Intent data)
	
}
