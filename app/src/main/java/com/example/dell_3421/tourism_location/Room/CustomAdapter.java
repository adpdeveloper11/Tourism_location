package com.example.dell_3421.tourism_location.Room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell_3421.tourism_location.R;


public class CustomAdapter extends BaseAdapter {
    Context mContext;
    String[] strName;
    int[] resId;
    public CustomAdapter(Context context,String[] strName,int[] resId){
        this.mContext = context;
        this.strName = strName;
        this.resId = resId;

    }
    @Override
    public int getCount() {
        return strName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view ==null)
            view = mInflater.inflate(R.layout.listview_row_room,parent,false);
        TextView textView = (TextView) view.findViewById(R.id.text_room_detail1);
        textView.setText(strName[position]);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_room1);
        imageView.setBackgroundResource(resId[position]);

        return view;
    }
}
