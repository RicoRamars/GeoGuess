package com.example.ricoramars.geoguess;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public GeoObjectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final List<GeoObject> mGeoObjects = new ArrayList<>();
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IDS[i],
                    GeoObject.PRE_DEFINED_GEO_INEUROPE[i]));
        }

        recyclerView = findViewById(R.id.recyclerView);

        mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        recyclerView.setAdapter(mAdapter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        //Swipe controller
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int swipeDir) {
                GeoObjectViewHolder geoObjectViewHolder = (GeoObjectViewHolder)viewHolder;
                int position = (viewHolder.getAdapterPosition());
                mGeoObjects.remove(position);
                mAdapter.notifyItemRemoved(position);

                if (swipeDir == ItemTouchHelper.LEFT && geoObjectViewHolder.mGeoInEurope || swipeDir == ItemTouchHelper.RIGHT && !geoObjectViewHolder.mGeoInEurope) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
