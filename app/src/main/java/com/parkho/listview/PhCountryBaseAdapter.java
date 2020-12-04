package com.parkho.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class PhCountryBaseAdapter extends BaseAdapter {
    private static final int LAYOUT_RESOURCE_ID = R.layout.content_list_item;

    private Context mContext;
    private List<PhCountryItem> mItemList;

    public PhCountryBaseAdapter(Context a_context, List<PhCountryItem> a_itemList) {
        mContext = a_context;
        mItemList = a_itemList;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int a_position) {
        return mItemList.get(a_position);
    }

    @Override
    public long getItemId(int a_position) {
        return a_position;
    }

    @Override
    public View getView(int a_position, View a_convertView, ViewGroup a_parent) {
        PhCountryItemViewHolder viewHolder;
        if (a_convertView == null) {
            a_convertView = LayoutInflater.from(mContext).inflate(LAYOUT_RESOURCE_ID, a_parent, false);

            viewHolder = new PhCountryItemViewHolder(a_convertView);
            a_convertView.setTag(viewHolder);
        } else {
            viewHolder = (PhCountryItemViewHolder) a_convertView.getTag();
        }

        PhCountryItem countryItem = mItemList.get(a_position);

        // Icon 설정
        viewHolder.ivIcon.setImageResource(countryItem.getImageResId());

        // Country 설정
        viewHolder.tvCountry.setText(countryItem.getCountry());

        return a_convertView;
    }
}