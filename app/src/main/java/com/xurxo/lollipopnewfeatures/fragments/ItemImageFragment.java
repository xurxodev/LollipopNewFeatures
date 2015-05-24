package com.xurxo.lollipopnewfeatures.fragments;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemImageFragment extends Fragment {

    ImageView imageView;
    OnPaletteGeneratedListener onPaletteGeneratedListener;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_item_image, container, false);
        imageView = (ImageView)rootView.findViewById(R.id.detailItemImage);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Item item = (Item) getActivity().getIntent().getSerializableExtra("item");

        Picasso.with(imageView.getContext())
                .load(item.getImageUrl())
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                        Palette.generateAsync(((BitmapDrawable)imageView.getDrawable()).getBitmap(), new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                if (onPaletteGeneratedListener != null)
                                    onPaletteGeneratedListener.onPaletteGenerated(palette);
                            }
                        });
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnPaletteGeneratedListener) {
            onPaletteGeneratedListener = (OnPaletteGeneratedListener) activity;
        }
    }

    public static interface OnPaletteGeneratedListener {
        public void onPaletteGenerated(Palette palette);
    }
}
