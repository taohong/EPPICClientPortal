package com.tps.eppic.mobile.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.widget.ExpandableListView;

import com.tps.eppic.mobile.adapter.EppicClilentStmtExpandableListAdapter;

public class ClientStmtPageActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientstmt_layout);
        
        Resources resources = this.getResources();
        String[] clientstmtGroup = resources.getStringArray(R.array.clientstmt_group);
        String[] trxSummary = resources.getStringArray(R.array.clientstmt_group_child_trxsum);
        String[] pendingLastMonth = resources.getStringArray(R.array.clientstmt_group_child_pendingtrxlastmonth);
        String[] pendingTrx = resources.getStringArray(R.array.clientstmt_group_child_pendingtrx);
        String[] clearedTrx = resources.getStringArray(R.array.clientstmt_group_child_clearedtrx);
        String[][] clientstmtChildren = {trxSummary, pendingLastMonth, pendingTrx, clearedTrx};
        
        EppicClilentStmtExpandableListAdapter adapter = new EppicClilentStmtExpandableListAdapter(this, clientstmtGroup, clientstmtChildren);
        
        ExpandableListView view = (ExpandableListView)findViewById(R.id.expandableListView1);
        view.setAdapter(adapter);
        
        view.setBackgroundResource(R.drawable.subbg);
        
        // to move the group indicator to right. start!
        Display newDisplay = getWindowManager().getDefaultDisplay(); 
        int width = newDisplay.getWidth();
        view.setIndicatorBounds(width-50, width);
     // to move the group indicator to right. End.this is not recommanded!!!
        
	}
	
}
