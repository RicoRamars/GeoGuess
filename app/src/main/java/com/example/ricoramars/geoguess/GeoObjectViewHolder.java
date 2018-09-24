package com.example.ricoramars.geoguess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView geoImage;
    public boolean mGeoInEurope;
    public View view;

    public GeoObjectViewHolder(@NonNull View itemView) {
        super(itemView);
        geoImage = itemView.findViewById(R.id.geoImageView);
        view = itemView;
    }
}
