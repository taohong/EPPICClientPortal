package com.tps.eppic.mobile.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tps.eppic.mobile.activity.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    // references to our images
    private int[] mIconIds;
    // references to our image text
    private String[] mIconTextValues;
    

    public View getView(int position, View convertView, ViewGroup arg2) {
        
        View view = View.inflate(mContext, R.layout.main, null);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.home);
        ImageView image = (ImageView) rl.findViewById(R.id.icon);
        TextView text = (TextView) rl.findViewById(R.id.icon_name);
        image.setImageResource(mIconIds[position]);
        text.setText(mIconTextValues[position]);
        return rl;
    }

    public ImageAdapter(Context c, int[] iconIds, String[] iconTextValues) {
        mContext = c;
        mIconIds = iconIds;
        mIconTextValues = iconTextValues;
    }

    
    public int getCount() {
        return mIconIds.length;
    }

    
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

}
