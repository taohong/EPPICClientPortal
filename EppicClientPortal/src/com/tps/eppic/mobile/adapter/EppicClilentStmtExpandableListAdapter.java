package com.tps.eppic.mobile.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.tps.eppic.mobile.activity.CardAndBalanceInqiryActivity;
import com.tps.eppic.mobile.activity.R;

public class EppicClilentStmtExpandableListAdapter extends
		BaseExpandableListAdapter {

	private Context context;
	private String[] clientstmtGroup = null;
	
	private String[][] clientstmtChildren = null;
	
	public EppicClilentStmtExpandableListAdapter(Context context, String[] clientstmtGroup, String[][] clientstmtChildren){
		this.clientstmtGroup = clientstmtGroup;
		this.clientstmtChildren = clientstmtChildren;
		this.context = context;
	}
		
	private TextView getChildTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(
                context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(15);
        textView.setTextColor(Color.BLACK);
        return textView;

    }
	
	
	public Object getChild(int groupPosition, int childPosition) {
		StringBuffer stringBuffer = new StringBuffer();
		switch (groupPosition){
		case 0:
			//Summary of Transactions --> Date Range
			stringBuffer.append(clientstmtChildren[groupPosition][0] + " " + "04/01/2012 ~ 04/30/2012" + "\n");
			//Summary of Transactions --> Starting Balance
			stringBuffer.append(clientstmtChildren[groupPosition][1] + " " + "$10.00" + "\n");
			//Summary of Transactions --> Credits
			stringBuffer.append(clientstmtChildren[groupPosition][2] + " " + "$200.00" + "\n");
			//Summary of Transactions --> Debits
			stringBuffer.append(clientstmtChildren[groupPosition][3] + " " + "$300.00" + "\n");
			//Summary of Transactions --> Available Balance
			stringBuffer.append(clientstmtChildren[groupPosition][4] + " " + "$400.00" + "\n");
			//Summary of Transactions --> Card Number
			stringBuffer.append(clientstmtChildren[groupPosition][5] + " " + "100000XXXXXX0982" + "\n");
			break;
		case 1:
    		//Transaction Date
    		stringBuffer.append(clientstmtChildren[groupPosition][0] + " " + "04/02/2012" + "\n");
    		//Date Posted
    		stringBuffer.append(clientstmtChildren[groupPosition][1] + " " + "04/02/2012" + "\n");
    		//Merchant/ATM Location/Confirmation Number
    		stringBuffer.append(clientstmtChildren[groupPosition][2] + " " + "1234567890" + "\n");
    		//Transaction Type
    		stringBuffer.append(clientstmtChildren[groupPosition][3] + " " + "ATM WITHDRAW" + "\n");
    		//Hold Amount
    		stringBuffer.append(clientstmtChildren[groupPosition][4] + " " + "$10.00" + "\n");
    		//Posted Amount
    		stringBuffer.append(clientstmtChildren[groupPosition][5] + " " + "$5.00" + "\n");
    		//Difference
    		stringBuffer.append(clientstmtChildren[groupPosition][6] + " " + "$1.00" + "\n");
        	break;
		case 2:
    		//Date Posted
    		stringBuffer.append(clientstmtChildren[groupPosition][0] + " " + "04/02/2012" + "\n");
    		//Merchant/ATM Location/Confirmation Number
    		stringBuffer.append(clientstmtChildren[groupPosition][1] + " " + "1234567890" + "\n");
    		//Transaction Type
    		stringBuffer.append(clientstmtChildren[groupPosition][2] + " " + "CASH PURCHASE" + "\n");
    		//Amount
    		stringBuffer.append(clientstmtChildren[groupPosition][3] + " " + "$10.00" + "\n");
        	break;
		case 3:
    		//Date Posted
    		stringBuffer.append(clientstmtChildren[groupPosition][0] + " " + "04/02/2012" + "\n");
    		//Merchant/ATM Location/Confirmation Number
    		stringBuffer.append(clientstmtChildren[groupPosition][1] + " " + "1234567890" + "\n");
    		//Transaction Type
    		stringBuffer.append(clientstmtChildren[groupPosition][2] + " " + "CASH PURCHASE" + "\n");
    		//Amount
    		stringBuffer.append(clientstmtChildren[groupPosition][3] + " " + "$10.00" + "\n");
        	break;
        default:
        	break;
		}
		return stringBuffer.toString();
	}

	
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView textView = getChildTextView();
		String str = (String)getChild(groupPosition, childPosition);
		
        textView.setText(str);
        return textView;
	}
	

	
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 1;
	}

	
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return clientstmtGroup[groupPosition];
	}

	
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return clientstmtGroup.length;
	}

	
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LinearLayout ll = new LinearLayout(context);
		ll.setOrientation(LinearLayout.VERTICAL);
		TextView textView = new TextView (context);
		textView.setText(clientstmtGroup[groupPosition]);
//		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);      
		textView.setPadding(10, 20, 0, 20);   
		textView.setTextColor(Color.BLACK);
		ll.addView(textView);
		
		
		return ll;
	}

	
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
