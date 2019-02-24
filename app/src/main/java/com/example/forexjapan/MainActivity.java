package com.example.forexjapan;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.forexjapan.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private static FragmentManager fragmentManager;
    private ImageView navigationMenu;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private CoordinatorLayout mDrawerContent;

    @BindView(R.id.toolbarTitle)
    TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.frame_container)!=null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            toolBarTitle.setText("Home");
            fragmentTransaction.replace(R.id.frame_container,homeFragment,null);
            fragmentTransaction.commit();
        }

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        mDrawerContent = findViewById(R.id.cordinate);

        navigationMenu = findViewById(R.id.navigationMenu);
        navigationMenu.setOnClickListener(v->{
            drawer.openDrawer(GravityCompat.START);
        });

        /*------------------------------------ Navigation Drawer -----------------------------------*/
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                mDrawerContent.setTranslationX(slideX);
                mDrawerContent.setScaleX(1 - (slideOffset / scaleFactor));
                mDrawerContent.setScaleY(1 - (slideOffset / scaleFactor));
            }
        };

        drawer.setScrimColor(Color.TRANSPARENT);
        drawer.setDrawerElevation(1f);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*--------------------------------------------------------------------------------------------*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if(id == R.id.home){

//            Intent intent = new Intent(activity, RegisterActivity.class);
//            activity.startActivity(intent);

        }else if (id == R.id.serviceFees){

            HomeFragment fragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.commit();

        }else if (id == R.id.exchangeRate){

//            ProductDetailFragment fragment = new ProductDetailFragment();
//            FragmentTransaction transaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.frame_container, fragment);
//            transaction.commit();

        }else if (id == R.id.aboutUs){

            HomeFragment fragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.commit();

        }else if (id == R.id.contact){

//            Intent intent = new Intent(activity, MapsActivity.class);
//            activity.startActivity(intent);


        }else if (id == R.id.faq){

        }else if (id == R.id.orderForm){

        }else if (id == R.id.logOut){

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
