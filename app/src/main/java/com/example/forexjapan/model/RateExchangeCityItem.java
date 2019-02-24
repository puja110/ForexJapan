package com.example.forexjapan.model;

public class RateExchangeCityItem {

    private int flagImage;
    private String exchangeRate;

    public RateExchangeCityItem(int flagImage, String exchangeRate) {
        this.flagImage = flagImage;
        this.exchangeRate = exchangeRate;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(int flagImage) {
        this.flagImage = flagImage;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
