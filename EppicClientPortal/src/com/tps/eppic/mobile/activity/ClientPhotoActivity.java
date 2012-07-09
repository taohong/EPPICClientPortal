package com.tps.eppic.mobile.activity;

import com.tps.eppic.mobile.adapter.ImageAdapter;
import com.tps.eppic.mobile.util.CPUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/*
 *
 *@Author Nicq Chen
 *
 */
public class ClientPhotoActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_photo_layout);
		GridView gridView = (GridView) findViewById(R.id.clientPhotoGrid);
		Resources resources = this.getResources();
		TypedArray icons = this.getResources().obtainTypedArray(
				R.array.moduleImages);
		final String[] nameStrings = resources
				.getStringArray(R.array.moduleNames);
		final int[] imageIds = CPUtils.convertTypeArrToIntegerArr(icons,
				nameStrings.length);
		gridView.setAdapter(new ImageAdapter(this, imageIds, nameStrings));
		gridView.setBackgroundResource(R.drawable.subbg);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            
            
            public void onItemClick(AdapterView<?> parent, View griditem, int position,long arg3) {
            	Intent intent = new Intent(ClientPhotoActivity.this, ClientSecurityProfileActivity.class);
            	intent.putExtra("photo", imageIds[position]);
            	startActivity(intent);
             }
        });
	}

}
