/*
*Nicq.chen@acs-inc.com
*Apr 15, 2012
*nicq
*/ 
package com.tps.eppic.mobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

/**
 * 
 * the activity aim to help client to change their security profile
 * and some relative information.
 *
 */
public class ClientSecurityProfileActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_security_profile_layout);
		TableLayout tableLayout = (TableLayout)findViewById(R.id.clientSecurityProfileView);
		tableLayout.setBackgroundResource(R.drawable.subbg);
		ImageView imageView = (ImageView)findViewById(R.id.imageButton);
		Intent intent = getIntent();
		if(intent!= null){
			if(intent.getExtras() != null){
				if(intent.getExtras().containsKey("photo")){
					imageView.setImageResource(intent.getIntExtra("photo",	-1));
				}
			}
		}
		imageView.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ClientSecurityProfileActivity.this, ClientPhotoActivity.class);
				startActivity(intent);
			}
		});
		
		Button okButton = (Button)findViewById(R.id.okSecurityProfile);
		okButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(ClientSecurityProfileActivity.this, MainPageActivity.class);
				startActivity(intent);
			}
		});
	}

	
}
