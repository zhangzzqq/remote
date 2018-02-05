package com.mdsd.telemedicine.module.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import com.mdsd.telemedicine.R;


/**
 * Created by panxb on 27/04/17.
 */

public class NavShortcutsAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private int[] resId;

    public NavShortcutsAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resId = new int[]{R.drawable.ic_menu_camera,
                R.drawable.ic_menu_gallery,
                R.drawable.ic_menu_manage,
                R.drawable.ic_menu_send,
                R.drawable.ic_menu_share};
    }

    @Override
    public int getCount() {
        return resId.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_nav_shortcut, parent, false);
        }
//        ((CheckBox) convertView).setText("" + position);
        ((ImageButton) convertView).setImageResource(resId[position]);
        return convertView;
    }
}
