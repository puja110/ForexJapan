package com.example.forexjapan.activity.customerDetail;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.forexjapan.R;
import com.example.forexjapan.activity.customerDetail.adapter.PagerTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerDetailActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //This is our tablayout
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    //This is our viewPager
    @BindView(R.id.pager)
    ViewPager viewPager;

    String id = "";

    private TextView toolbarTitleGrid;
    public Toolbar toolbarback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        ButterKnife.bind(this);

        toolbarTitleGrid = (TextView)findViewById(R.id.toolbarTitle);
        toolbarTitleGrid.setText("Customer Detail");

        toolbarback = findViewById(R.id.toolbar);
        setSupportActionBar(toolbarback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarback.setNavigationOnClickListener(v -> finish());

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Creating our pager adapter
        PagerTabAdapter adapter = new PagerTabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
