package com.parkho.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhMainActivity extends AppCompatActivity {

    // List item
    private List<PhCountryItem> mItemList;

    // ListView adapter
    private BaseAdapter mCountryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindList();
    }

    private void bindList() {
        mItemList = new ArrayList<>();
        mItemList.add(new PhCountryItem(R.drawable.ico_southkorea, "Korea"));
        mItemList.add(new PhCountryItem(R.drawable.ico_china, "China"));
        mItemList.add(new PhCountryItem(R.drawable.ico_japan, "Japan"));
        mItemList.add(new PhCountryItem(R.drawable.ico_unitedstates, "America"));
        mItemList.add(new PhCountryItem(R.drawable.ico_newzealand, "NewZealand"));

        // Base adapter
        mCountryAdapter = new PhCountryBaseAdapter(this, mItemList);

        // Array adapter
        //mCountryAdapter = new PhCountryArrayAdapter(this, mItemList);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(mCountryAdapter);
    }
}
