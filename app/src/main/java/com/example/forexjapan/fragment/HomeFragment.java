package com.example.forexjapan.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.forexjapan.R;
import com.example.forexjapan.activity.FullScreenActivity;
import com.example.forexjapan.activity.MapsActivity;
import com.example.forexjapan.activity.customerDetail.CustomerDetailActivity;
import com.example.forexjapan.adapter.RateExchangeCityAdapter;
import com.example.forexjapan.model.RateExchangeCityItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Context context;

    //slider
    private SliderLayout demoSlider;
    private LinearLayout linearLayout;

    @BindView(R.id.refer)
    TextView refer;

    @BindView(R.id.trackTransaction)
    TextView trackTransaction;

    @BindView(R.id.currencyConvert)
    TextView currencyConvert;

    @BindView(R.id.customerDetail)
    TextView customerDetail;

    /*---------------Rate Exchange city items----------------*/
    RecyclerView cityRecyclerView;
    private RecyclerView.LayoutManager cLayoutManager;
    RateExchangeCityAdapter cityAdapter;
    List<RateExchangeCityItem> cityItems;
    /*---------------------------------------------------*/

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        refer.setOnClickListener(v->{

            ReferFragment fragment = new ReferFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        });

        trackTransaction.setOnClickListener(v->{

           Intent intent = new Intent(getContext(), MapsActivity.class);
           startActivity(intent);

        });

        currencyConvert.setOnClickListener(v->{

            ConvertCurrencyFragment fragment = new ConvertCurrencyFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        });

        customerDetail.setOnClickListener(v->{

            Intent intent = new Intent(getContext(), CustomerDetailActivity.class);
            startActivity(intent);

        });


        //slider
        demoSlider = view.findViewById(R.id.sliderView);
        linearLayout = view.findViewById(R.id.pagesContainer);
        setupSlider();

        /*-----------------------Circle image-------------------------------------*/
        cityRecyclerView = (RecyclerView) view.findViewById(R.id.rateExchangeRecyclerView);

        cityItems = getExchangeRateItem();

        cityRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager cLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        cityRecyclerView.setLayoutManager(cLayoutManager);
        cityAdapter = new RateExchangeCityAdapter(getActivity(), cityItems);
        cityRecyclerView.setAdapter(cityAdapter);
        /*------------------------------------------------------------*/


        return view;
    }

    private List<RateExchangeCityItem> getExchangeRateItem() {

        cityItems = new ArrayList<RateExchangeCityItem>();

        cityItems.add(new RateExchangeCityItem(R.drawable.france, "01:23"));
        cityItems.add(new RateExchangeCityItem(R.drawable.brazil, "03.56"));
        cityItems.add(new RateExchangeCityItem(R.drawable.nepal, "02.67"));
        cityItems.add(new RateExchangeCityItem(R.drawable.france, "04.51"));

        cityItems.add(new RateExchangeCityItem(R.drawable.usa, "00.56"));
        cityItems.add(new RateExchangeCityItem(R.drawable.australia, "00.78"));
        cityItems.add(new RateExchangeCityItem(R.drawable.canada, "04.55"));
        cityItems.add(new RateExchangeCityItem(R.drawable.france, "0.78"));

        return cityItems;
    }

    //slider
    private void setupSlider() {
        final HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Dental care", R.drawable.everest3);
        file_maps.put("Blood", R.drawable.everest4);
        file_maps.put("bank", R.drawable.lumbini);

        for(String name : file_maps.keySet()){
            DefaultSliderView defaultSliderView = new DefaultSliderView(getContext());

            defaultSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider){

                    Intent intent = new Intent(getContext(), FullScreenActivity.class).putExtra("filemap", new Gson().toJson(file_maps));
                    startActivity(intent);
                }
            });

            // initialize a SliderLayout
            defaultSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle()
                    .putString("extra",name);

            demoSlider.addSlider(defaultSliderView);
        }
        demoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        demoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        demoSlider.setCustomAnimation(new DescriptionAnimation());
        demoSlider.setDuration(2000);
    }
}
