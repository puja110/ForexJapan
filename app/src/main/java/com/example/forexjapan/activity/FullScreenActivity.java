package com.example.forexjapan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.forexjapan.R;
import com.example.forexjapan.adapter.FullScreenImageAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class FullScreenActivity extends Activity {

    ArrayList<Integer> sliderImages = new ArrayList<>();
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        Intent intent = getIntent();

        if (intent!=null){
            Log.e("hjgjhg","kjgkj");
            Log.e("heyy",new Gson().toJson(getIntent().getStringExtra("filemap")));
            HashMap<String, Integer> hashMap = new Gson().fromJson(getIntent().getStringExtra("filemap"), new TypeToken<HashMap<String,Integer>>(){}.getType());
            sliderImages = new ArrayList<Integer>(hashMap.values());
            sliderImages.addAll(hashMap.values());
        }

        viewPager = (ViewPager) findViewById(R.id.pagerFullScreen);
        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        Log.e("heyyyyyy",new Gson().toJson(sliderImages));
        adapter = new FullScreenImageAdapter(FullScreenActivity.this, sliderImages);
        viewPager.setAdapter(adapter);
        // displaying selected image first
        viewPager.setCurrentItem(position);
    }

}



