package com.tps.eppic.mobile.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardAndBalanceInqiryActivity extends Activity {
    /** Called when the activity is first created. */

    // testing data
    private String[] groupDescs = new String[] { "Client Information",
            "Client Cards and Balances", "Automated Deposit Notification" };

    private String[][] titles = new String[][] {
            { "\nName:", "\nAddress:" },
            { "\nCard Number:", "\nStatus:", "\nIssue Date:", "\nExpire Date:",
                    "\nFreeze Date:", "\nCash Balance:", "\nTotal:" },
            { "\nMethod of contact:", "\nEmail:", "\nPhone:" } };

    // testing result data
    private String[] clientInfos = new String[] { "    Sam Li",
            "    TJ TJ, OH 346567801" };

    private String[] clientCardAndBalanceInfos = new String[] {
            "    100000xxxxxx3959", "    NON FRAUD SUSPENSION",
            "    04/11/2012", "    04/30/2015", "    04/11/2012", "    -$7.01",
            "    04/11/2012", "    -$7.01" };

    private String[] automatedDepositNotificationInfos = new String[] {
            "    None", "    test001@acs-inc.com", "    3920618956" };

    private String[][] childDescs = new String[][] {
            { assembleInfos(titles[0], clientInfos) },
            { assembleInfos(titles[1], clientCardAndBalanceInfos) },
            { assembleInfos(titles[2], automatedDepositNotificationInfos) } };

    private String assembleInfos(String[] titles, String[] infos) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < clientInfos.length; i++) {
            stringBuffer.append(titles[i] + infos[i] + "\n");
        }
        return stringBuffer.toString();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_list_template);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            
            public boolean isChildSelectable(int groupPosition,
                    int childPosition) {
                // TODO Auto-generated method stub
                return true;
            }

            
            public boolean hasStableIds() {
                // TODO Auto-generated method stub
                return true;
            }

            
            public View getGroupView(int groupPosition, boolean isExpanded,
                    View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                LinearLayout ll = new LinearLayout(
                        CardAndBalanceInqiryActivity.this);
                ll.setOrientation(0);
                TextView textView = getGroupTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            
            public int getGroupCount() {
                return groupDescs.length;
            }

            
            public Object getGroup(int groupPosition) {
                return groupDescs[groupPosition];
            }

            
            public int getChildrenCount(int groupPosition) {
                return childDescs[groupPosition].length;
            }

            
            public View getChildView(int groupPosition, int childPosition,
                    boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getChildTextView();
                textView.setText(getChild(groupPosition, childPosition)
                        .toString());
                return textView;
            }

            
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            
            public Object getChild(int groupPosition, int childPosition) {
                return childDescs[groupPosition][childPosition];
            }

            private TextView getGroupTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 80);
                TextView textView = new TextView(
                        CardAndBalanceInqiryActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(15);
                return textView;

            }

            private TextView getChildTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView textView = new TextView(
                        CardAndBalanceInqiryActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(10);
                textView.setTextColor(Color.BLACK);
                return textView;

            }
        };
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        expandableListView.setIndicatorBounds(width - getDipsFromPixel(50),
                width - getDipsFromPixel(10));
        expandableListView.setBackgroundResource(R.drawable.subbg);
        expandableListView.setAdapter(adapter);
    }

    private int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}