package com.example.forexjapan.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.forexjapan.R;
import com.example.forexjapan.model.RateExchangeCityItem;

import java.util.List;

public class RateExchangeCityAdapter extends RecyclerView.Adapter<RateExchangeCityAdapter.MyViewHolder> {

    Activity context;
    private List<RateExchangeCityItem> itemList;

    public RateExchangeCityAdapter(Activity context,  List<RateExchangeCityItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView exchangeRate;
        private ImageView flagImage;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);

            flagImage = (ImageView) view.findViewById(R.id.flagImage);
            exchangeRate = (TextView) view.findViewById(R.id.exchangeRate);

            cardView = (CardView)view.findViewById(R.id.rateExchangeCard);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country_exchange_rate, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final RateExchangeCityItem items = itemList.get(position);

        Log.d("itemTYpe", items+"");

        Glide.with(context)
                .load(items.getFlagImage())
                .into(holder.flagImage);

        holder.exchangeRate.setText(items.getExchangeRate());

        holder.cardView.setOnClickListener(v -> {

        });

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
