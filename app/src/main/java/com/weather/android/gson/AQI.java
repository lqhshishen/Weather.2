package com.weather.android.gson;

/**
 * Created by ll on 2017/9/26.
 */

public class AQI {
    public AQICity city;
    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
