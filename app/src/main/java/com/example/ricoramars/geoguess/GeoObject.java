package com.example.ricoramars.geoguess;

import com.example.ricoramars.geoguess.R;

public class GeoObject {

    private String mGeoName;
    private int mGeoImageName;
    private boolean mGeoInEurope;

    public GeoObject (String mGeoName, int mGeoImageName, boolean mGeoInEurope) {

        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
        this.mGeoInEurope = mGeoInEurope;
    }
    public String getmGeoName() {
        return mGeoName;
    }
    public void setmGeoName(String mGeoName) {
        this.mGeoName = mGeoName;
    }
    public int getmGeoImageName() {
        return mGeoImageName;
    }
    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }
    public boolean getmGeoInEurope() {
        return mGeoInEurope;
    }
    public void setmGeoInEurope(boolean mGeoInEurope) {
        this.mGeoInEurope = mGeoInEurope;
    }

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static final int[] PRE_DEFINED_GEO_OBJECT_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final boolean[] PRE_DEFINED_GEO_INEUROPE = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };

}
