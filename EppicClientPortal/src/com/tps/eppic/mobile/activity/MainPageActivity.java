package com.tps.eppic.mobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tps.eppic.mobile.adapter.ImageAdapter;
import com.tps.eppic.mobile.cache.MobileClientPortalCache;
import com.tps.eppic.mobile.util.CPUtils;



public class MainPageActivity extends Activity {
    /** Called when the activity is first created. */
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	MobileClientPortalCache.getInstance().setElement(MobileClientPortalCache.KEY_PERSON_ID, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_template);
        //get icon res and icon names from xml
        Resources resources = this.getResources();
        TypedArray icons = this.getResources().obtainTypedArray(R.array.moduleImages);
        final String[] nameStrings = resources.getStringArray(R.array.moduleNames);
        final int[] imageIds = CPUtils.convertTypeArrToIntegerArr(icons, nameStrings.length);
        //use adapter fill the grid view
        GridView gridView = (GridView)findViewById(R.id.grid01);
        gridView.setAdapter(new ImageAdapter(this, imageIds, nameStrings));
        //set background for main page
        gridView.setBackgroundResource(R.drawable.bg);
        
        //add listener for the image click on grid view
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            
            
            public void onItemClick(AdapterView<?> parent, View griditem, int position,long arg3) {
            	Intent intent = null;
            	switch (imageIds[position]) {
                    case R.drawable.airorderquery:
                       intent = new Intent(MainPageActivity.this, CardAndBalanceInqiryActivity.class);
                        break;
                    case R.drawable.relate_creditcard:
                    	intent = new Intent(MainPageActivity.this, ClientSecurityProfileActivity.class);
                    	break;
                    case R.drawable.financing_product:
                    	intent = new Intent(MainPageActivity.this, ClientStmtPageActivity.class);
                    	break;
                    default:
                        break;
                }
            	if(intent != null){
                    startActivity(intent);
            	}
             }
        });
    }
}