package com.xurxo.lollipopnewfeatures.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemDataFragment extends Fragment {
    TextView titleTextView;
    TextView descriptionTextView;
    TextView vibrantTextView ;
    TextView vibrantDarkTextView;
    TextView vibrantLightTextView;
    TextView mutedTextView;
    TextView mutedDarkTextView;
    TextView mutedLightTextView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_item_data, container, false);
        titleTextView = (TextView)rootView.findViewById(R.id.detailItemTitle);
        descriptionTextView = (TextView)rootView.findViewById(R.id.detailItemDescription);

        //Colors
        vibrantTextView = (TextView)rootView.findViewById(R.id.vibrant_color);
        vibrantDarkTextView = (TextView)rootView.findViewById(R.id.vibrant_dark_color);
        vibrantLightTextView = (TextView)rootView.findViewById(R.id.vibrant_light_color);
        mutedTextView = (TextView)rootView.findViewById(R.id.muted_color);
        mutedDarkTextView = (TextView)rootView.findViewById(R.id.muted_dark_color);
        mutedLightTextView = (TextView)rootView.findViewById(R.id.muted_light_color);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Item item = (Item) getActivity().getIntent().getSerializableExtra("item");

        titleTextView.setText(item.getTitle());
        descriptionTextView.setText(item.getDescription());
    }

    public void updatePalette(Palette palette){
        int defaultColor = Color.WHITE;

        int titleColor = palette.getVibrantColor(defaultColor);

        titleTextView.setBackgroundColor(titleColor);

        vibrantTextView.setBackgroundColor(palette.getVibrantColor(defaultColor));
        vibrantDarkTextView.setBackgroundColor(palette.getDarkVibrantColor(defaultColor));
        vibrantLightTextView.setBackgroundColor(palette.getLightVibrantColor(defaultColor));
        mutedTextView.setBackgroundColor(palette.getMutedColor(defaultColor));
        mutedDarkTextView.setBackgroundColor(palette.getDarkMutedColor(defaultColor));
        mutedLightTextView.setBackgroundColor(palette.getLightMutedColor(defaultColor));
    }
}
